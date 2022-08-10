package com.kratos.keepfit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.kratos.keepfit.databinding.ActivityMainBinding;
import dagger.hilt.android.AndroidEntryPoint;

/** Main Activity for app. */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}