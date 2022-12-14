/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment(){}

    public static RestaurantsFragment newInstance() {

        Bundle args = new Bundle();

        RestaurantsFragment fragment = new RestaurantsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_restaurants, container, false);
        RecyclerView rv = view.findViewById(R.id.restaurant_rv);
        FrameLayout frame = view.findViewById(R.id.restaurant_frame);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        MainActivity main = (MainActivity)getActivity();
        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());
        navBar.setVisibility(View.VISIBLE);
        main.getSupportActionBar().show();

        ArrayList<Restaurant> restaurantArrayList = foodAppDBModel.getAllRestaurants();

        // safe args
        Bundle bundle = getArguments();
        RestaurantsFragmentArgs args = RestaurantsFragmentArgs.fromBundle(bundle);

        int redirectID = args.getRedirectRestaurantID();

        if (redirectID != 0)
        {
            RestaurantsFragmentDirections.ActionRestaurantsFragmentToRestaurantPageFragment direction
                    = RestaurantsFragmentDirections.actionRestaurantsFragmentToRestaurantPageFragment();
            direction.setRestaurantID(redirectID);
            navController.navigate(direction);
        }

//        NavController navController = Navigation.findNavController();


        String tag = (String)frame.getTag();
        if (tag.equals("restaurant_portrait"))
        {
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        }
        else
        {
            rv.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
        }
        RestaurantsAdapter restaurantsAdapter = new RestaurantsAdapter(restaurantArrayList);
        rv.setAdapter(restaurantsAdapter);
        return view;
    }

}