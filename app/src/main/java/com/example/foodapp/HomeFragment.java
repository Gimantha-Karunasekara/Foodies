package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static ArrayList<FoodItem> featuredFoodItems;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.VISIBLE);
        TextView profile_name = view.findViewById(R.id.home_profile_name);
        ImageView home_logo = view.findViewById(R.id.home_logo);
        TextView welcome_msg = view.findViewById(R.id.home_welcome_msg);
        home_logo.setImageResource(R.drawable.foodies_logo);
        RecyclerView rv = view.findViewById(R.id.featured_rv);
        MainActivity main = (MainActivity)getActivity();
        main.getSupportActionBar().show();


        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());



        String logedIn = main.getLogedIn();
        featuredFoodItems = main.getFeaturedList();

        if (!logedIn.equals("undefined"))
        {
            welcome_msg.setText("Welcome back,");
            User user = foodAppDBModel.getUserByEmail(logedIn);
            profile_name.setText( user.getUsername());
        }
        else {
            welcome_msg.setText("Welcome");
            profile_name.setVisibility(View.GONE);
        }
        if (featuredFoodItems == null | featuredFoodItems.size() == 0)
        {
            featuredFoodItems = foodAppDBModel.getFeaturedFoodItems();
        }

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        FeaturedItemsAdapter featuredItemsAdapter = new FeaturedItemsAdapter(featuredFoodItems,getContext(),main,foodAppDBModel);
        rv.setAdapter(featuredItemsAdapter);

        return view;
    }
}