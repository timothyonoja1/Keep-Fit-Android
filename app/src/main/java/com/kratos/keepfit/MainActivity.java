package com.kratos.keepfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.kratos.keepfit.databinding.ActivityMainBinding;
import com.kratos.keepfit.fragments.SplashScreenFragment;

import dagger.hilt.android.AndroidEntryPoint;

/** Main Activity for app. */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(binding.mainActivityFragmentContainerView.getId());

        if (fragment == null) {
            fragment = new SplashScreenFragment();
            fm.beginTransaction().add(binding.mainActivityFragmentContainerView.getId(), fragment).commit();
        }
    }
}