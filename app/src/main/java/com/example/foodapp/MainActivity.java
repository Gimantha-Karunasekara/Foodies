package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager frag = getSupportFragmentManager();

        NavHostFragment homeFragment = (NavHostFragment) frag.findFragmentById(R.id.nav_host_fragment);
        if (homeFragment == null)
        {
            homeFragment = new NavHostFragment();
            frag.beginTransaction().add(R.id.nav_host_fragment,homeFragment).commit();
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);


        NavController navController = homeFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNav, navController);


    }


}