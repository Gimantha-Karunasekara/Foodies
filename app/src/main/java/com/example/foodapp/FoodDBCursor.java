package com.example.foodapp;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.foodapp.FoodDBSchema.restaurantTable;

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
}
