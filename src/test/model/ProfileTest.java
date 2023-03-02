package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProfileTest {
    private Profile testProfile;

    @BeforeEach
    void runBefore() {
        testProfile = new Profile("Bill", 2000, 875, 175, 68, 20, 22.2,
                "male");
        testProfile.getFoodList().addFood("apple", 20);
        testProfile.getExerciseList().addExercise("running", 17);
    }

    @Test
    void testProfileConstructor() {
        assertEquals("Bill", testProfile.getUsername());
        assertEquals(2000, testProfile.getTargetCalories());
        assertEquals(875, testProfile.getCalorieCount());
        assertEquals(175, testProfile.getHeight());
        assertEquals(68, testProfile.getWeight());
        assertEquals(20, testProfile.getAge());
        assertEquals(22.2, testProfile.getBMI());
        assertEquals("male", testProfile.getSex());
    }

    @Test
    void testAddCalories() {
        testProfile.addCalories(200);
        assertEquals(2200, testProfile.getTargetCalories());
    }

    @Test
    void testAddCaloriesNegative() {
        testProfile.addCalories(-200);
        assertEquals(2000, testProfile.getTargetCalories());
    }

    @Test
    void testRemoveCalories() {
        testProfile.removeCalories(200);
        assertEquals(1800, testProfile.getTargetCalories());
    }

    @Test
    void testRemoveCaloriesNegative() {
        testProfile.removeCalories(-200);
        assertEquals(2000, testProfile.getTargetCalories());
    }

    @Test
    void testSetName() {
        testProfile.setName("Jill");
        assertEquals("Jill", testProfile.getUsername());
    }

    @Test
    void testSetCalories() {
        testProfile.setCalories(200);
        assertEquals(200, testProfile.getTargetCalories());
    }

    @Test
    void testSetCalorieCount() {
        testProfile.setCalorieCount(200);
        assertEquals(200, testProfile.getCalorieCount());
    }

    @Test
    void testSetHeight() {
        testProfile.setHeight(180);
        assertEquals(180, testProfile.getHeight());
    }

    @Test
    void testSetWeight() {
        testProfile.setWeight(120);
        assertEquals(120, testProfile.getWeight());
    }

    @Test
    void testSetAge() {
        testProfile.setAge(43);
        assertEquals(43, testProfile.getAge());
    }

    @Test
    void testSetBMI() {
        testProfile.setBMI(11);
        assertEquals(11, testProfile.getBMI());
    }

    @Test
    void testSetSex() {
        testProfile.setSex("female");
        assertEquals("female", testProfile.getSex());
    }

    @Test
    void testSetSexSame() {
        testProfile.setSex("male");
        assertEquals("male", testProfile.getSex());
    }

    @Test
    void testSetSexInvalid() {
        testProfile.setSex("test");
        assertEquals("male", testProfile.getSex());
    }

    @Test
    void testCalculateCalorieCount() {
        testProfile.calculateCalorieCount();
        assertEquals(3, testProfile.getCalorieCount());
    }


}
