package persistence;

import model.Exercise;
import model.Food;
import model.Profile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Profile prfl = new Profile("User", 0, 0, 0, 0, 0, 0, "");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyProfile() {
        try {
            Profile prfl = new Profile("User", 0, 0, 0, 0, 0, 0, "");
            JsonWriter writer = new JsonWriter("./data/testWriterNewProfile.json");
            writer.open();
            writer.write(prfl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterNewProfile.json");
            prfl = reader.read();
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
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterUserProfile() {
        try {
            Profile prfl = new Profile("Bill", 2000, 875, 175, 68, 20, 22.2,
                    "male");
            prfl.getFoodList().addFood("apple", 15);
            prfl.getFoodList().addFood("tomato", 10);
            prfl.getFoodList().addFood("cracker", 20);
            prfl.getExerciseList().addExercise("running", 73);
            prfl.getExerciseList().addExercise("pushups", 28);
            JsonWriter writer = new JsonWriter("./data/testWriterUserProfile.json");
            writer.open();
            writer.write(prfl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterUserProfile.json");
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
            fail("Exception should not have been thrown");
        }
    }
}