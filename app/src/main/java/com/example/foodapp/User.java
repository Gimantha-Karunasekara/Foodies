/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

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

    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getAddress(){return address;}
    public int getPhone(){return phone;}

}