package com.example.foodapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantViewHolder extends RecyclerView.ViewHolder {
    ImageView restaurant_img;
    TextView restaurant_name_label;
    TextView restaurant_desc_label;
    public RestaurantViewHolder(@NonNull View view)
    {
        super(view);

        restaurant_img = view.findViewById(R.id.restaurant_img);
        restaurant_name_label = view.findViewById(R.id.restaurant_name_label);
        restaurant_desc_label = view.findViewById(R.id.restaurant_desc_label);

    }
}
