package com.example.foodapp;

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
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int itemCount;

    public ItemInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemInfoFragment newInstance(String param1, String param2) {
        ItemInfoFragment fragment = new ItemInfoFragment();
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
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.GONE);
        View view = inflater.inflate(R.layout.fragment_item_info, container, false);
        ImageView image = view.findViewById(R.id.info_image);
        TextView title = view.findViewById(R.id.info_title);
        TextView description = view.findViewById(R.id.info_description);
        TextView count = view.findViewById(R.id.info_itemCount);
        TextView price = view.findViewById(R.id.info_price);
        Button add_btn = view.findViewById(R.id.info_add_btn);
        Button remove_btn = view.findViewById(R.id.info_remove_btn);
        Button add_to_cart = view.findViewById(R.id.info_addToCart_btn);


        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());
        MainActivity main = (MainActivity)getActivity();
        String logedIn = main.getLogedIn();
        ArrayList<CartItem> cartList = main.getCartList();

        // args
        Bundle bundle = getArguments();
        ItemInfoFragmentArgs args = ItemInfoFragmentArgs.fromBundle(bundle);

        //DB
        FoodItem foodItem = foodAppDBModel.getFoodItemById(args.getFoodItemID());

        image.setImageResource(foodItem.getImg());
        title.setText(foodItem.getName());
        description.setText(foodItem.getDesc());
        price.setText(String.valueOf(foodItem.getPrice()));


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
                count.setText(String.valueOf(itemCount-1));
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
                                Integer.parseInt(count.getText().toString()), logedIn,"time");
                        cartList.add(cartItem);
                        Snackbar.make(view,"Items added to cart",Snackbar.LENGTH_SHORT).show();
                        navController.popBackStack();
                    }

            }
        });

        return view;
    }
}