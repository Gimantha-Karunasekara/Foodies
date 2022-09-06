package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        db.insert(restaurantTable.NAME, null, cv);
    }

    public ArrayList<Restaurant> getAllRestaurants(){
        Log.d("value :","getallrest");
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
}
