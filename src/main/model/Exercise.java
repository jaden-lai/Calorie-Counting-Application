package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an exercise with name and calories
public class Exercise implements Writable {
    private String name;                    // Exercise name
    private double calories;                // Calories burned/removed

    /*
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("calories", calories);
        return json;
    }
}
