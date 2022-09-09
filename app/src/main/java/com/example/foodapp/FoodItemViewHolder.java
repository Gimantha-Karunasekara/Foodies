package com.example.foodapp;

import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodItemViewHolder extends RecyclerView.ViewHolder {
    TextView text_Title;
    TextView text_Description;
    ImageView image_Item;
    Button btn_Add;
    Button btn_Remove;
    Button btn_AddCart;


    public FoodItemViewHolder(@NonNull View itemView, ArrayList<FoodItem> foodItems) {
        super(itemView);

        text_Title = itemView.findViewById(R.id.txt_title);
        text_Description = itemView.findViewById(R.id.txt_description);
        image_Item = itemView.findViewById(R.id.item_image);
        btn_Add = itemView.findViewById(R.id.item_add);
        btn_Remove = itemView.findViewById(R.id.item_remove);
        btn_AddCart = itemView.findViewById(R.id.item_cart);



        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btn_AddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
