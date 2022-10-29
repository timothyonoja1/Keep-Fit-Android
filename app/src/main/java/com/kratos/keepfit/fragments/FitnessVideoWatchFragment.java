package com.kratos.keepfit.fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.kratos.keepfit.R;
import com.kratos.keepfit.databinding.FragmentFitnessVideoWatchBinding;
import com.kratos.keepfit.entities.FitnessVideo;
import com.kratos.keepfit.viewmodels.interfaces.FitnessProgrammesViewModel;
import com.kratos.keepfit.viewmodels.real.FitnessProgrammeViewModelImpl;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FitnessVideoWatchFragment extends Fragment {

    private FragmentFitnessVideoWatchBinding binding;
    private FitnessProgrammesViewModel fitnessProgrammesViewModel;
    private FitnessVideo fitnessVideo;
    private int currentPlaybackPositionInMilliSec;

    // Tag for the instance state bundle.
    private static final String PLAYBACK_TIME = "play_time";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFitnessVideoWatchBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        if (savedInstanceState != null) {
            currentPlaybackPositionInMilliSec = savedInstanceState.getInt(PLAYBACK_TIME);
        }

        MediaController controller = new MediaController(requireContext());
        controller.setMediaPlayer(binding.videoView);
        binding.videoView.setMediaController(controller);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fitnessProgrammesViewModel = new ViewModelProvider(requireActivity()).get(FitnessProgrammeViewModelImpl.class);
        fitnessProgrammesViewModel.getFitnessVideoItemUiState().observe(
                getViewLifecycleOwner(), result -> {

                    initializePlayer(result.getSelectedFitnessVideo());
                }
        );
    }

    @Override
    public void onStart() {
        super.onStart();
        fitnessProgrammesViewModel.getFitnessVideoItemUiState();
    }


    @Override
    public void onPause() {
        super.onPause();

        // In Android versions less than N (7.0, API 24), onPause() is the
        // end of the visual lifecycle of the app.  Pausing the video here
        // prevents the sound from continuing to play even after the app
        // disappears.
        //
        // This is not a problem for more recent versions of Android because
        // onStop() is now the end of the visual lifecycle, and that is where
        // most of the app teardown should take place.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            binding.videoView.pause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        // Media playback takes a lot of resources, so everything should be
        // stopped and released at this time.
        releasePlayer();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current playback position (in milliseconds) to the
        // instance state bundle.
        outState.putInt(PLAYBACK_TIME, binding.videoView.getCurrentPosition());
    }

    private void initializePlayer(FitnessVideo fitnessVideo) {

        // Buffer and decode the video sample.

        Uri videoUri = Uri.parse(fitnessVideo.getVideoUrl());
        binding.videoView.setVideoURI(videoUri);

        // Listener for onPrepared() event (runs after the media is prepared).
        binding.videoView.setOnPreparedListener(
                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        // Restore saved position, if available.
                        if (currentPlaybackPositionInMilliSec > 0) {
                            binding.videoView.seekTo(currentPlaybackPositionInMilliSec);
                        } else {
                            // Skipping to 1 shows the first frame of the video.
                            binding.videoView.seekTo(1);
                        }

                        // Start playing!
                        binding.videoView.start();
                    }
                });

        // Listener for onCompletion() event (runs after media has finished
        // playing).
        binding.videoView.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(requireContext(), R.string.toast_message, Toast.LENGTH_SHORT).show();

                        // Return the video position to the start.
                        binding.videoView.seekTo(0);
                    }
                });
    }

    private void releasePlayer() {
        binding.videoView.stopPlayback();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}