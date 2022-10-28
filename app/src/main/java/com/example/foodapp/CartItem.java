/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;

import java.io.Serializable;

public class CartItem implements Serializable {
    private int item_id;
    private int count;
    private String user_email = "";
    private String date_time = "";

    public CartItem(int item_id, int count, String user_email, String date_time)
    {
        this.item_id = item_id;
        this.count = count;
        this.user_email = user_email;
        this.date_time = date_time;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getCount() {
        return count;
    }

    public String getDate_time() {
        return date_time;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

