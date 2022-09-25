package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodapp.FoodDBSchema.purchaseTable;
import com.example.foodapp.FoodDBSchema.itemsTable;
import com.example.foodapp.FoodDBSchema.restaurantTable;
import com.example.foodapp.FoodDBSchema.userTable;

import java.util.ArrayList;

public class FoodDBModel {
    SQLiteDatabase db;

    public void load(Context context){
        this.db = new FoodDBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(Restaurant restaurant){
        ContentValues cv = new ContentValues();
        cv.put(restaurantTable.Cols.ID, restaurant.getRest_Id());
        cv.put(restaurantTable.Cols.NAME, restaurant.getName());
        cv.put(restaurantTable.Cols.DESC, restaurant.getDesc());
        cv.put(restaurantTable.Cols.IMG, restaurant.getImg_drawableId());
        db.insert(restaurantTable.NAME, null, cv);
    }

    public ArrayList<Restaurant> getAllRestaurants(){
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        Cursor cursor = db.query(restaurantTable.NAME ,null,null,null,null,null,null);
        FoodDBCursor foodDBCursor = new FoodDBCursor(cursor);

        try{
            foodDBCursor.moveToFirst();
            while(!foodDBCursor.isAfterLast()){
                restaurantList.add(foodDBCursor.getRestaurant());
                foodDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return restaurantList;
    }

    public Restaurant getRestaurantByID(int id)
    {
        Cursor cursor = db.rawQuery("SELECT * FROM "+restaurantTable.NAME+" WHERE "+restaurantTable.Cols.ID+" = "+ id ,null);
        FoodDBCursor restaurantCursor = new FoodDBCursor(cursor);
        Restaurant restaurant;
        try{
            restaurantCursor.moveToFirst();
            restaurant = restaurantCursor.getRestaurant();
        }
        finally {
            cursor.close();
        }
        return restaurant;
    }

    public void addUser (User user)
    {
        ContentValues cv = new ContentValues();
        cv.put(userTable.Cols.USERNAME, user.getUsername());
        cv.put(userTable.Cols.EMAIL, user.getEmail());
        cv.put(userTable.Cols.PASSWORD,user.getPassword());
        cv.put(userTable.Cols.ADDRESS, user.getAddress());
        cv.put(userTable.Cols.PHONE, user.getPhone());
        db.insertOrThrow(userTable.NAME, null, cv);
    }

    public User getUserByEmail(String email)
    {
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ? LIMIT 1", new String[]{email});
        FoodDBCursor userCursor= new FoodDBCursor(cursor);
        User user;
        try{
            if (cursor.getCount() == 0)
                return null;
            userCursor.moveToFirst();
            user = userCursor.getUser();
        }
        finally {
            cursor.close();
        }
        return user;
    }

    public void addFoodItem(FoodItem foodItem)
    {
        try {
            ContentValues cv = new ContentValues();
            cv.put(itemsTable.Cols.NAME, foodItem.getName());
            cv.put(itemsTable.Cols.DESC, foodItem.getDesc());
            cv.put(itemsTable.Cols.IMAGE, foodItem.getImg());
            cv.put(itemsTable.Cols.PRICE, foodItem.getPrice());
            cv.put(itemsTable.Cols.RESTAURANT_ID, foodItem.getRest_id());
            db.insert(itemsTable.NAME, null, cv);

        }
        catch (Exception e)
        {
            Log.d("SQL error :",e.getMessage());
        }
    }

    public ArrayList<FoodItem> getFoodItems(int restaurant_id)
    {
        ArrayList<FoodItem> foodList = new ArrayList<>() ;
        Cursor cursor = db.rawQuery("SELECT * FROM "+itemsTable.NAME+" WHERE "+itemsTable.Cols.RESTAURANT_ID+" = "+restaurant_id, null);
        FoodDBCursor foodAppDBCursor = new FoodDBCursor(cursor);

        try{
            foodAppDBCursor.moveToFirst();
            while(!foodAppDBCursor.isAfterLast()){
                foodList.add(foodAppDBCursor.getFoodItem());
                foodAppDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodList;

    }

    public FoodItem getFoodItemById(int foodID)
    {
        FoodItem foodItem;
        Cursor cursor = db.rawQuery("SELECT * FROM "+itemsTable.NAME+" WHERE "+itemsTable.Cols.ID+" = "+foodID+" LIMIT 1", null);
        FoodDBCursor foodAppDBCursor = new FoodDBCursor(cursor);

        try{
            foodAppDBCursor.moveToFirst();
            foodItem = foodAppDBCursor.getFoodItem();
        }
        finally {
            foodAppDBCursor.close();
        }

        return foodItem;

    }

    public ArrayList<FoodItem> getFeaturedFoodItems()
    {
        ArrayList<FoodItem> foodList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+itemsTable.NAME+" ORDER BY RANDOM() LIMIT 20", null);
        FoodDBCursor foodAppDBCursor = new FoodDBCursor(cursor);

        try{
            foodAppDBCursor.moveToFirst();
            while(!foodAppDBCursor.isAfterLast()){
                foodList.add(foodAppDBCursor.getFoodItem());
                foodAppDBCursor.moveToNext();
            }

        }
        finally {
            foodAppDBCursor.close();
        }

        return foodList;
    }

    public void addCartItem(CartItem cartItem)
    {
        try{
            ContentValues cv = new ContentValues();
            cv.put(purchaseTable.Cols.ITEM_ID, cartItem.getItem_id());
            cv.put(purchaseTable.Cols.COUNT, cartItem.getCount());
            cv.put(purchaseTable.Cols.USER_EMAIL, cartItem.getUser_email());
            db.insert(purchaseTable.NAME,null,cv);
        }
        catch (Exception e)
        {
            Log.e("AddCartItem Error",e.getMessage());
            //for debugging purposes
        }

    }

    public ArrayList<CartItem> getCartListByEmail (String email)
    {
        ArrayList<CartItem> cartList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ purchaseTable.NAME+" WHERE "+ purchaseTable.Cols.USER_EMAIL+ " = '" +email+"'", null);
        FoodDBCursor foodAppDBCursor = new FoodDBCursor(cursor);
        try{
            foodAppDBCursor.moveToFirst();
            while(!foodAppDBCursor.isAfterLast()){
                cartList.add(foodAppDBCursor.getCartItem());
                foodAppDBCursor.moveToNext();
            }

        }
        finally {
            cursor.close();
        }

        return cartList;
    }
}
