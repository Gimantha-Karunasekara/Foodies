/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class ItemInfoFragment extends Fragment {


    private int itemCount;

    public ItemInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.GONE);
        View view = inflater.inflate(R.layout.fragment_item_info, container, false);
        ImageView image = view.findViewById(R.id.info_image);
        TextView title = view.findViewById(R.id.info_title);
        TextView description = view.findViewById(R.id.info_description);
        TextView count = view.findViewById(R.id.info_itemCount);
        TextView price_txt = view.findViewById(R.id.info_price);
        Button add_btn = view.findViewById(R.id.info_add_btn);
        Button remove_btn = view.findViewById(R.id.info_remove_btn);
        Button add_to_cart = view.findViewById(R.id.info_addToCart_btn);
        FloatingActionButton back_btn = view.findViewById(R.id.info_back_btn);
        MainActivity main = (MainActivity)getActivity();
        main.getSupportActionBar().hide();


        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());
        String loggedIn = main.getLoggedIn();
        ArrayList<CartItem> cartList = main.getCartList();

        // args
        Bundle bundle = getArguments();
        ItemInfoFragmentArgs args = ItemInfoFragmentArgs.fromBundle(bundle);

        //DB
        FoodItem foodItem = foodAppDBModel.getFoodItemById(args.getFoodItemID());

        image.setImageResource(foodItem.getImg());
        title.setText(foodItem.getName());
        description.setText(foodItem.getDesc());
        Float price = foodItem.getPrice();
        @SuppressLint("DefaultLocale") String priceString = "Rs. "+String.format("%.2f", price);
        price_txt.setText(priceString);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount = Integer.parseInt(count.getText().toString());
                count.setText(String.valueOf(itemCount+1));
            }
        });

        remove_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount = Integer.parseInt(count.getText().toString());
                if(itemCount > 0){
                    count.setText(String.valueOf(itemCount-1));
                }
            }
        });


        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(Integer.parseInt(count.getText().toString()) <= 0)
                    {
                        Toast.makeText(view.getContext(), "Please select amount", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        CartItem cartItem = new CartItem(
                                foodItem.getID(),
                                Integer.parseInt(count.getText().toString()), loggedIn,"time");
                        cartList.add(cartItem);
                        // show snack bar above bottom nav - https://stackoverflow.com/questions/36332487/move-snackbar-above-the-bottom-bar
                        Snackbar snackbar = Snackbar.make(view,"Items added to cart",Snackbar.LENGTH_SHORT);
                        snackbar.setAnchorView(navBar);
                        snackbar.show();
                        navController.popBackStack();
                    }

            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.popBackStack();
            }
        });

        return view;
    }
}