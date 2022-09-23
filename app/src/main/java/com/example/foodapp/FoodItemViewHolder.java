package com.example.foodapp;

import android.content.Intent;
import android.os.Build;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodItemViewHolder extends RecyclerView.ViewHolder {
    TextView text_Title;
    TextView text_Description;
    TextView text_price;
    ImageView image_Item;
    CardView item_Card;

    private int itemCount;


    public FoodItemViewHolder(@NonNull View itemView, ArrayList<FoodItem> foodItems, LayoutInflater inflater, MainActivity mainActivity) {
        super(itemView);
        text_Title = itemView.findViewById(R.id.txt_title);
        text_Description = itemView.findViewById(R.id.txt_description);
        text_price = itemView.findViewById(R.id.item_price_txt);
        image_Item = itemView.findViewById(R.id.item_image);
        item_Card = itemView.findViewById(R.id.foodItem_card);




//        foodItemView_layout = itemView.findViewById(R.id.foodItem_ItemView_layout);
//
//        foodItemView_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        item_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                RestaurantPageFragmentDirections.ActionRestaurantPageFragmentToItemInfoFragment direction
                        = RestaurantPageFragmentDirections.actionRestaurantPageFragmentToItemInfoFragment();
                direction.setFoodItemID(foodItems.get(getAdapterPosition()).getID());
                navController.navigate(direction);


            }
        });


    }
}
