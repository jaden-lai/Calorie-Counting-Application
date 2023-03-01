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

    public double getExerciseCalories() {
        return exerciseCalories;
    }

    // REQUIRES: Exercise
    // MODIFIES: this
    // EFFECTS: Adds Exercise to the end of the list
    public void addExercise(String name, double calories) {
        Exercise exercise1 = new Exercise(name, calories);
        exerciseList.add(exercise1);
        exerciseCalories -= calories;
    }

    // MODIFIES: this
    // EFFECTS: Remove Exercise and adds calories burned back to calorie count
    public void removeExcercise(String exercise) {
        for (int i = 0; i < exerciseList.size(); i++) {
            Exercise e = exerciseList.get(i);
            if (exercise.equals(e.getExerciseName())) {
                exerciseCalories += e.getCaloriesBurned();
                exerciseList.remove(e);
                i--;
            }
        }
    }

    public boolean isEmpty() {
        return exerciseList.size() == 0;
    }

    public int getSize() {
        return exerciseList.size();
    }

    public ArrayList<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void reset() {
        exerciseList.clear();
        exerciseCalories = 0;
    }



}
