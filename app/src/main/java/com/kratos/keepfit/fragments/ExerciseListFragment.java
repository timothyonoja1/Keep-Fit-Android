package com.kratos.keepfit.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kratos.keepfit.R;
import com.kratos.keepfit.adapters.ExerciseAdapter;
import com.kratos.keepfit.core.Exercise;
import com.kratos.keepfit.core.Group;
import com.kratos.keepfit.databinding.FragmentExerciseListBinding;
import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class ExerciseListFragment extends Fragment {

    private FragmentExerciseListBinding binding;
    private final List<Exercise> exercises = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentExerciseListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.profilePic.setOnClickListener(imageView -> {
            NavDirections action = ExerciseListFragmentDirections
                    .actionExerciseListFragmentToAccountFragment();
            Navigation.findNavController(imageView).navigate(action);
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String uri1 = "@drawable/lunges";
        String uri2 = "@drawable/barbell_chest";

        int imageResource = getResources().getIdentifier(uri1, null, requireActivity().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        exercises.add(new Exercise(1, "", "", res));

        imageResource = getResources().getIdentifier(uri2, null, requireActivity().getPackageName());
        res = getResources().getDrawable(imageResource);
        exercises.add(new Exercise(2, "", "", res));

        updateUI();
    }

    private void updateUI(){
        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(exercises);
        binding.recyclerView.setAdapter(exerciseAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}