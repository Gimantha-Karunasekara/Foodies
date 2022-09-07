package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {

    private ArrayList<Restaurant> restaurantList;
    private Context context;

    public RestaurantAdapter(ArrayList<Restaurant> restaurantList, Context c)
    {
        this.restaurantList = restaurantList;
        this.context = c;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from((parent.getContext()));
        View view = layoutInflater.inflate(R.layout.restaurants_itemview, parent, false);
        RestaurantViewHolder restaurantViewHolder = new RestaurantViewHolder(view,restaurantList);
        return  restaurantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.restaurant_img.setImageResource(restaurantList.get(position).getImg_drawableId());
        holder.restaurant_name_label.setText(restaurantList.get(position).getName());
//        NavController navController = Navigation.findNavController(,R.id.nav_host_fragment);
//
//        holder.restaurant_name_label.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navController.navigate(R.id.action_restaurantFragment_to_foodItemsFragment);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
