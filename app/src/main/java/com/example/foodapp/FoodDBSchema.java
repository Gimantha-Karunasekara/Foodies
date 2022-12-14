/****************************************************************
 * Authors:                                                     *
 *      Gimantha Karunasekara - Gimantha-Karunasekara @ github  *
 *      Pamodya Piyamini - pamo66 @ github                      *
 * Descirption: Java - Android Food ordering application        *
 * Date: 2022/09/22                                             *
 * Version: 1.0                                                 *
 ****************************************************************/

package com.example.foodapp;

public class FoodDBSchema {
    public static class restaurantTable{
        public static final String NAME = "restaurants";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String DESC = "descript";
            public static final String IMG = "img_res";
        }
    }
    public static class itemsTable{
        public static final String NAME = "items";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String DESC = "descript";
            public static final String IMAGE = "img_res";
            public static final String PRICE = "price";
            public static final String RESTAURANT_ID = "restaurant_id";
        }
    }
    public static class userTable{
        public static final String NAME = "users";
        public static class Cols{
            public static final String USERNAME = "username";
            public static final String EMAIL = "email";
            public static final String PASSWORD = "password";
            public static final String ADDRESS = "address";
            public static final String PHONE = "phone";

        }
    }
    public static class purchaseTable{
        public static final String NAME = "purchase_history";
        public static class Cols{
            public static final String ITEM_ID = "id";
            public static final String COUNT = "count";
            public static final String USER_EMAIL = "user";
            public static final String DATE_TIME = "dateTime";
        }
    }
}
