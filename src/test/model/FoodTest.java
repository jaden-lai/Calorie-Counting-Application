package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FoodTest {
    private Food testFood;

    @BeforeEach
    void runBefore() {
        testFood = new Food("apple", 52);
    }

    @Test
    void testFoodConstructor() {
        assertEquals("apple", testFood.getFoodName());
        assertEquals(52, testFood.getFoodCalories());
    }
}
