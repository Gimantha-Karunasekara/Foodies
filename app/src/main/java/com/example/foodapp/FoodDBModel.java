package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FoodDBModel {
    SQLiteDatabase db;

    public void load(Context context){
        this.db = new FoodDBHelper(context).getWritableDatabase();
    }

//    public void addStudent(Student student){
//        ContentValues cv = new ContentValues();
//        cv.put(studentTable.Cols.ID, student.getId());
//        cv.put(studentTable.Cols.NAME, student.getName());
//        db.insert(studentTable.NAME, null, cv);
//    }
//
//    public ArrayList<Student> getAllStudent(){
//        ArrayList<Student> studentList = new ArrayList<>();
//        Cursor cursor = db.query(studentTable.NAME,null,null,null,null,null,null);
//        StudentDBCursor studentDBCursor = new StudentDBCursor(cursor);
//
//        try{
//            studentDBCursor.moveToFirst();
//            while(!studentDBCursor.isAfterLast()){
//                studentList.add(studentDBCursor.getStudent());
//                studentDBCursor.moveToNext();
//            }
//        }
//        finally {
//            cursor.close();
//        }
//        return studentList;
//    }
}
