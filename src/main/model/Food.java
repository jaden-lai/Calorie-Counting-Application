package model;

// Represents food with a name and calories
public class Food {
    private String name;                    // Food name
    private double calories;                // Calories given/added

    /*
     * REQUIRES: food name has a non-zero length
     * EFFECTS: constructs food with given name and calories gained
     */
    public Food(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getFoodName() {
        return name;
    }

    public double getFoodCalories() {
        return calories;
    }
}
