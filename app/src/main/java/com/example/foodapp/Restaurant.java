package com.example.foodapp;

public class Restaurant {
    private int rest_Id;
    private int img_drawableId;
    private String name;
    private String desc;

    public Restaurant(int rest_Id, String name, String desc)
    {
        this.rest_Id = rest_Id;
        this.name = name;
        this.desc = desc;
    }

    public int getRest_Id()
    {
        return rest_Id;
    }

    public void setRest_Id(int rest_Id)
    {
        this.rest_Id = rest_Id;
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

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public int getImg_drawableId()
    {
        return img_drawableId;
    }

    public void setImg_drawableId(int img_drawableId)
    {
        this.img_drawableId = img_drawableId;
    }


}
