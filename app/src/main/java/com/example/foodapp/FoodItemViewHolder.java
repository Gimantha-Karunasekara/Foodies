/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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


    public FoodItemViewHolder(@NonNull View itemView, ArrayList<FoodItem> foodItems) {
        super(itemView);
        text_Title = itemView.findViewById(R.id.txt_title);
        text_Description = itemView.findViewById(R.id.txt_description);
        text_price = itemView.findViewById(R.id.item_price_txt);
        image_Item = itemView.findViewById(R.id.item_image);
        item_Card = itemView.findViewById(R.id.foodItem_card);


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
