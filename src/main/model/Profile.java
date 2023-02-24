package model;

// Represents a profile which includes user info (name, calories, calorie count, height, weight, bmi, age, and sex)
public class Profile {
    private String name;                    // Profile name
    private double calories;                // the current target calories for a person
    private double calorieCount;            // a days calorie count
    private double height;                  // height of person
    private double weight;                  // weight of person
    private double bmi;                     // bmi of person
    private int age;                        // age of person
    private String sex;                     // sex of person

    /*
     * REQUIRES: name has a non-zero length
     * EFFECTS: constructs a profile with name, calories, calorie count, height, weight, bmi, age, and sex
     */
    public Profile(String name, double calories, double calorieCount, double height, double weight, int age, double bmi,
                   String sex) {
        this.name = name;
        this.calories = calories;
        this.calorieCount = calorieCount;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.age = age;
        this.sex = sex;
    }

    public String getUsername() {
        return name;
    }

    public double getCalories() {
        return calories;
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

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is added to calories
     */
    public double addCalories(double amount) {
        if (amount >= 0) {
            calories = calories + amount;
        }
        return calories;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is removed from calories
     */
    public double removeCalories(double amount) {
        if (amount >= 0) {
            calories = calories - amount;
        }
        return calories;
    }

    /*
     * MODIFIES: this
     * EFFECTS: string is new name
     */
    public String newName(String string) {
        name = string;
        return name;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is new calories value
     */
    public double newCalories(double amount) {
        if (amount >= 0) {
            calories = amount;
        }
        return calories;
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
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is new height
     */
    public double newHeight(double amount) {
        if (amount >= 0) {
            height = amount;
        }
        return height;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is new weight
     */
    public double newWeight(double amount) {
        if (amount >= 0) {
            weight = amount;
        }
        return weight;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is new age
     */
    public double newAge(int amount) {
        if (amount >= 0) {
            age = amount;
        }
        return age;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is new bmi
     */
    public double newBMI(double amount) {
        if (amount >= 0) {
            bmi = amount;
        }
        return bmi;
    }

    /*
     * REQUIRES: gender is male or female
     * MODIFIES: this
     * EFFECTS: gender is new sex
     */
    public String newSex(String gender) {
        sex = gender;
        return sex;
    }



}