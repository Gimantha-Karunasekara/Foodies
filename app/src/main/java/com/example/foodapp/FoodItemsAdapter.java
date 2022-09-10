package com.example.foodapp;

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

public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemViewHolder> {

    private ArrayList<FoodItem> foodItems;
    private Context context;
    private ArrayList<CartItem> cartItems;
    private MainActivity main;

    public FoodItemsAdapter(ArrayList<FoodItem> foodItems,ArrayList<CartItem> cartItems, Context context, MainActivity main) {
        this.foodItems = foodItems;
        this.context = context;
        this.cartItems = cartItems;
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
        String logedIn = main.getLogedIn();
        String priceSring = "Rs. "+String.valueOf(foodItems.get(holder.getAdapterPosition()).getPrice());

        holder.text_Title.setText(foodItems.get(holder.getAdapterPosition()).getName());
        holder.text_Description.setText(foodItems.get(holder.getAdapterPosition()).getDesc());
        holder.text_price.setText(priceSring);

        holder.btn_AddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!logedIn.equals("undefined"))
                {
                    if(Integer.parseInt(holder.text_itemCount.getText().toString()) <= 0)
                    {
                        Toast.makeText(view.getContext(), "Please select amount", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        CartItem cartItem = new CartItem(
                                foodItems.get(holder.getAdapterPosition()).getID(),
                                Integer.parseInt(holder.text_itemCount.getText().toString()), logedIn,"time");
                        cartItems.add(cartItem);
                        Snackbar.make(view,"Items added to cart",Snackbar.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_foodItemsFragment_to_loginFragment);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }
}
