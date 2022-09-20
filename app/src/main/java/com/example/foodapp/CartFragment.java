package com.example.foodapp;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
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
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static ArrayList<CartItem> cartList;
    private FoodDBModel dbModel;
    private TextView total_txt;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        Button checkout_btn = view.findViewById(R.id.btn_cart_checkout);
        RecyclerView rv = view.findViewById(R.id.cartItems_recycler);
        ConstraintLayout msg_layout = view.findViewById(R.id.cart_msg_layout);
        ImageView msg_img = view.findViewById(R.id.cart_msg_img);
        TextView msg_title = view.findViewById(R.id.cart_msg_title);
        TextView msg_description = view.findViewById(R.id.msg_description);
        FloatingActionButton back_btn = view.findViewById(R.id.cart_back_btn);
        total_txt = view.findViewById(R.id.cart_total_txt);

        dbModel = new FoodDBModel();
        dbModel.load(getContext());

        MainActivity main = (MainActivity)getActivity();
        cartList = main.getCartList();
        updateTotal();


        if (cartList.size() == 0)
        {
            rv.setVisibility(View.INVISIBLE);
            total_txt.setVisibility(View.INVISIBLE);
            checkout_btn.setVisibility(View.INVISIBLE);
            msg_layout.setVisibility(View.VISIBLE);
            msg_img.setImageResource(R.drawable.cart_icon);
            total_txt.setVisibility(View.INVISIBLE);
            msg_title.setText("Cart is empty");
            msg_description.setText("Add items to cart to view them here");
        }
        else
        {
            total_txt.setVisibility(View.VISIBLE);
            rv.setVisibility(View.VISIBLE);
            checkout_btn.setVisibility(View.VISIBLE);
            msg_layout.setVisibility(View.INVISIBLE);
            total_txt.setVisibility(View.VISIBLE);
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            CartAdapter adapter = new CartAdapter(cartList, getContext(), CartFragment.this);
            rv.setAdapter(adapter);

            checkout_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (CartItem cartItem: cartList) {
                        dbModel.addCartItem(cartItem);
                    }

                    rv.setVisibility(View.INVISIBLE);
                    total_txt.setVisibility(View.INVISIBLE);
                    msg_layout.setVisibility(View.VISIBLE);
                    checkout_btn.setVisibility(View.INVISIBLE);
                    msg_img.setImageResource(R.drawable.done_icon);
                    back_btn.setVisibility(View.VISIBLE);
                    msg_title.setText("Purchase Complete");
                    msg_description.setText("Your order will be delivered soon");
                    cartList.clear();

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
            total_txt.setText("Total: Rs. "+String.valueOf(total));
        }

    }

}