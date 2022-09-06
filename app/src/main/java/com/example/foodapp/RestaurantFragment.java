package com.example.foodapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        restaurantArrayList = foodAppDBModel.getAllRestaurants();

//        NavController navController = Navigation.findNavController();

        RecyclerView rv = view.findViewById(R.id.restaurant_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantArrayList);
        rv.setAdapter(restaurantAdapter);
        return view;
    }

}