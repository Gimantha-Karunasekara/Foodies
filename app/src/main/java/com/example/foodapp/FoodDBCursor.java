package com.example.foodapp;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.foodapp.FoodDBSchema.restaurantTable;
import com.example.foodapp.FoodDBSchema.userTable;

public class FoodDBCursor extends CursorWrapper
{
    public FoodDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Restaurant getRestaurant(){
        int id = getInt(getColumnIndex(restaurantTable.Cols.ID));
        String name = getString(getColumnIndex(restaurantTable.Cols.NAME));
        String desc = getString(getColumnIndex(restaurantTable.Cols.DESC));
//        String desc = "blah";
        return new Restaurant(id,name,desc);
    }

    public User getUseres()
    {
        String username = getString(getColumnIndex(userTable.Cols.USERNAME));
        String email = getString(getColumnIndex(userTable.Cols.EMAIL));
        String password = getString(getColumnIndex(userTable.Cols.PASSWORD));
        String address = getString(getColumnIndex(userTable.Cols.ADDRESS));
        int phone = getInt(getColumnIndex(userTable.Cols.PHONE));
        User user = new User(username,email,password);
        return user;
    }
}
