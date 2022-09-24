package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class FeaturedItemsAdapter extends RecyclerView.Adapter<FeaturedItemViewHolder> {

    private ArrayList<FoodItem> foodItems;
    private MainActivity main;
    private FoodDBModel foodDBModel;

    public FeaturedItemsAdapter(ArrayList<FoodItem> foodItems, Context context, MainActivity main, FoodDBModel foodDBModel) {
        this.foodItems = foodItems;
        this.main = main;
        this.foodDBModel = foodDBModel;
    }

    @NonNull
    @Override
    public FeaturedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.featured_itemview, parent, false);
        FeaturedItemViewHolder featuredItemViewHolder = new FeaturedItemViewHolder(view, foodItems);
        return featuredItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedItemViewHolder holder, int position) {
        FoodItem foodItem = foodItems.get(position);
        Restaurant restaurant = foodDBModel.getRestaurantByID(foodItem.getRest_id());

        holder.img.setImageResource(foodItems.get(position).getImg());
        Float price = foodItems.get(position).getPrice();
        @SuppressLint("DefaultLocale") String priceString = "Rs. "+String.format("%.2f", price);

        holder.title.setText(foodItems.get(holder.getAdapterPosition()).getName());
        holder.price.setText(priceString);
        holder.restaurant.setText(restaurant.getName());



    }




    @Override
    public int getItemCount() {
        return foodItems.size();
    }
}
