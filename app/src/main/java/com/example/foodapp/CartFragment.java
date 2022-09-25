package com.example.foodapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;


public class CartFragment extends Fragment {



    private static ArrayList<CartItem> cartList;
    private FoodDBModel dbModel;
    private TextView total_txt;



    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);


        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        Button checkout_btn = view.findViewById(R.id.btn_cart_checkout);
        RecyclerView rv = view.findViewById(R.id.cartItems_recycler);
        ImageView msg_img = view.findViewById(R.id.cart_msg_img);
        TextView msg_title = view.findViewById(R.id.cart_msg_title);
        TextView msg_description = view.findViewById(R.id.msg_description);
        FloatingActionButton back_btn = view.findViewById(R.id.cart_back_btn);
        total_txt = view.findViewById(R.id.cart_total_txt);
        MainActivity main = (MainActivity)getActivity();
        String logedIn = main.getLoggedIn();

        dbModel = new FoodDBModel();
        dbModel.load(getContext());

        cartList = main.getCartList();
        updateTotal();


        if (cartList.size() == 0)
        {
            navBar.setVisibility(View.VISIBLE);
            main.getSupportActionBar().show();
            rv.setVisibility(View.INVISIBLE);
            total_txt.setVisibility(View.INVISIBLE);
            checkout_btn.setVisibility(View.INVISIBLE);
            msg_img.setImageResource(R.drawable.cart_icon);
            total_txt.setVisibility(View.INVISIBLE);
            msg_title.setText("Cart is empty");
            msg_description.setText("Add items to cart to view them here");
        }
        else
        {
            navBar.setVisibility(View.GONE);
            main.getSupportActionBar().hide();
            total_txt.setVisibility(View.VISIBLE);
            rv.setVisibility(View.VISIBLE);
            checkout_btn.setVisibility(View.VISIBLE);
            total_txt.setVisibility(View.VISIBLE);
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            CartAdapter adapter = new CartAdapter(cartList, getContext(), CartFragment.this);
            rv.setAdapter(adapter);

            checkout_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (!logedIn.equals("undefined"))
                    {
                        User user = dbModel.getUserByEmail(logedIn);
                        for (CartItem cartItem: cartList) {
                            cartItem.setUser_email(user.getEmail());
                            dbModel.addCartItem(cartItem);
                        }

                        rv.setVisibility(View.INVISIBLE);
                        total_txt.setVisibility(View.INVISIBLE);
                        checkout_btn.setVisibility(View.INVISIBLE);
                        msg_img.setImageResource(R.drawable.done_icon);
                        back_btn.setVisibility(View.VISIBLE);
                        msg_title.setText("Purchase Complete");
                        msg_description.setText("Your order will be delivered soon");
                        cartList.clear();
                    }
                    else
                    {
                        NavController navController = Navigation.findNavController(view);
                        navController.navigate(R.id.action_cartFragment_to_loginFragment);
                    }




                }
            });
        }

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.popBackStack();
            }
        });



        return view;
    }

    public void updateTotal()
    {
        float total = 0;

        if (cartList != null)
        {
            for (CartItem item:cartList) {
                FoodItem food = dbModel.getFoodItemById(item.getItem_id());
                total += item.getCount() * food.getPrice();
            }
            @SuppressLint("DefaultLocale") String priceString = "Rs. "+String.format("%.2f", total);
            total_txt.setText(priceString);
        }

    }

}