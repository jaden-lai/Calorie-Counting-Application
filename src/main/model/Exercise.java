package model;

// Represents an exercise with a name and calories
public class Exercise {
    private String name;                    // Exercise name
    private double calories;                // Calories burned/removed

    /*
     * REQUIRES: username has a non-zero length
     * EFFECTS: name on account is set to accountName;
     */
    public Exercise(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getExerciseName() {
        return name;
    }

    public double getCaloriesBurned() {
        return calories;
    }
}
