package com.example.foodapp;

public class FoodItem {
    private int id;
    private String name;
    private String desc;
    private int img;
    private int rest_id;

    public FoodItem(int id, String name, String desc, int rest_id)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.rest_id = rest_id;
    }

    public int getID(){return id;}
    public String getName(){return name;}
    public String getDesc(){return desc;}
    public int getImg(){return img;}
    public int getRest_id(){return rest_id;}

    public void setImg(int img){this.img = img;}
}
