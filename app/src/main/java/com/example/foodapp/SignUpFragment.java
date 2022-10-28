/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SignUpFragment extends Fragment {




    public SignUpFragment() {
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
        navBar.setVisibility(View.GONE);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);


        NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
        EditText name_txt = view.findViewById(R.id.name_txt);
        EditText email_txt = view.findViewById(R.id.email_txt);
        EditText password_txt = view.findViewById(R.id.password_txt);
        EditText phone_txt = view.findViewById(R.id.phone_txt);
        EditText address_txt= view.findViewById(R.id.address_txt);
        FloatingActionButton back_btn = view.findViewById(R.id.signup_back_btn);
        MainActivity main = (MainActivity)getActivity();
        main.getSupportActionBar().hide();


        Button signup_btn = view.findViewById(R.id.signup_btn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String name = name_txt.getText().toString();
                    String email = email_txt.getText().toString();
                    String password = password_txt.getText().toString();
                    String address = address_txt.getText().toString();
                    int phone = Integer.parseInt(phone_txt.getText().toString());

                    if (email.indexOf('@') == -1 || email.indexOf('.') == -1)
                    {
                        Toast.makeText(view.getContext(),"Enter a valid email",Toast.LENGTH_SHORT).show();
                    }
                    else if (name.equals("") || email.equals("") || password.equals("") || address.equals(""))
                    {
                        Toast.makeText(view.getContext(),"All fields required !",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        FoodDBModel foodAppDBModel = new FoodDBModel();
                        foodAppDBModel.load(view.getContext());

                        User newUser = new User(name, email, password, address, phone);
                        foodAppDBModel.addUser(newUser);

                        Toast.makeText(view.getContext(),"Signup successful, Please Log in !",Toast.LENGTH_SHORT).show();
                        navController.popBackStack();
                    }

                }
                catch (Exception e)
                {
                    Log.e("Error",e.getMessage());
                    Toast.makeText(getContext(),"Email already registered !",Toast.LENGTH_SHORT).show();
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