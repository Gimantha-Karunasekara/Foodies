package com.example.foodapp;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class SeedDatabse {

    public static void initAll(View view)
    {

        FoodDBModel foodAppDBModel = new FoodDBModel();
        foodAppDBModel.load(view.getContext());

        ArrayList<Restaurant> restaurants = foodAppDBModel.getAllRestaurants();

        if (restaurants.size() == 0) // only re-load items to database if not initialized already
        {
            initRestaurantData(foodAppDBModel);
            initUseres(foodAppDBModel);
            initFood(foodAppDBModel);
        }
    }

    public static void initRestaurantData(FoodDBModel foodAppDBModel){

        ArrayList<Restaurant> restaurants = new ArrayList<>(Arrays.asList(

                new Restaurant(1,"Square Burger"
                        , "Open 9AM - 10PM \n" +
                        "Address: 161/3, Havelock Road, Colombo, Western 00500 \n " +
                        "Contact : 0112343832 \n" +
                        "Delivery within 15-20 min ",R.drawable.r1_square_burger),

                new Restaurant(2,"Lounge Space","Open 10AM - 9.30PM \n" +
                        "Address: 202, Nawala Road, Colombo 004 \n"+
                        "Contact : 0112787888 \n" +
                        "Delivery within 30-40 min "
                        ,R.drawable.r2_lounge_space),

                new Restaurant(3,"Sugary Moon","Open 10AM - 10PM \n" +
                        "Address: 27, Stattion Road,Colombo 006 \n " +
                        "Contact : 0112838391 \n" +
                        "Delivery within 10-15 min "
                        ,R.drawable.r3_sugary_moon),

                new Restaurant(4,"Flavour Spark","Open 9AM - 5PM \n" +
                        "Address: 150, Havelock Road, Colombo 005 \n " +
                        "Contact : 0112393028 \n" +
                        "Delivery within 15-20 min "
                        ,R.drawable.r4_flavour_spark),

                new Restaurant(5,"Dokorean","Open 9AM - 8PM \n" +
                        "Address: 347, De Mel Mawatha, Colombo 003 \n " +
                        "Contact : 01128291782 \n" +
                        "Delivery within 15-30 min "
                        ,R.drawable.r5_hang_gook_gwan),

                new Restaurant(6,"Yum Vibe","Open 9.30AM - 9PM \n" +
                        "Address: 174 A3, Dehiwala- Mount Lavinia, Dehiwala, Western 10350 \n " +
                        "Contact : 01122901892 \n" +
                        "Delivery within 30-40 min "
                        ,R.drawable.r6_yum_vibe),

                new Restaurant(7,"BOA Pizza","Open 9AM - 10PM \n" +
                        "Address: 159, Havelock Road, Colombo, Western 00500 \n " +
                        "Contact : 011299203829 \n" +
                        "Delivery within 15-20 min "
                        ,R.drawable.r7_boa_pizza),

                new Restaurant(8,"Daily Bread","Open 10AM - 9PM \n" +
                        "Address: 265, Havelock Road, Colombo 06 \n " +
                        "Contact : 0112238392 \n" +
                        "Delivery within 20-30 min "
                        ,R.drawable.r8_daily_bread),

                new Restaurant(9,"Juice Land","Open 9AM - 5PM \n" +
                        "Address: 28/7B, Borella Road, Colombo 08 \n" +
                        "Contact : 0112292938 \n" +
                        "Delivery within 10-15 min "
                        ,R.drawable.r9_juice_land),

                new Restaurant(10,"Dessert Haven","Open 9AM - 8PM \n" +
                        "Address: 10A, Red Avenue, Colombo 07 \n " +
                        "Contact : 0112229382 \n" +
                        "Delivery within 15-20 min "
                        ,R.drawable.r10_dessert_haven)
        ));

        for(Restaurant restaurant : restaurants){
            foodAppDBModel.addRestaurant(restaurant);
        }
    }

    public static void initUseres(FoodDBModel foodAppDBModel)
    {
        try {

            User user1 = new User("Gimantha", "gimantha@gmail.com", "gimantha123",
                    "No50, subarathi road, kuliyapitiya", 0771231231);
            User user2 = new User("Pamo", "pamo@gmail.com","pamo321","No.25/1, Jayasinghe road, Colombo 00600", 0752341232 );
            foodAppDBModel.addUser(user1);
            foodAppDBModel.addUser(user2);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void initFood(FoodDBModel foodAppDBModel)
    {
        // food item id will not make any affect
        ArrayList<FoodItem> foodItems = new ArrayList<>(Arrays.asList(
                new FoodItem(1,"Chicken Burger", "These flavorful ground chicken" +
                        " burgers are a delicious alternative to beef and will keep you grilling" +
                        " from spring to fall. Top with spicy cheese or BBQ sauce",R.drawable.res1_chicken_burger, 700.00f,1),
                new FoodItem(2, "Hamburger", "Consisting of fillings a patty of " +
                        "ground meat, typically beef placed inside a sliced bun. " +
                        "Served with cheese, lettuce, tomato, onion, pickles, bacon, or chilis. " +
                        "condiments such as ketchup, mustard, mayonnaise, relish, or a special sauce , " +
                        "often a variation of Thousand Island dressing and are " +
                        "frequently placed on sesame seed buns.", R.drawable.res1_beef_burger, 750.00f, 1),
                new FoodItem(3, "French Fries", "French Fries with Ketchup – " +
                        "the best crispy fries with a twist of chilli flakes and secret sauce ",R.drawable.res1_french_fries, 320.00f, 1),
                new FoodItem(4, "Cheese Burger", "A quarter pounder" +
                        " chicken thighs in a sesame crusted brioche bun with cheddar cheese, \n" +
                        "fresh tomatoes, onions and crispy iceberg lettuce topped with sauce", R.drawable.res1_cheese_burger, 650.00f,1),
                new FoodItem(5, "Egg Burger", "The egg burger is a simple twist on the classic " +
                        "beef burger, substituting the beef patty for an egg. Like any burger, dress it" +
                        " up or down with your own personal " +
                        "combination of toppings and condiments.", R.drawable.res1_egg_burger, 550.50f,1),
                new FoodItem(6, "Fried Chicken", "Consisting of chicken pieces that have been " +
                        "coated with seasoned flour, deep fried. The breading adds a crisp coating " +
                        "or crust to the exterior of the chicken while retaining juices in the meat. " +
                        "Not one but two pieces of crispy fried chicken breast on a bed of" +
                        " lettuce and onions crowned with mayo or cheese\n",R.drawable.res1_fried_chicken, 600.00f,1),

                new FoodItem(1,"Fried Rice", "dish of cooked rice that has been stir-fried " +
                        "in a frying pan and mixed with other ingredients such as" +
                        " eggs, vegetables, seafood, or meat",R.drawable.res2_fried_rice, 950.00f, 2),
                new FoodItem(2,"Seafood BBQ", "Incorporates flavors such as citrus, ginger, " +
                        "and chilis into BBQ .",R.drawable.res2_seafood_bbq, 1500.00f, 2),
                new FoodItem(3,"Chicken BBQ", "Chicken wings marinated in bbq sauce and baked in oven ",R.drawable.res2_chicken_bbq, 900.00f, 2),
                new FoodItem(4,"Seafood Pasta", "A mix of shrimp, clams, mussels and scallops, all " +
                        "tossed together with spaghetti in a homemade tomato sauce. An easy yet elegant meal" +
                        " that's perfect for entertaining!",R.drawable.res2_seafood_pasta, 850.00f, 2),
                new FoodItem(5,"Vegetable Salad", " healthy and delicious summer salad made with " +
                        "fresh raw veggies, avocado, nuts, seeds, herbs and feta in a light " +
                        "vinaigrette dressing",R.drawable.res2_vegetable_salad, 350.00f, 2),

                new FoodItem(1,"Chocolate Cake", "With a super moist crumb and fudgy, yet light" +
                        " texture and top with chocolate buttercream and chocolate " +
                        "chips for 3x the chocolate flavor. ",R.drawable.res3_chocolate_cake, 350.00f, 3),
                new FoodItem(2,"Doughnut", "Stuffed with creamy chocolate and " +
                        "a even chocolate coating with grated chocolate topping \n" +
                        "Soft and scrumptious donut dipped in tempting dark chocolate ",R.drawable.res3_doughnut, 300.00f, 3),
                new FoodItem(3,"Banana Pie", "Classic ice cream dessert with ice cream, " +
                        "fresh banana, pineapple, strawberries, nuts and \n" +
                        "topped with chocolate syrup ",R.drawable.res3_banana_split, 500.00f, 3),
                new FoodItem(4,"Lava Cake", "A rich chocolate cake with a slightly crunchy " +
                        "crust and a warm liquid chocolate center that \n" +
                        "flows out ",R.drawable.res3_lava_cake, 400.00f, 3),
                new FoodItem(5,"Lemon Cake", "Lemon sponge cake with lemon sugar drizzle icing  ",R.drawable.res3_lemon_cake, 350.00f, 3),

                new FoodItem(1,"Dim Sum", "Traditional Chinese meal made up of" +
                        " small plates of dumplings and other snack dishes ",R.drawable.res4_dim_sum, 700.00f, 4),
                new FoodItem(2,"Shawarma", "chicken, lettuce, tomato slices, " +
                        "onion , yogurt sauce and warmed flatbreads ",R.drawable.res4_shawarma, 500.00f, 4),
                new FoodItem(3,"Pad Thai", "A classic thai dish of stir " +
                        "fried rice noodles with eggs, vegetables and tofu in a tamarind sauce \n" +
                        "served with succulent prawns and topped with peanuts ",R.drawable.res4_pad_thai, 800.00f, 4),
                new FoodItem(4,"Sushi", "A staple rice dish of japenese cuisine," +
                        " consisting of cooked rice flavoured with vinegar and \n" +
                        "variety of vegetable egg , or raw seafood granishes and serve cold\n",R.drawable.res4_sushi, 500.00f, 4),
                new FoodItem(5,"Tom Yum", "Hot and sour thai " +
                        "soup cooked with shrimp, The soup is also made with fresh ingredients such as lemongrass," +
                        " kaffir lime leaves, galangal, lime juice, fish sauce, and crushed red chili peppers.",R.drawable.res4_tom_yum, 650.00f, 4),

                new FoodItem(1,"Kimchi", "Traditional Korean dish of salted and fermented vegetables with seasonings. The flavor will also vary depending" +
                        " on the vegetables you choose ",R.drawable.res5_kimchi, 500.00f, 5),
                new FoodItem(2,"Ramen Noodles", "Wheat noodles served in broth with common flavors such as soy sauce, miso and topping \n" +
                        "including sliced pork , scallions  ",R.drawable.res5_ramen_noodles, 400.00f, 5),
                new FoodItem(3,"Risotto", "Italian rice dish cooked with broth until it reaches a creamy consistency with meat and \n" +
                        "vegetables ",R.drawable.res5_risotto, 440.00f, 5),
                new FoodItem(4,"Frutti Di Mare", "Italian pasta dish made with spaghetti, arrabiata sauce and filled with variety of seafood \n" +
                        "(mussels, clams, shrimp, scallops etc.)",R.drawable.res5_frutti_di_mare, 520.00f, 5),
                new FoodItem(5,"Tteok Bokki", " Famous Korean Street Food mixed with chilli paste! Chewy rice cakes " +
                        "made with boiled eggs and scallions ",R.drawable.res5_tteok_bokki, 600.00f, 5),

                new FoodItem(1,"Roasted Chicken ", "Coated in a homemade spice rub, then" +
                        " roasted to crispy perfection ",R.drawable.res6_roasted_chicken_wings, 550.00f, 6),
                new FoodItem(2,"Chicken Meatballs", "Baked until golden brown and flavored with garlic, herbs and spices. ",R.drawable.res6_chicken_meatballs, 450.00f, 6),
                new FoodItem(3,"Penne Arrabiata", "An option of spaghetti or penne pasta " +
                        "mixed generously with our famous arrabiata sauce,basil leaves.cheese and tossed with olive oil ",R.drawable.res6_penne_arrabiata, 400.00f, 6),
                new FoodItem(4,"Spaghetti", "Flame grilled chicken meatballs in spicy tomato herb sauce",R.drawable.res6_spaghetti, 500.00f, 6),
                new FoodItem(5,"Taco", "A traditional Mexican food consisting of a small " +
                        "hand-sized corn- or wheat-based tortilla topped with a filling ",R.drawable.res6_taco, 490.00f, 6),

                new FoodItem(1,"Pepperoni Pizza", "Spicy salami made from cured pork and" +
                        " beef seasoned with chili pepper ",R.drawable.res7_peparoni_pizza, 700.00f, 7),
                new FoodItem(2,"Cheese Pizza", "A soft crust, tasty tomato sauce, and loads " +
                        "of cheese, all baked to perfection. ",R.drawable.res7_cheese_pizza, 650.00f, 7),
                new FoodItem(3,"Tomato Pie Pizza", "A cold sicilian pizza, with no cheese " +
                        "(except a sprinkle of grated locatelli). It has a thick, chewy, utterly delicious crust and a thick layer of sweet, tangy sauce. ",R.drawable.res7_tomato_pie, 650.00f, 7),
                new FoodItem(4,"Green Pizza", "A delightfully light thin crust pizza, expertly hand- stretched and oven-baked to golden \n" +
                        "perfection! tomatoes, onions, black olives and bell papers with a double layer of \n" +
                        "mozzarella cheese ",R.drawable.res7_green_pizza, 500.00f, 7),
                new FoodItem(5,"Apizza", " a pizza with a thin, black, crispy, and charred" +
                        " crust that might appear to be burnt, but instead has a deliciously chewy texture and flavor." +
                        " usual toppings are sparse, including grated cheese and tomatoes or anchovies  ",R.drawable.res7_apizza, 900.00f, 7),
                new FoodItem(6,"Mushroom Pizza", "This pizza is a true mushroom lover's dream," +
                        " featuring four different types of mushrooms, two different cheeses, no-cook marinara" +
                        " sauce, and fresh chives",R.drawable.res7_mushroom_pizza, 650.00f, 7),

                new FoodItem(1,"Chicken Puff Pastry", "The best Chicken Puff Pastry! Easy puff" +
                        " pastry appetizers filled with a homemade creamy chicken filling. The perfect finger food!" +
                        " So easy to prepare and you can totally prep and freeze these for later! ",R.drawable.res8_chicken_puff_pastry, 250.00f, 8),
                new FoodItem(2,"Bakvala", "Baklava is a layered pastry dessert made of filo pastry," +
                        " filled with chopped nuts, and sweetened with syrup or honey ",R.drawable.res8_bakvala, 350.00f, 8),
                new FoodItem(3,"Crissont", "A croissant is a buttery, flaky, French viennoiserie pastry" +
                        " inspired by the shape of the Austrian kipferl but using the French yeast-leavened laminated dough ",R.drawable.res8_croissant, 300.00f, 8),
                new FoodItem(4,"Fish Roll", "Delicious deep fried thin crepes stuffed with a " +
                        "cooked filling fish ",R.drawable.res8_fish_roll, 200.00f, 8),
                new FoodItem(5,"Submarine", "contains grilled marinated chicken, sauteed capsicums, " +
                        "onions, cheese, mayo in a sesame bun  ",R.drawable.res8_submarine, 400.00f, 8),

                new FoodItem(1,"Chocolate Milkshake", "cold, sweetened milk drink.. A mixture of ice cream," +
                        " cold milk, and chocolate syrup  ",R.drawable.res9_chocolate_milkshake, 300.00f, 9),
                new FoodItem(2,"Passion Fruit", " Pleasantly tart and super refreshing. Similar to lemonade, " +
                        "this drink is made by combining fruit juice with water and sweetener.",R.drawable.res9_passion_fruit, 250.00f, 9),
                new FoodItem(3,"Mango Smoothie", " Sweet, refreshing and has a full-on mango flavor. " +
                        "The perfect way to beat the heat and quench your thirst is with this delectable fresh, homemade juice",R.drawable.res9_mango_smoothie, 250.00f, 9),
                new FoodItem(4,"Vegan Smoothie", " A deliciously thick and creamy banana smoothie that " +
                        "is also bursting with mango flavour",R.drawable.res9_vegan_smoothie, 400.00f, 9),
                new FoodItem(5,"Strawberry Milkshake", "Creamy, light and refreshing, delicious and looks adorably with its cloud of pink fluff. served over cold or warm milk",R.drawable.res9_strawberry_milkshake, 320.00f, 9),

                new FoodItem(1,"Chocolate Brownies", " The Best, Fudgy ONE BOWL Cocoa Brownies! " +
                        "A special addition gives these brownies a super fudgy centre without losing that crispy, crackly top",R.drawable.res10_chocolate_brownies, 200.00f, 10),
                new FoodItem(2,"Chocolate Mousse", "Deliciously fluffy chocolate mousse blended in " +
                        "fresh cream and topped with a silky \n" +
                        "chocolate layer ",R.drawable.res10_chocolate_mousse, 350.00f, 10),
                new FoodItem(3,"Fried Ice-cream", "Dessert made of a scoop of ice cream that is frozen hard," +
                        " breaded or coated in a batter, and quickly deep-fried, creating a warm, crispy shell" +
                        " around the still-cold ice cream ",R.drawable.res10_fried_icecream, 550.00f, 10),
                new FoodItem(4,"Tiramisu", "Coffee-flavored Italian dessert. It is made of ladyfingers " +
                        "dipped in coffee, layered with a whipped mixture of eggs, sugar, and mascarpone cheese, flavored with cocoa ",R.drawable.res10_tiramisu, 450.00f, 10),
                new FoodItem(5,"Chocolate Muffin", "Tasty chocolate muffins are scrumptious! " +
                        "Yogurt in the batter keeps them super moist while cocoa powder and chocolate chips add a huge dose of chocolaty goodness ",R.drawable.res10_chocolate_muffins, 300.00f, 10),
                new FoodItem(6,"Waffle", "Crispy waffle with strawberries and whipped cream or " +
                        "ice cream with strawberry topping or \n" +
                        "chocolate topping up to your choice",R.drawable.res10_waffle, 350.00f, 10),
                new FoodItem(7,"Creme Caramel", "Custard dessert with a layer of clear caramel sauce," +
                        "Smooth and creamy tastes like creamy vanilla custard,topped with a sweet and nutty caramel sauce",R.drawable.res10_creme_caramel, 390.00f, 10)
        ));

        for (FoodItem foodItem : foodItems){
            foodAppDBModel.addFoodItem(foodItem);
        }

    }
}
