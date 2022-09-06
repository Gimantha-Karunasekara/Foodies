package com.example.foodapp;

public class FoodDBSchema {
    public static class restaurantTable{
        public static final String NAME = "restaurants";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String DESC = "desc";
            public static final String IMG = "img_res";
        }
    }
    public static class itemsTable{
        public static final String NAME = "items";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String DESC = "desc";
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
}
