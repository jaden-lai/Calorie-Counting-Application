package model;

// Represents a profile which includes user info (name, calories, calorie count, height, weight, bmi, age, and sex)
public class Profile {
    private String name;                    // Profile name
    private double targetCalories;                // the current target calories for a person
    private double calorieCount;            // a days calorie count
    private double height;                  // height of person
    private double weight;                  // weight of person
    private double bmi;                     // bmi of person
    private int age;                        // age of person
    private String sex;                     // sex of person
    private ExerciseList exerciseList;      // person's exercise list
    private FoodList foodList;              // person's food list

    /*
     * REQUIRES: name has a non-zero length
     * EFFECTS: constructs a profile with name, calories, calorie count, height, weight, bmi, age, and sex
     */
    public Profile(String name, double targetCalories, double calorieCount, double height, double weight, int age,
                   double bmi, String sex) {
        this.name = name;
        this.targetCalories = targetCalories;
        this.calorieCount = calorieCount;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.age = age;
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

    public double getBMI() {
        return bmi;
    }

    public int getAge() {
        return age;
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
     * REQUIRES: amount > 0
     * MODIFIES: this
     * EFFECTS: amount is removed from calories
     */
    public double removeCalories(double amount) {
        if (amount >= 0) {
            targetCalories = targetCalories - amount;
        }
        return targetCalories;
    }

    /*
     * MODIFIES: this
     * EFFECTS: string is new name
     */
    public String setName(String string) {
        name = string;
        return name;
    }

    /*
     * MODIFIES: this
     * EFFECTS: amount is new calories value
     */
    public double newCalories(double amount) {
        targetCalories = amount;
        return targetCalories;
    }

    /*
     * MODIFIES: this
     * EFFECTS: amount is new calorie count
     */
    public double newCalorieCount(double amount) {
        calorieCount = amount;
        return calorieCount;
    }

    /*
     * REQUIRES: amount > 0
     * MODIFIES: this
     * EFFECTS: amount is new height
     */
    public double newHeight(double amount) {
        if (amount > 0) {
            height = amount;
        }
        return height;
    }

    /*
     * REQUIRES: amount > 0
     * MODIFIES: this
     * EFFECTS: amount is new weight
     */
    public double newWeight(double amount) {
        if (amount > 0) {
            weight = amount;
        }
        return weight;
    }

    /*
     * REQUIRES: amount > 0
     * MODIFIES: this
     * EFFECTS: amount is new age
     */
    public double newAge(int amount) {
        if (amount > 0) {
            age = amount;
        }
        return age;
    }

    /*
     * MODIFIES: this
     * EFFECTS: amount is new bmi
     */
    public double newBMI(double amount) {
        bmi = amount;
        return bmi;
    }

    /*
     * REQUIRES: male or female
     * MODIFIES: this
     * EFFECTS: gender is new sex
     */
    public String newSex(String gender) {
        if (gender.equals("male") || gender.equals("female")) {
            sex = gender;
        }
        return sex;
    }

    /*
     * MODIFIES: this
     * EFFECTS: amount is new calorie count
     */
    public double burnCalories(double amount) {
        calorieCount = calorieCount - amount;
        return calorieCount;
    }

    /*
     * MODIFIES: this
     * EFFECTS: amount is new calorie count
     */
    public double gainCalories(double amount) {
        calorieCount = calorieCount + amount;
        return calorieCount;
    }



    /*
     * MODIFIES: this
     * EFFECTS: amount is new calorie count
     */
    public double calculateCalorieCount() {
        calorieCount = exerciseList.getExerciseCalories() + foodList.getFoodCalories();
        return calorieCount;
    }



}