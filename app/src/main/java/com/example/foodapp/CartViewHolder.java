/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartViewHolder extends RecyclerView.ViewHolder {

    private int cart_count;

    TextView cart_itemTitle;
    TextView cart_itemPrice;
    TextView cart_itemCount;
    TextView cart_itemDateTime;
    Button cart_itemAdd;
    Button cart_itemRemove;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);


        cart_count =0;
        cart_itemTitle = itemView.findViewById(R.id.txt_cart_title);
        cart_itemPrice = itemView.findViewById(R.id.txt_cart_price);
        cart_itemCount = itemView.findViewById(R.id.txt_cart_count);
        cart_itemAdd = itemView.findViewById(R.id.btn_cart_add);
        cart_itemRemove = itemView.findViewById(R.id.btn_cart_removeItem);
        cart_itemDateTime = itemView.findViewById(R.id.txt_cart_dateTime);

    }
}
