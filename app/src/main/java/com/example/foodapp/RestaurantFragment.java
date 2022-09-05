package com.example.foodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

        Restaurant restaurant1 = new Restaurant(1,"Restaurant 1");
        restaurant1.setDesc("this is a sample description");
        restaurant1.setImg_drawableId(R.drawable.restaurants_icon);
        Restaurant restaurant2 = new Restaurant(2,"Restaurant 2");
        restaurant2.setDesc("this is a sample description");
        restaurantArrayList.add(restaurant1);
        restaurantArrayList.add(restaurant2);


        RecyclerView rv = view.findViewById(R.id.restaurant_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantArrayList);
        rv.setAdapter(restaurantAdapter);

        return view;
    }
}