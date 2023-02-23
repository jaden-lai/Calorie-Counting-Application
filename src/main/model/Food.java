package model;

// Represents a food with a name and calories
public class Food {
    private String name;                    // Food name
    private double calories;

    /*
     * REQUIRES: username has a non-zero length
     * EFFECTS: name on account is set to accountName;
     */
    public Food(String name, double calories) {
    }

    public String getFoodName() {
        return name;
    }
}
