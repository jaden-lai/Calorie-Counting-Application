package model;

import java.util.ArrayList;

// Represents a list of foods
public class FoodList {
    private ArrayList<Food> foodList;
    private double foodCalories;

    /*
     * EFFECTS: initializes newly created FoodList as an empty list
     */
    public FoodList() {
        foodList = new ArrayList<>();
    }

    public double getFoodCalories() {
        return foodCalories;
    }

    // MODIFIES: this
    // EFFECTS: Adds Food to the end of the list
    public void addFood(String name, double calories) {
        Food food1 = new Food(name, calories);
        foodList.add(food1);
        foodCalories += calories;
    }

    // MODIFIES: this
    // EFFECTS: Remove Food and removes calories from calorie count
    public void removeFood(String food) {
        for (int i = 0; i < foodList.size(); i++) {
            Food f = foodList.get(i);
            if (food.equals(f.getFoodName())) {
                foodCalories -= f.getFoodCalories();
                foodList.remove(f);
                i--;
            }
        }
    }

    public boolean isEmpty() {
        return foodList.size() == 0;
    }

    public int getSize() {
        return foodList.size();
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void reset() {
        foodList.clear();
        foodCalories = 0;
    }

}