package com.example.foodapp;

import android.view.View;

public class SeedDatabse {

    public static void initAll(View view)
    {
        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        initRestaurantData(foodAppDBModel);
        initUseres(foodAppDBModel);
    }

    public static void initRestaurantData(FoodDBModel foodAppDBModel){

        Restaurant restaurant1 = new Restaurant(1,"Restaurant 1", "asdads");
        restaurant1.setDesc("this is a sample description bluh bluh bluh bluh bluh bluh bluh");
        restaurant1.setImg_drawableId(R.drawable.restaurants_icon);
        Restaurant restaurant2 = new Restaurant(2123,"Restaurant 2","asdasd");
        restaurant2.setDesc("this is a sample description");
        foodAppDBModel.addRestaurant(restaurant1);
        foodAppDBModel.addRestaurant(restaurant2);
    }

    public static void initUseres(FoodDBModel foodAppDBModel)
    {
        User user = new User("Gimantha", "gimantha@gmail.com","gimantha123");
        user.setAddress("No50, subarathi road, kuliyapitiya");
        user.setPhone(077123123);
        foodAppDBModel.addUser(user);
    }
}
