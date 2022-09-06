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
        sqLiteDatabase.execSQL("create table "+restaurantTable.NAME+"("+restaurantTable.Cols.ID+" Text, "+ restaurantTable.Cols.NAME+ " Text, "+restaurantTable.Cols.DESC+ " Text);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS restaurants");
        onCreate(sqLiteDatabase);

    }
}
