package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodapp.FoodDBSchema.itemsTable;
import com.example.foodapp.FoodDBSchema.restaurantTable;
import com.example.foodapp.FoodDBSchema.userTable;

import java.util.ArrayList;

public class FoodDBModel {
    SQLiteDatabase db;
    private static int curRestId = 0;
    private static int curFoodId =0;

    public void load(Context context){
        this.db = new FoodDBHelper(context).getWritableDatabase();
    }

    public void addRestaurant(Restaurant restaurant){
        ContentValues cv = new ContentValues();
        cv.put(restaurantTable.Cols.ID, curRestId+1);
        cv.put(restaurantTable.Cols.NAME, restaurant.getName());
        cv.put(restaurantTable.Cols.DESC, restaurant.getDesc());
        cv.put(restaurantTable.Cols.IMG, restaurant.getImg_drawableId());
        db.insert(restaurantTable.NAME, null, cv);
        curRestId += 1;
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

    public void addUser (User user)
    {
        ContentValues cv = new ContentValues();
        cv.put(userTable.Cols.USERNAME, user.getUsername());
        cv.put(userTable.Cols.EMAIL, user.getEmail());
        cv.put(userTable.Cols.PASSWORD,user.getPassword());
        cv.put(userTable.Cols.ADDRESS, user.getAddress());
        cv.put(userTable.Cols.PHONE, user.getPhone());
        db.insert(userTable.NAME, null, cv);
    };

    public User getUserByEmail(String email)
    {
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ? LIMIT 1", new String[]{email});
        FoodDBCursor userCursor= new FoodDBCursor(cursor);
        User user;
        try{
            userCursor.moveToFirst();
            user = userCursor.getUseres();
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
            cv.put(itemsTable.Cols.ID, curFoodId+1);
            cv.put(itemsTable.Cols.NAME, foodItem.getName());
            cv.put(itemsTable.Cols.DESC, foodItem.getDesc());
            cv.put(itemsTable.Cols.IMAGE, 1);
            cv.put(itemsTable.Cols.RESTAURANT_ID, foodItem.getRest_id());
            db.insert(itemsTable.NAME, null, cv);
            curFoodId += 1;

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
}
