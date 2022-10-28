/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemViewHolder> {

    private ArrayList<FoodItem> foodItems;
    private MainActivity main;

    public FoodItemsAdapter(ArrayList<FoodItem> foodItems, MainActivity main) {
        this.foodItems = foodItems;
        this.main = main;
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
        Float price = foodItems.get(position).getPrice();
        @SuppressLint("DefaultLocale") String priceString = "Rs. "+String.format("%.2f", price);

        holder.text_Title.setText(foodItems.get(holder.getAdapterPosition()).getName());
        holder.text_Description.setText(foodItems.get(holder.getAdapterPosition()).getDesc());
        holder.text_price.setText(priceString);

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }
}
