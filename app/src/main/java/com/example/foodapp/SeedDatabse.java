package com.example.foodapp;

import android.view.View;

import java.util.ArrayList;

public class SeedDatabse {

    private static boolean seeded = false;


    public static void initAll(View view)
    {

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        ArrayList<Restaurant> restaurants = foodAppDBModel.getAllRestaurants();

        if (restaurants.size() == 0)
        {
            initRestaurantData(foodAppDBModel);
            initUseres(foodAppDBModel);
            initFood(foodAppDBModel);
        }
    }

    public static void initRestaurantData(FoodDBModel foodAppDBModel){

        Restaurant restaurant1 = new Restaurant(1,"Burger King - Malabe"
                , "Every day, more than 11 million guests visit Burger King restaurants around the world." +
                " And they do so because our restaurants are known for serving high-quality, " +
                "great-tasting, and affordable food. Founded in 1954, Burger King is the second largest fast " +
                "food hamburger chain in the world. The original Home of the Whopper, our commitment to premium " +
                "ingredients, signature recipes, and family-friendly dining experiences is what has defined our brand for " +
                "more than 50 successful years.",R.drawable.res_bk);

        Restaurant restaurant2 = new Restaurant(1,"Pizza Hut - Pelawatta",
                "Pizza Hut is an American multinational restaurant chain and international " +
                        "franchise founded in 1958 in Wichita, Kansas by Dan and Frank Carney. " +
                        "They serve their signature pan pizza and other dishes " +
                        "including pasta, breadsticks and desserts.",R.drawable.res_pizzahut);
//
        foodAppDBModel.addRestaurant(restaurant1);
        foodAppDBModel.addRestaurant(restaurant2);
    }

    public static void initUseres(FoodDBModel foodAppDBModel)
    {
        try {

            User user = new User("Gimantha", "gimantha@gmail.com", "gimantha123",
                    "No50, subarathi road, kuliyapitiya", 077123123);
            foodAppDBModel.addUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void initFood(FoodDBModel foodAppDBModel)
    {
        FoodItem foodItem1 = new FoodItem(1,"Burger - type 1", "asdkadj",R.drawable.res_bk, 350.00f, 1);
        FoodItem foodItem2 = new FoodItem(2, "Burer - type 2", "this is a sample description", R.drawable.res_bk, 450.00f, 1);
        FoodItem foodItem3 = new FoodItem(3, "Burger - type 3"
                , "This is a veryyyy long description as you can see right here",R.drawable.res_bk, 234.56f, 1);
        foodAppDBModel.addFoodItem(foodItem1);
        foodAppDBModel.addFoodItem(foodItem2);
        foodAppDBModel.addFoodItem(foodItem3);
    }
}
