package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodListTest {
    private FoodList testFoodList;

    @BeforeEach
    void runBefore() {
        testFoodList = new FoodList();
    }

    @Test
    void testAddExercise() {
        testFoodList.addFood("apple", 10);
        assertEquals(1, testFoodList.getFoodList().size());
        assertEquals("apple", testFoodList.getFoodList().get(0).getFoodName());
        assertEquals(10, testFoodList.getFoodCalories());
    }

    @Test
    void testRemoveExercise() {
        testFoodList.addFood("apple", 10);
        assertEquals(1, testFoodList.getFoodList().size());
        assertEquals("apple", testFoodList.getFoodList().get(0).getFoodName());
        assertEquals(10, testFoodList.getFoodCalories());
        testFoodList.removeFood("apple");
        assertEquals(0, testFoodList.getFoodList().size());
        assertEquals(0, testFoodList.getFoodCalories());
    }

    @Test
    void testIsEmpty() {
        assertTrue(testFoodList.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        testFoodList.addFood("banana", 5);
        assertFalse(testFoodList.isEmpty());
    }

    @Test
    void testReset() {
        testFoodList.addFood("watermelon", 20);
        testFoodList.addFood("chicken", 120);
        assertEquals(2, testFoodList.getFoodList().size());
        assertEquals("watermelon", testFoodList.getFoodList().get(0).getFoodName());
        assertEquals("chicken", testFoodList.getFoodList().get(1).getFoodName());
        assertEquals(140, testFoodList.getFoodCalories());
        testFoodList.reset();
        assertEquals(0, testFoodList.getFoodList().size());
        assertEquals(0, testFoodList.getFoodCalories());
    }


}
