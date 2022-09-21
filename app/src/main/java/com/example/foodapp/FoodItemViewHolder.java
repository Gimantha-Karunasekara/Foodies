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
    Button btn_Add;
    Button btn_Remove;
    Button btn_AddCart;
    ConstraintLayout foodItemView_layout;

    private int itemCount;


    public FoodItemViewHolder(@NonNull View itemView, ArrayList<FoodItem> foodItems, LayoutInflater inflater, MainActivity mainActivity) {
        super(itemView);
        text_Title = itemView.findViewById(R.id.txt_title);
        text_Description = itemView.findViewById(R.id.txt_description);
        text_price = itemView.findViewById(R.id.item_price_txt);
        image_Item = itemView.findViewById(R.id.item_image);
        btn_Add = itemView.findViewById(R.id.item_add);
        btn_Remove = itemView.findViewById(R.id.item_remove);
        btn_AddCart = itemView.findViewById(R.id.item_cart);


        View popup = inflater.inflate(R.layout.description_popup, null);
        View main = inflater.inflate(R.layout.activity_main, null);
        TextView popup_Title = popup.findViewById(R.id.popup_title);
        TextView popup_Description = popup.findViewById(R.id.popup_description);



//        foodItemView_layout = itemView.findViewById(R.id.foodItem_ItemView_layout);
//
//        foodItemView_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        image_Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                FoodItemsFragmentDirections.ActionFoodItemsFragmentToItemInfoFragment direction
                        = FoodItemsFragmentDirections.actionFoodItemsFragmentToItemInfoFragment();
                direction.setFoodItemID(foodItems.get(getAdapterPosition()).getID());
                navController.navigate(direction);


            }
        });




        text_Description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setAlpha(0.1f);
                FoodItem foodItem = foodItems.get(getAdapterPosition());
                popup_Title.setText(foodItem.getName());
                popup_Description.setText(foodItem.getDesc());

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true;
                popup.setElevation(20);
                final PopupWindow popupWindow = new PopupWindow(popup, width, height, focusable);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onDismiss() {
                        popupWindow.dismiss();

                    }
                });

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            }
        });

    }
}
