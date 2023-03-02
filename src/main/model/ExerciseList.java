package model;

import java.util.ArrayList;

// Represents a list of exercises
public class ExerciseList {
    private ArrayList<Exercise> exerciseList;
    private double exerciseCalories;

    /*
     * EFFECTS: initializes newly created ExerciseList as an empty list
     */
    public ExerciseList() {
        exerciseList = new ArrayList<>();
    }

    public ArrayList<Exercise> getExerciseList() {
        return exerciseList;
    }

    public double getExerciseCalories() {
        return exerciseCalories;
    }

    // MODIFIES: this
    // EFFECTS: Adds Exercise to the end of the list and removes calories from exerciseCalories
    public void addExercise(String name, double calories) {
        Exercise exercise1 = new Exercise(name, calories);
        exerciseList.add(exercise1);
        exerciseCalories -= calories;
    }

    // MODIFIES: this
    // EFFECTS: Remove Exercise and adds calories previously removed calories back to calorie count
    public void removeExercise(String exercise) {
        for (int i = 0; i < exerciseList.size(); i++) {
            Exercise e = exerciseList.get(i);
            if (exercise.equals(e.getExerciseName())) {
                exerciseCalories += e.getCaloriesBurned();
                exerciseList.remove(e);
                i--;
            }
        }
    }

    // EFFECTS: True if exerciseList is empty
    public boolean isEmpty() {
        return exerciseList.size() == 0;
    }

    // MODIFIES: this
    // EFFECTS: Empties exerciseList and sets exercise calorie counter to 0
    public void reset() {
        exerciseList.clear();
        exerciseCalories = 0;
    }


}
