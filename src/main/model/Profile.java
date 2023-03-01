package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

// Represents a profile which includes user info (name, calories, calorie count, height, weight, bmi, age, and sex)
public class Profile implements Writable {
    private String name;                    // Profile name
    private double targetCalories;          // the current target calories for a person
    private double calorieCount;            // a days calorie count
    private double height;                  // height of person
    private double weight;                  // weight of person
    private int age;                        // age of person
    private double bmi;                     // bmi of person
    private String sex;                     // sex of person
    private ExerciseList exerciseList;      // person's exercise list
    private FoodList foodList;              // person's food list

    /*
     * EFFECTS: constructs a profile with name, calories, calorie count, height, weight, age, bmi, sex, excercise list,
     *  and food list
     */
    public Profile(String name, double targetCalories, double calorieCount, double height, double weight, int age,
                   double bmi, String sex) {
        this.name = name;
        this.targetCalories = targetCalories;
        this.calorieCount = calorieCount;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.bmi = bmi;
        this.sex = sex;
        exerciseList = new ExerciseList();
        foodList = new FoodList();
    }

    public String getUsername() {
        return name;
    }

    public double getTargetCalories() {
        return targetCalories;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public double getBMI() {
        return bmi;
    }

    public double getCalorieCount() {
        return calorieCount;
    }

    public String getSex() {
        return sex;
    }

    public ExerciseList getExerciseList() {
        return exerciseList;
    }

    public FoodList getFoodList() {
        return foodList;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is added to calories
     */
    public double addCalories(double amount) {
        if (amount >= 0) {
            targetCalories = targetCalories + amount;
        }
        return targetCalories;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is removed from calories
     */
    public double removeCalories(double amount) {
        if (amount >= 0) {
            targetCalories = targetCalories - amount;
        }
        return targetCalories;
    }

    public String setName(String string) {
        name = string;
        return name;
    }


    public double setCalories(double amount) {
        targetCalories = amount;
        return targetCalories;
    }


    public double setCalorieCount(double amount) {
        calorieCount = amount;
        return calorieCount;
    }


    public double setHeight(double amount) {
        height = amount;
        return height;
    }


    public double setWeight(double amount) {
        weight = amount;
        return weight;
    }


    public double setAge(int amount) {
        age = amount;
        return age;
    }

    public double setBMI(double amount) {
        bmi = amount;
        return bmi;
    }

    /*
     * REQUIRES: male or female
     * MODIFIES: this
     * EFFECTS: gender is new sex
     */
    public String setSex(String gender) {
        if (gender.equals("male") || gender.equals("female")) {
            sex = gender;
        }
        return sex;
    }

    /*
     * MODIFIES: this
     * EFFECTS: amount is new calorie count
     */
    public double calculateCalorieCount() {
        calorieCount = exerciseList.getExerciseCalories() + foodList.getFoodCalories();
        return calorieCount;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("targetCalories", targetCalories);
        json.put("calorieCount", calorieCount);
        json.put("height", height);
        json.put("weight", weight);
        json.put("age", age);
        json.put("bmi", bmi);
        json.put("sex", sex);
        json.put("exerciseList", exercisesToJson());
        json.put("foodList", foodsToJson());
        return json;
    }

    // EFFECTS: returns exercises in this profile as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Exercise e : getExerciseList().getExerciseList()) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns foods in this profile as a JSON array
    private JSONArray foodsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Food f : getFoodList().getFoodList()) {
            jsonArray.put(f.toJson());
        }

        return jsonArray;
    }


}