package com.example.foodapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {

    private ArrayList<Restaurant> restaurantList;

    public RestaurantsAdapter(ArrayList<Restaurant> restaurantList)
    {
        this.restaurantList = restaurantList;
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

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
