package com.example.foodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FoodItemsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ArrayList<FoodItem> foodItems;

    public FoodItemsFragment() {
    }

    public static FoodItemsFragment newInstance(String param1, String param2) {
        FoodItemsFragment fragment = new FoodItemsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_items, container, false);
        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        Bundle bundle = getArguments();

        FoodItemsFragmentArgs args = FoodItemsFragmentArgs.fromBundle(bundle);

        foodItems = foodAppDBModel.getFoodItems(args.getRestaurantID());// food items list

        Log.d("args", String.valueOf(args.getRestaurantID()));

        RecyclerView rv = view.findViewById(R.id.foodItemsRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        FoodItemsAdapter foodItemsAdapter = new FoodItemsAdapter(foodItems,getContext());
        rv.setAdapter(foodItemsAdapter);


//        FoodDBModel foodAppDBModel = new FoodDBModel();
//        foodAppDBModel.load(view.getContext());
//
//        foodAppDBModel.getFoodItems();


        return view;
    }
}