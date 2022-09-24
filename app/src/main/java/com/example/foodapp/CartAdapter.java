package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private ArrayList<CartItem> cartList;
    private Context context;
    private CartFragment cartFragment;

    public CartAdapter (ArrayList<CartItem> cartList, Context context, CartFragment cartFragment)
    {
        this.cartList = cartList;
        this.context = context;
        this.cartFragment = cartFragment;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        FoodDBModel dbModel = new FoodDBModel();
        dbModel.load(context);
        CartItem cartItem = cartList.get(holder.getAdapterPosition());
        FoodItem foodItem = dbModel.getFoodItemById(cartItem.getItem_id());
        @SuppressLint("DefaultLocale") String price = String.format("%.2f", foodItem.getPrice() * cartItem.getCount());
        String priceString = "Rs. "+String.valueOf(foodItem.getPrice() * cartItem.getCount());

        holder.cart_itemTitle.setText(foodItem.getName());
        holder.cart_itemCount.setText(String.valueOf(cartItem.getCount()));
        holder.cart_itemPrice.setText(priceString);

        holder.cart_itemAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cart_itemCount.setText(String.valueOf(Integer.parseInt(holder.cart_itemCount.getText().toString())+1));
                cartList.get(holder.getAdapterPosition()).setCount(Integer.parseInt(holder.cart_itemCount.getText().toString()));
                holder.cart_itemPrice.setText(String.valueOf(foodItem.getPrice() * cartItem.getCount()));
                notifyItemChanged(holder.getAdapterPosition());

                cartFragment.updateTotal();
            }
        });
        holder.cart_itemRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cart_itemCount.setText(String.valueOf(Integer.parseInt(holder.cart_itemCount.getText().toString())-1));
                cartList.get(holder.getAdapterPosition()).setCount(Integer.parseInt(holder.cart_itemCount.getText().toString()));
                if (cartList.get(holder.getAdapterPosition()).getCount() <= 0)
                {
                    cartList.remove(holder.getAdapterPosition());
                    notifyItemChanged(holder.getAdapterPosition());
                    notifyItemRangeChanged(1,getItemCount());
                    notifyDataSetChanged();
                }
                else
                {
                    holder.cart_itemPrice.setText(String.valueOf(foodItem.getPrice() * cartItem.getCount()));
                    notifyItemChanged(holder.getAdapterPosition());
                }
                cartFragment.updateTotal();
            }
        });
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.cartitem_itemview, parent, false);
        CartViewHolder cartItemViewHolder = new CartViewHolder(view);
        return cartItemViewHolder;
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

}
