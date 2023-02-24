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
    }

    @Test
    void testProfileConstructor() {
        assertEquals("Bill", testProfile.getUsername());
        assertEquals(2000, testProfile.getCalories());
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
        assertEquals(2200, testProfile.getCalories());
    }

    @Test
    void testAddCaloriesNegative() {
        testProfile.addCalories(-200);
        assertEquals(2000, testProfile.getCalories());
    }

    @Test
    void testRemoveCalories() {
        testProfile.removeCalories(200);
        assertEquals(1800, testProfile.getCalories());
    }

    @Test
    void testRemoveCaloriesNegative() {
        testProfile.removeCalories(-200);
        assertEquals(2000, testProfile.getCalories());
    }

    @Test
    void testNewName() {
        testProfile.newName("Jill");
        assertEquals("Jill", testProfile.getUsername());
    }

    @Test
    void testNewCalories() {
        testProfile.newCalories(200);
        assertEquals(200, testProfile.getCalories());
    }

    @Test
    void testNewCalorieCount() {
        testProfile.newCalorieCount(200);
        assertEquals(200, testProfile.getCalorieCount());
    }

    @Test
    void testNewHeight() {
        testProfile.newHeight(180);
        assertEquals(180, testProfile.getHeight());
    }

    @Test
    void testNewHeightInvalid() {
        testProfile.newHeight(0);
        assertEquals(175, testProfile.getHeight());
    }

    @Test
    void testNewWeight() {
        testProfile.newWeight(120);
        assertEquals(120, testProfile.getWeight());
    }

    @Test
    void testNewWeightInvalid() {
        testProfile.newWeight(0);
        assertEquals(68, testProfile.getWeight());
    }

    @Test
    void testNewAge() {
        testProfile.newAge(43);
        assertEquals(43, testProfile.getAge());
    }

    @Test
    void testNewAgeInvalid() {
        testProfile.newAge(0);
        assertEquals(20, testProfile.getAge());
    }

    @Test
    void testNewBMI() {
        testProfile.newBMI(11);
        assertEquals(11, testProfile.getBMI());
    }

    @Test
    void testNewSex() {
        testProfile.newSex("female");
        assertEquals("female", testProfile.getSex());
    }

    @Test
    void testNewSexSame() {
        testProfile.newSex("male");
        assertEquals("male", testProfile.getSex());
    }

    @Test
    void testNewSexInvalid() {
        testProfile.newSex("fill");
        assertEquals("male", testProfile.getSex());
    }




}
