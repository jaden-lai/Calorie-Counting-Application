package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads profile from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads profile from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Profile read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        EventLog.getInstance().logEvent(new Event("profile save file loaded from stored location"));
        return parseProfile(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses profile from JSON object and returns it
    private Profile parseProfile(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double targetCalories = jsonObject.getDouble("targetCalories");
        double calorieCount = jsonObject.getDouble("calorieCount");
        double height = jsonObject.getDouble("height");
        double weight = jsonObject.getDouble("weight");
        int age = jsonObject.getInt("age");
        double bmi = jsonObject.getDouble("bmi");
        String sex = jsonObject.getString("sex");
        Profile prfl = new Profile(name, targetCalories, calorieCount, height, weight, age, bmi, sex);
        addFoodList(prfl, jsonObject);
        addExerciseList(prfl, jsonObject);
        return prfl;
    }

    // MODIFIES: prfl
    // EFFECTS: parses foodList from JSON object and adds them to profile
    private void addFoodList(Profile prfl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("foodList");
        for (Object json : jsonArray) {
            JSONObject nextFood = (JSONObject) json;
            addFood(prfl, nextFood);
        }
    }

    // MODIFIES: prfl
    // EFFECTS: parses food from JSON object and adds it to profile
    private void addFood(Profile prfl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double calories = jsonObject.getDouble("calories");
        Food food = new Food(name, calories);
        prfl.getFoodList().addFood(food.getFoodName(), food.getFoodCalories());
    }

    // MODIFIES: prfl
    // EFFECTS: parses exerciseList from JSON object and adds them to profile
    private void addExerciseList(Profile prfl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exerciseList");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(prfl, nextExercise);
        }
    }

    // MODIFIES: prfl
    // EFFECTS: parses exercise from JSON object and adds it to profile
    private void addExercise(Profile prfl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double calories = jsonObject.getDouble("calories");
        Exercise exercise = new Exercise(name, calories);
        prfl.getExerciseList().addExercise(exercise.getExerciseName(), exercise.getCaloriesBurned());
    }
}
