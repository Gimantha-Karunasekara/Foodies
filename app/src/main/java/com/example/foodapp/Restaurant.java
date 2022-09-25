package com.example.foodapp;

public class Restaurant {
    private int rest_Id;
    private int img_drawableId;
    private String name;
    private String desc;

    public Restaurant(int rest_Id, String name, String desc, int img)
    {
        this.rest_Id = rest_Id;
        this.name = name;
        this.desc = desc;
        this.img_drawableId = img;
    }

    public int getRest_Id()
    {
        return rest_Id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDesc()
    {
        return desc;
    }

    public int getImg_drawableId()
    {
        return img_drawableId;
    }

}
