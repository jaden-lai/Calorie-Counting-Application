package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseListTest {
    private ExerciseList testExerciseList;

    @BeforeEach
    void runBefore() {
        testExerciseList = new ExerciseList();
    }

    @Test
    void testAddExercise() {
        testExerciseList.addExercise("running", 20);
        assertEquals(1, testExerciseList.getExerciseList().size());
        assertEquals("running", testExerciseList.getExerciseList().get(0).getExerciseName());
        assertEquals(-20, testExerciseList.getExerciseCalories());
    }

    @Test
    void testRemoveExerciseTrue() {
        testExerciseList.addExercise("running", 20);
        assertEquals(1, testExerciseList.getExerciseList().size());
        assertEquals("running", testExerciseList.getExerciseList().get(0).getExerciseName());
        assertEquals(-20, testExerciseList.getExerciseCalories());
        testExerciseList.removeExercise("running");
        assertEquals(0, testExerciseList.getExerciseList().size());
        assertEquals(0, testExerciseList.getExerciseCalories());
    }

    @Test
    void testRemoveExerciseFalse() {
        testExerciseList.addExercise("running", 20);
        assertEquals(1, testExerciseList.getExerciseList().size());
        assertEquals("running", testExerciseList.getExerciseList().get(0).getExerciseName());
        assertEquals(-20, testExerciseList.getExerciseCalories());
        testExerciseList.removeExercise("test");
        assertEquals(1, testExerciseList.getExerciseList().size());
        assertEquals(-20, testExerciseList.getExerciseCalories());
    }

    @Test
    void testIsEmpty() {
        assertTrue(testExerciseList.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        testExerciseList.addExercise("pushup", 10);
        assertFalse(testExerciseList.isEmpty());
    }

    @Test
    void testReset() {
        testExerciseList.addExercise("situp", 30);
        testExerciseList.addExercise("boxing", 90);
        assertEquals(2, testExerciseList.getExerciseList().size());
        assertEquals("situp", testExerciseList.getExerciseList().get(0).getExerciseName());
        assertEquals("boxing", testExerciseList.getExerciseList().get(1).getExerciseName());
        assertEquals(-120, testExerciseList.getExerciseCalories());
        testExerciseList.reset();
        assertEquals(0, testExerciseList.getExerciseList().size());
        assertEquals(0, testExerciseList.getExerciseCalories());
    }

}
