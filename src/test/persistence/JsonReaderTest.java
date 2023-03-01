package persistence;

import model.Exercise;
import model.Food;
import model.Profile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Profile prfl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderNewProfile() {
        JsonReader reader = new JsonReader("./data/testWriterNewProfile.json");
        try {
            Profile prfl = reader.read();
            assertEquals("User", prfl.getUsername());
            assertEquals(0, prfl.getTargetCalories());
            assertEquals(0, prfl.getCalorieCount());
            assertEquals(0, prfl.getHeight());
            assertEquals(0, prfl.getWeight());
            assertEquals(0, prfl.getAge());
            assertEquals(0, prfl.getBMI());
            assertEquals("", prfl.getSex());
            assertEquals(0, prfl.getFoodList().getFoodList().size());
            assertEquals(0, prfl.getExerciseList().getExerciseList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderUserProfile() {
        JsonReader reader = new JsonReader("./data/testWriterUserProfile.json");
        try {
            Profile testProfile = reader.read();
            assertEquals("Bill", testProfile.getUsername());
            assertEquals(2000, testProfile.getTargetCalories());
            assertEquals(875, testProfile.getCalorieCount());
            assertEquals(175, testProfile.getHeight());
            assertEquals(68, testProfile.getWeight());
            assertEquals(20, testProfile.getAge());
            assertEquals(22.2, testProfile.getBMI());
            assertEquals("male", testProfile.getSex());
            List<Food> foods = testProfile.getFoodList().getFoodList();
            assertEquals(3, foods.size());
            checkFood("apple", 15, foods.get(0));
            checkFood("tomato", 10, foods.get(1));
            checkFood("cracker", 20, foods.get(2));
            List<Exercise> exercises = testProfile.getExerciseList().getExerciseList();
            assertEquals(2, exercises.size());
            checkExercise("running", 73, exercises.get(0));
            checkExercise("pushups", 28, exercises.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}