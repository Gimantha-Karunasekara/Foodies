package com.example.foodapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    ImageView restaurant_img;
    TextView restaurant_name_label;
    TextView restaurant_desc_label;
    ConstraintLayout restaurant_layout;
    public RestaurantViewHolder(@NonNull View view, ArrayList<Restaurant> restaurantList)
    {
        super(view);

        restaurant_img = view.findViewById(R.id.restaurant_img);
        restaurant_name_label = view.findViewById(R.id.restaurant_name_label);
        restaurant_desc_label = view.findViewById(R.id.restaurant_desc_label);
        restaurant_layout = view.findViewById(R.id.restaurant_itemView_layout);
        restaurant_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                RestaurantFragmentDirections.ActionRestaurantFragmentToFoodItemsFragment direction = RestaurantFragmentDirections.actionRestaurantFragmentToFoodItemsFragment();
                navController.navigate(direction);

            }
        });


    }
}