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

        FoodDBModel studentDBModel = new FoodDBModel();
        studentDBModel.load(view.getContext());


        Restaurant restaurant1 = new Restaurant(1,"Restaurant 1", "asdads");
        restaurant1.setDesc("this is a sample description bluh bluh bluh bluh bluh bluh bluh");
        restaurant1.setImg_drawableId(R.drawable.restaurants_icon);
        Restaurant restaurant2 = new Restaurant(2,"Restaurant 2","asdasd");
        restaurant2.setDesc("this is a sample description");
        studentDBModel.addRestaurant(restaurant1);
//        studentDBModel.addRestaurant(restaurant2);

        restaurantArrayList = studentDBModel.getAllRestaurants();

//        NavController navController = Navigation.findNavController();

        RecyclerView rv = view.findViewById(R.id.restaurant_rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(restaurantArrayList);
        rv.setAdapter(restaurantAdapter);
        return view;
    }

}