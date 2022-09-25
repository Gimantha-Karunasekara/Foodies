package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private static String loggedInUE = "undefined"; // Currently logged in user
    private static ArrayList<CartItem> cartList = new ArrayList<>(); // cart item list
    private static ArrayList<FoodItem> featuredList = new ArrayList<>(); // home page food list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View v = getWindow().getDecorView().findViewById(R.id.homeFragment);

        SeedDatabase.initAll(v); // Initialize database (Add data to database of first run)

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
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        //Custom action bar - https://stackoverflow.com/questions/14483393/how-do-i-change-the-android-actionbar-title-and-icon


        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.homeFragment:
                        navController.navigate(R.id.homeFragment);
                        return true;

                    case R.id.restaurantsFragment:
                        navController.navigate(R.id.restaurantsFragment);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cartFragment:
                        navController.navigate(R.id.cartFragment);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.accountFragment:
                        navController.navigate(R.id.accountFragment);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    //Custom back action - https://stackoverflow.com/questions/2257963/how-to-show-a-dialog-to-confirm-that-the-user-wishes-to-exit-an-android-activity
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Do you want to exit ?").setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();

    }


    public String getLoggedIn(){return loggedInUE;}

    public void setLoggedInUE(String email){
        loggedInUE =email;}

    public ArrayList<CartItem> getCartList(){return cartList;}

    public ArrayList<FoodItem> getFeaturedList(){return featuredList;}

}