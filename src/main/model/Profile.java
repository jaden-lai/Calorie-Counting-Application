package model;

// Represents a profile with username, calories, and user info
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
     * REQUIRES: username has a non-zero length
     * EFFECTS: name on account is set to accountName;
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

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is added to balance and updated
     * 			balance is returned
     */
    public double addCalories(double amount) {
        calories = calories + amount;
        return calories;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double removeCalories(double amount) {
        calories = calories - amount;
        return calories;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newCalories(double amount) {
        calories = amount;
        return calories;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newBMI(double amount) {
        bmi = amount;
        return bmi;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newAge(int amount) {
        age = amount;
        return age;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public String newSex(String gender) {
        sex = gender;
        return sex;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newHeight(double amount) {
        height = amount;
        return height;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newCalorieCount(double amount) {
        calorieCount = amount;
        return calorieCount;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is added to balance and updated
     * 			balance is returned
     */
    public double newWeight(double amount) {
        weight = amount;
        return weight;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public String newName(String string) {
        name = string;
        return name;
    }

}