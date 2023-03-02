package model;

import org.json.JSONObject;
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

    @Test
    void testJSONObject() {
        testFood.toJson();
        assertEquals("apple", testFood.toJson().getString("name"));
    }
}
