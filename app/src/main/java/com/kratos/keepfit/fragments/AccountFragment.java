package com.kratos.keepfit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kratos.keepfit.adapters.GalleryAdapter;
import com.kratos.keepfit.adapters.ScheduleAdapter;
import com.kratos.keepfit.adapters.SpecialityAdapter;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.databinding.FragmentAccountBinding;
import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/** Fragment for user log in. */
@AndroidEntryPoint
public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.notificationImage.setOnClickListener(imageView -> {
            NavDirections action = AccountFragmentDirections
                    .actionAccountFragmentToProfileFragment();
            Navigation.findNavController(imageView).navigate(action);
        });
        binding.specialityListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.galleryListRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        binding.scheduleListRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality(1, "Lose weight and get toned"));
        specialities.add(new Speciality(2, "Gain flexibility"));
        specialities.add(new Speciality(3, "Build muscle and boost stamina"));
        specialities.add(new Speciality(4, "Athletic event or competition"));
        specialities.add(new Speciality(5, "Other injuries or medical conditions"));

        List<String> uris = new ArrayList<>();
        uris.add("@drawable/gallery_1");
        uris.add("@drawable/gallery_2");
        uris.add("@drawable/gallery_1");


        List<Gallery> galleries = new ArrayList<>();
        int i = 0;
        while (i < 3){
            int imageResource = getResources().getIdentifier(uris.get(i), null, requireActivity().getPackageName());
            galleries.add(new Gallery(1, uris.get(i), imageResource));
            ++i;
        }

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, "07:30 AM", "Available"));
        schedules.add(new Schedule(2, "08:00 AM", "Available"));
        schedules.add(new Schedule(3, "08:00 AM", "Booked"));
        schedules.add(new Schedule(4, "08:30 AM", "Booked"));

        updateUI(specialities, galleries, schedules);
    }

    private void updateUI(List<Speciality> specialities, List<Gallery> galleries, List<Schedule> schedules) {
        SpecialityAdapter specialityAdapter = new SpecialityAdapter(specialities);
        binding.specialityListRecyclerView.setAdapter(specialityAdapter);

        GalleryAdapter galleryAdapter = new GalleryAdapter(galleries);
        binding.galleryListRecyclerView.setAdapter(galleryAdapter);

        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(schedules);
        binding.scheduleListRecyclerView.setAdapter(scheduleAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}