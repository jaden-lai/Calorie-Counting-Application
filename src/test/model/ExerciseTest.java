package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ExerciseTest {
    private Exercise testExercise;

    @BeforeEach
    void runBefore() {
        testExercise = new Exercise("50 pushups", 100);
    }

    @Test
    void testExerciseConstructor() {
        assertEquals("50 pushups", testExercise.getExerciseName());
        assertEquals(100, testExercise.getCaloriesBurned());
    }

    @Test
    void testJSONObject() {
        testExercise.toJson();
        assertEquals("50 pushups", testExercise.toJson().getString("name"));
    }
}