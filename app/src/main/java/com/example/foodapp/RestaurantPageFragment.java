package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RestaurantPageFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ArrayList<FoodItem> foodItems;

    public RestaurantPageFragment() {
    }

    public static RestaurantPageFragment newInstance(String param1, String param2) {
        RestaurantPageFragment fragment = new RestaurantPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.VISIBLE);
        View view = inflater.inflate(R.layout.fragment_restaurant_page, container, false);
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        TextView title = view.findViewById(R.id.restaurant_detail_title);
        ImageView img = view.findViewById(R.id.restaurant_detail_img);
        FloatingActionButton back_btn = view.findViewById(R.id.restaurants_back_btn);

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());
        MainActivity main = (MainActivity)getActivity();
        ArrayList<CartItem> cartList = main.getCartList();

        // args
        Bundle bundle = getArguments();
        RestaurantPageFragmentArgs args = RestaurantPageFragmentArgs.fromBundle(bundle);

        //DB
        foodItems = foodAppDBModel.getFoodItems(args.getRestaurantID());// food items list
        Restaurant restaurant = foodAppDBModel.getRestaurantByID(args.getRestaurantID());


        title.setText(restaurant.getName());
        img.setImageResource(restaurant.getImg_drawableId());


        RecyclerView rv = view.findViewById(R.id.foodItemsRecyclerView);
        FloatingActionButton cartButton =  view.findViewById(R.id.cart_button);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        FoodItemsAdapter foodItemsAdapter = new FoodItemsAdapter(foodItems,cartList,getContext(),main);
        rv.setAdapter(foodItemsAdapter);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.RestaurantPageFragment_to_cartFragment);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_restaurantPageFragment_to_restaurantsFragment);
            }
        });

        return view;
    }
}