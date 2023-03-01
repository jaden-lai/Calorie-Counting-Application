package persistence;

import model.Exercise;
import model.Food;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkExercise(String name, double calories, Exercise exercise) {
        assertEquals(name, exercise.getExerciseName());
        assertEquals(calories, exercise.getCaloriesBurned());
    }

    protected void checkFood(String name, double calories, Food food) {
        assertEquals(name, food.getFoodName());
        assertEquals(calories, food.getFoodCalories());
    }
}
