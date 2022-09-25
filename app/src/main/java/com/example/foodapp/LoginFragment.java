package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;


public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_nav);
        navBar.setVisibility(View.VISIBLE);

        View view  = inflater.inflate(R.layout.fragment_login, container, false);
        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        EditText email_et = view.findViewById(R.id.email_text);
        EditText password_et = view.findViewById(R.id.password);
        Button login_btn = view.findViewById(R.id.login_btn);
        Button signup_btn = view.findViewById(R.id.loginpg_signup_btn);
        FloatingActionButton back_btn = view.findViewById(R.id.login_back_btn);
        MainActivity main = (MainActivity)getActivity();
        main.getSupportActionBar().hide();

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        BottomNavigationView b_nav = container.getRootView().findViewById(R.id.bottom_nav);


        String logedIn = main.getLogedIn();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email_et.getText().toString();
                String password = password_et.getText().toString();

                try {
                    User user = foodAppDBModel.getUserByEmail(email);

                    if (user.getPassword().equals(password))
                    {
                        ((MainActivity) getActivity()).setLogedInUE(email);
                        navController.popBackStack();
                    }
                    else
                    {
                        Toast.makeText(view.getContext(),"Email or password is wrong, Try again",Toast.LENGTH_SHORT).show();

                    }

                }
                catch (Exception e)
                {

                    Toast.makeText(view.getContext(),"Email or password is wrong, Try again",Toast.LENGTH_SHORT).show();
                }

            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_loginFragment_to_signUpFragment);

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