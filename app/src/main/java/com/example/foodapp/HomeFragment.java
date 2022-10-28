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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);

        navBar.setVisibility(View.VISIBLE);
        TextView profile_name = view.findViewById(R.id.home_profile_name);
        ImageView home_logo = view.findViewById(R.id.home_logo);
        TextView welcome_msg = view.findViewById(R.id.home_welcome_msg);
        home_logo.setImageResource(R.drawable.foodies_logo);
        RecyclerView rv = view.findViewById(R.id.featured_rv);
        MainActivity main = (MainActivity)getActivity();
        ArrayList<FoodItem> featuredFoodItems = main.getFeaturedList();
        main.getSupportActionBar().show();


        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        String logedIn = main.getLoggedIn();

        if (!logedIn.equals("undefined"))
        {
            welcome_msg.setText("Welcome back,");
            User user = foodAppDBModel.getUserByEmail(logedIn);
            profile_name.setText( user.getUsername());
        }
        else {
            welcome_msg.setText("Welcome");
            profile_name.setVisibility(View.GONE);
        }
        if (featuredFoodItems == null | featuredFoodItems.size() == 0)
        {
            featuredFoodItems = foodAppDBModel.getFeaturedFoodItems();
        }

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        FeaturedItemsAdapter featuredItemsAdapter = new FeaturedItemsAdapter(featuredFoodItems,foodAppDBModel);
        rv.setAdapter(featuredItemsAdapter);

        return view;
    }
}