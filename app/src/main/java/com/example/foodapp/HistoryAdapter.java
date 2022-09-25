package com.example.foodapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private ArrayList<CartItem> cartItems;
    private FoodDBModel dbModel;

    public HistoryAdapter(ArrayList<CartItem> cartItems)
    {
        this.cartItems = cartItems;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartItem cartItem = cartItems.get(holder.getAdapterPosition());
        FoodItem foodItem = dbModel.getFoodItemById(cartItem.getItem_id());
        Restaurant restaurant = dbModel.getRestaurantByID(foodItem.getRest_id());
        String title = restaurant.getName()+" - "+foodItem.getName();
        String count = "Count : "+cartItem.getCount();
        @SuppressLint("DefaultLocale") String price = "Rs. "+String.format("%.2f", foodItem.getPrice() * cartItem.getCount());
        holder.cart_itemTitle.setText(title);
        holder.cart_itemCount.setText(count);
        holder.cart_itemPrice.setText(price);
        holder.cart_itemDateTime.setText(cartItem.getDate_time());
        holder.cart_itemAdd.setVisibility(View.INVISIBLE);
        holder.cart_itemRemove.setVisibility(View.INVISIBLE);

    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        dbModel = new FoodDBModel();
        dbModel.load(parent.getContext());

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cartitem_itemview, parent, false);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder;
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
