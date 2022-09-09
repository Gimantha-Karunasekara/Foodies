package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemViewHolder> {

    private ArrayList<FoodItem> foodItems;
    private Context context;

    public FoodItemsAdapter(ArrayList<FoodItem> foodItems, Context context) {
        this.foodItems = foodItems;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.fooditem_itemview, parent, false);
        FoodItemViewHolder foodItemViewHolder = new FoodItemViewHolder(view,foodItems);
        return foodItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemViewHolder holder, int position) {
        holder.image_Item.setImageResource(foodItems.get(position).getImg());
        holder.text_Title.setText(foodItems.get(position).getName());
        holder.text_Description.setText(foodItems.get(position).getDesc());


    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }
}
