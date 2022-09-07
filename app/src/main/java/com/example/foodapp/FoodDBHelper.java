package com.example.foodapp;

import static com.example.foodapp.FoodDBSchema.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "foodApp.db";

    public FoodDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+restaurantTable.NAME
                +"("+restaurantTable.Cols.ID+" Text PRIMARY KEY, "
                + restaurantTable.Cols.NAME+ " Text, "
                + restaurantTable.Cols.DESC+ " Text,"
                +restaurantTable.Cols.IMG+" INT);");
        sqLiteDatabase.execSQL("create table "+userTable.NAME+"" +
                "("+userTable.Cols.USERNAME+" Text, " +
                ""+ userTable.Cols.EMAIL+ " Text PRIMARY KEY, " +
                ""+userTable.Cols.PASSWORD+ " Text, " +
                ""+userTable.Cols.ADDRESS+" Text, " +
                ""+userTable.Cols.PHONE+" INT);");

        sqLiteDatabase.execSQL("create table "+itemsTable.NAME
                +"("+itemsTable.Cols.ID+" INT PRIMARY KEY,"
                +itemsTable.Cols.NAME+" Text, "
                +itemsTable.Cols.DESC+" Text, "
                +itemsTable.Cols.IMAGE+" Text, "
                +itemsTable.Cols.RESTAURANT_ID+" INT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS restaurants");
        onCreate(sqLiteDatabase);

    }
}
