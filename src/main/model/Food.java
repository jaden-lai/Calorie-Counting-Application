package model;

// Represents food with a name and calories
public class Food {
    private String name;                    // Food name
    private double calories;                // Calories given/added

    /*
     * REQUIRES: username has a non-zero length
     * EFFECTS: name on account is set to accountName;
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
