package com.example.foodapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    private ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();

    public RestaurantFragment(){};

    public static RestaurantFragment newInstance() {

        Bundle args = new Bundle();

        RestaurantFragment fragment = new RestaurantFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_restaurant, container, false);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.VISIBLE);

        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        restaurantArrayList = foodAppDBModel.getAllRestaurants();

        Bundle bundle = getArguments();
        RestaurantFragmentArgs args = RestaurantFragmentArgs.fromBundle(bundle);
        MainActivity mainActivity;

        int redirectID = args.getRedirectRestaurantID();

        if (redirectID != 0)
        {
            RestaurantFragmentDirections.ActionRestaurantFragmentToFoodItemsFragment direction
                    = RestaurantFragmentDirections.actionRestaurantFragmentToFoodItemsFragment();
            direction.setRestaurantID(redirectID);
            redirectID = 0;
            navController.navigate(direction);
        }

//        NavController navController = Navigation.findNavController();

        RecyclerView rv = view.findViewById(R.id.restaurant_rv);
        FrameLayout frame = view.findViewById(R.id.restaurant_frame);
        String tag = (String)frame.getTag();
        if (tag.equals("restaurant_portrait"))
        {
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        }
        else
        {
            rv.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
        }
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantArrayList,getContext());
        rv.setAdapter(restaurantAdapter);
        return view;
    }

}