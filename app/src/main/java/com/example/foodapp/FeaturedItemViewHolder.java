package com.example.foodapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeaturedItemViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView restaurant;
    TextView price;
    ImageView img;
    ConstraintLayout layout;

    public FeaturedItemViewHolder(@NonNull View view, ArrayList<FoodItem> foodList)
    {
        super(view);

        title = view.findViewById(R.id.featured_txt_title);
        restaurant = view.findViewById(R.id.featured_item_restaurant);
        price = view.findViewById(R.id.featured_item_price);
        img = view.findViewById(R.id.featured_item_image);
        layout = view.findViewById(R.id.featured_layout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavController navController = Navigation.findNavController(view);
                HomeFragmentDirections.ActionHomeToRestaurantFragment direction
                        = HomeFragmentDirections.actionHomeToRestaurantFragment();
                direction.setRedirectRestaurantID(foodList.get(getAdapterPosition()).getRest_id());
                navController.navigate(direction);
            }
        });


    }
}