package model;

// Represents an exercise with name and calories
public class Exercise {
    private String name;                    // Exercise name
    private double calories;                // Calories burned/removed

    /*
     * REQUIRES: exercise name has a non-zero length
     * EFFECTS: constructs exercise with given name and calories burned
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
