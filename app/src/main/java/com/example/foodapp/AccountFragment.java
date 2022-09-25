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
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class AccountFragment extends Fragment {

    public AccountFragment() {
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
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.VISIBLE);
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        TextView name_tv = view.findViewById(R.id.account_profile_name);
        TextView email_tv = view.findViewById(R.id.account_email);
        TextView address_tv = view.findViewById(R.id.account_address);
        TextView phone_tv = view.findViewById(R.id.account_phone);
        Button logout_btn = view.findViewById(R.id.account_logout_btn);
        MainActivity main = (MainActivity)getActivity();
        main.getSupportActionBar().show();

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        String logedIn = main.getLoggedIn();


        if (logedIn.equals("undefined"))
        {
            navController.navigate(R.id.action_accountFragment_to_loginFragment);
        }
        else {
            User user = foodAppDBModel.getUserByEmail(logedIn);

            name_tv.setText(user.getUsername());
            email_tv.setText(user.getEmail());
            address_tv.setText(user.getAddress());
            phone_tv.setText(String.valueOf(user.getPhone()));


            ArrayList<CartItem> orderHistory = foodAppDBModel.getCartListByEmail(main.getLoggedIn());

            RecyclerView rv = view.findViewById(R.id.order_history_rv);
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            HistoryAdapter adapter = new HistoryAdapter(orderHistory);
            rv.setAdapter(adapter);

        }

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setLoggedInUE("undefined");
                navController.navigate(R.id.loginFragment);
            }
        });




        return view;
    }
}