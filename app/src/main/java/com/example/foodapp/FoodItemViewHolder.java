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
    TextView text_price;
    TextView text_itemCount;
    ImageView image_Item;
    Button btn_Add;
    Button btn_Remove;
    Button btn_AddCart;
    ConstraintLayout foodItemView_layout;

    private int itemCount;


    public FoodItemViewHolder(@NonNull View itemView, ArrayList<FoodItem> foodItems) {
        super(itemView);

        text_Title = itemView.findViewById(R.id.txt_title);
        text_Description = itemView.findViewById(R.id.txt_description);
        text_itemCount = itemView.findViewById(R.id.itemView_itemCount_label);
        text_price = itemView.findViewById(R.id.item_price_txt);
        image_Item = itemView.findViewById(R.id.item_image);
        btn_Add = itemView.findViewById(R.id.item_add);
        btn_Remove = itemView.findViewById(R.id.item_remove);
        btn_AddCart = itemView.findViewById(R.id.item_cart);

//        foodItemView_layout = itemView.findViewById(R.id.foodItem_ItemView_layout);
//
//        foodItemView_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount = Integer.parseInt(text_itemCount.getText().toString());
                text_itemCount.setText(String.valueOf(itemCount+1));
            }
        });

        btn_Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount = Integer.parseInt(text_itemCount.getText().toString());
                text_itemCount.setText(String.valueOf(itemCount-1));
            }
        });

    }
}
