package com.kratos.keepfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
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

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.splashScreenFragment
                    || destination.getId() == R.id.authenticationFragment
                    || destination.getId() == R.id.forgotPasswordFragment
                    || destination.getId() == R.id.registerFragment
                    || destination.getId() == R.id.loginFragment
                    || destination.getId() == R.id.detailsFragment
                    || destination.getId() == R.id.enterDetailsFragment
                    || destination.getId() == R.id.verifyFragment
                    || destination.getId() == R.id.mainFragment
                    || destination.getId() == R.id.stepsFragment){
                bottomNavigationView.setVisibility(View.GONE);
            }
            else{
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}