package model;

// Represents an profile with username and BMI
public class Profile {
    private static int nextAccountId = 1;  // tracks id of next account created
    private String name;                   // the account owner name
    private double calories;                // the current balance of the account
    private double height = 0;
    private double weight = 0;
    private double bmi = 0;
    private int age = 0;
    private String sex;

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName; account id is a
     *          positive integer not assigned to any other account;
     *          if initialBalance >= 0 then balance on account is set to
     *          initialBalance, otherwise balance is zero.
     */
    public Profile(String username, double initialCalories, double height, double weight, int age, double bmi,
                   String sex) {
        name = username;
        if (initialCalories >= 0) {
            calories = initialCalories;
        } else {
            calories = 0;
        }
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

    public String getSex() {
        return sex;
    }

    /*
     * REQUIRES: amount >= 0
     * MODIFIES: this
     * EFFECTS: amount is added to balance and updated
     * 			balance is returned
     */
    public double addCalories(double amount) {
        calories = calories + amount;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double removeCalories(double amount) {
        calories = calories - amount;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newCalories(double amount) {
        calories = amount;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newBMI(double amount) {
        bmi = amount;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newAge(int amount) {
        age = amount;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public String newSex(String gender) {
        sex = gender;
    }

    /*
     * REQUIRES: amount >= 0 and amount <= getBalance()
     * MODIFIES: this
     * EFFECTS: amount is withdrawn from account and updated
     * 		    balance is returned
     */
    public double newHeight(double amount) {
        height = amount;
    }

}