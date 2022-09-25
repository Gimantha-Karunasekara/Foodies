package com.example.foodapp;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.foodapp.FoodDBSchema.purchaseTable;
import com.example.foodapp.FoodDBSchema.itemsTable;
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
        int img = getInt(getColumnIndex(restaurantTable.Cols.IMG));
        return new Restaurant(id,name,desc,img);
    }

    public User getUser()
    {
        String username = getString(getColumnIndex(userTable.Cols.USERNAME));
        String email = getString(getColumnIndex(userTable.Cols.EMAIL));
        String password = getString(getColumnIndex(userTable.Cols.PASSWORD));
        String address = getString(getColumnIndex(userTable.Cols.ADDRESS));
        int phone = getInt(getColumnIndex(userTable.Cols.PHONE));
        User user = new User(username,email,password, address, phone);
        return user;
    }

    public FoodItem getFoodItem()
    {
        int id = getInt(getColumnIndex(itemsTable.Cols.ID));
        String name = getString(getColumnIndex(itemsTable.Cols.NAME));
        String desc = getString(getColumnIndex(itemsTable.Cols.DESC));
        int img = getInt(getColumnIndex(itemsTable.Cols.IMAGE));
        float price = getFloat(getColumnIndex(itemsTable.Cols.PRICE));
        int restaurant_id = getInt(getColumnIndex(itemsTable.Cols.RESTAURANT_ID));
        FoodItem item = new FoodItem(id, name, desc,img,price,restaurant_id);
        return item;
    }

    public CartItem getCartItem()
    {
        int id = getInt(getColumnIndex(purchaseTable.Cols.ITEM_ID));
        int count = getInt(getColumnIndex(purchaseTable.Cols.COUNT));
        String user_email = getString(getColumnIndex(purchaseTable.Cols.USER_EMAIL));
        String date_time = getString(getColumnIndex(purchaseTable.Cols.DATE_TIME));
        CartItem cartItem = new CartItem(id,count,user_email,date_time);
        return cartItem;
    }
}
