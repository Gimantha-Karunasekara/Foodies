package com.example.foodapp;

public class FoodItem {
    private int id;
    private String name;
    private String desc;
    private int img;
    private float price;
    private int rest_id;
    private int featured;

    public FoodItem(int id, String name, String desc, int img ,float price, int rest_id)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.price = price;
        this.rest_id = rest_id;
    }

    public int getID(){return id;}
    public String getName(){return name;}
    public String getDesc(){return desc;}
    public int getImg(){return img;}
    public int getRest_id(){return rest_id;}
    public float getPrice(){return price;}

    public void setImg(int img){this.img = img;}
}
