package com.example.foodapp;

public class User {
    private String username;
    private String email;
    private String password;
    private String address;
    private int phone;

    public User(String username, String email, String password, String address, int phone)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getAddress(){return address;}
    public int getPhone(){return phone;}

}