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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
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
                    Toast.makeText(getContext(),"Email already registed !",Toast.LENGTH_SHORT).show();;
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

    private void signup(View view)
    {


    }
}