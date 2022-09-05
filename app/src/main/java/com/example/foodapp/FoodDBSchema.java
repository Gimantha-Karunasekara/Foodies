package com.example.foodapp;

public class FoodDBSchema {
    public static class restaurantTable{
        public static final String NAME = "restaurants";
        public static class Cols{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String DESC = "desc";
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
}
