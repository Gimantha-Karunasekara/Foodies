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
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        MainActivity main = (MainActivity)getActivity();
        String logedIn = main.getLogedIn();


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


            ArrayList<CartItem> orderHistory = foodAppDBModel.getCartListByEmail(main.getLogedIn());

            RecyclerView rv = view.findViewById(R.id.order_history_rv);
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            HistoryAdapter adapter = new HistoryAdapter(orderHistory);
            rv.setAdapter(adapter);

        }

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.setLogedInUE("undefined");
                navController.navigate(R.id.loginFragment);
            }
        });




        return view;
    }
}