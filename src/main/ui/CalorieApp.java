package ui;

import model.Food;
import model.Profile;

import java.util.ArrayList;
import java.util.Scanner;

// Calorie tracking application
// Partial structure found from Teller Application
public class CalorieApp {
    private Profile profile;
    private Scanner input;
    private ArrayList<Food> foodlist;
    private Food food;

    // EFFECTS: runs the calorie application
    public CalorieApp() {
        runCalorie();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCalorie() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nStay counting!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("e")) {
            calorieSurplus();
        } else if (command.equals("f")) {
            addFood();
        } else if (command.equals("r")) {
            caloriesReset();
        } else if (command.equals("b")) {
            calculateCalories();
        } else if (command.equals("s")) {
            calorieSurplus();
        } else if (command.equals("d")) {
            calorieDeficit();
        } else {
            System.out.println("Please select a valid option...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes profile
    private void init() {
        profile = new Profile("User", 0, 0,  0, 0, 0, 0, "");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.print("Hello " + profile.getUsername() + "," + "\n");
        System.out.print("BMI:" + profile.getBMI() + "\n");
        System.out.print("TODAY'S CALORIE COUNT:" + profile.getCalorieCount() + "\n");
        System.out.print("TARGET CALORIES:" + profile.getCalories() + "\n");
        System.out.println("\nToday's calorie count:");
        System.out.println("\te -> add exercise");
        System.out.println("\tf -> add food");
        System.out.println("\tr -> reset calorie count");
        System.out.println("Modify calorie target:");
        System.out.println("\tb -> maintenance calories (resets any added/removed calories)");
        System.out.println("\ts -> calorie surplus (add calories)");
        System.out.println("\td -> calorie deficit (remove calories)");
        System.out.println("\tq -> save/quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void addFood() {
        System.out.print("Enter food name:");
        String amount = input.next();
        System.out.print("Enter calories:");
        double amount2 = input.nextDouble();
        Food food1 = new Food(amount, amount2);

        foodlist.add(food);

        for (Food food : foodlist) {
            int count = 0;
            foodlist.get(count).getFoodName();
        }



    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void caloriesReset() {
        System.out.print("Are you sure you want to reset your calories? (yes or any string to return)");
        String amount = input.next();

        if (amount.equals("yes")) {
            profile.newCalorieCount(0);
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void calculateCalories() {
        System.out.print("Enter height(cm):");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid height entered...\n");
        } else {
            profile.newHeight(amount);
            System.out.print("Enter weight(kg):");
            double amount2 = input.nextDouble();
            if (amount2 <= 0) {
                System.out.println("Invalid weight entered...\n");
            } else {
                profile.newWeight(amount2);
                System.out.print("Enter age:");
                int amount3 = input.nextInt();
                if (amount3 <= 0) {
                    System.out.println("Invalid age entered...\n");
                } else {
                    profile.newAge(amount3);
                    System.out.print("Enter sex (male/female):");
                    String amount4 = input.next();
                    if (amount4.equals("male")) {
                        profile.newSex("male");
                        profile.newCalories(66.5 + 13.75 * profile.getWeight()
                                + 5.003 * profile.getHeight() - 6.75 * profile.getAge());
                    } else {
                        if (amount4.equals("female")) {
                            profile.newSex("female");
                            profile.newCalories(655.1 + 9.563 * profile.getWeight()
                                    + 1.850 * profile.getHeight() - 4.676 * profile.getAge());
                        } else {
                            System.out.println("Invalid sex entered...\n");
                        }
                        profile.newSex("");
                    }
                    profile.newBMI(profile.getWeight() / ((profile.getHeight() / 100) * (profile.getHeight() / 100)));
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void calorieSurplus() {
        System.out.print("Enter target calories to add:");
        double amount = input.nextDouble();

        if (amount >= 0.0) {
            profile.addCalories(amount);
        } else {
            System.out.println("Cannot add negative amount...\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void calorieDeficit() {
        System.out.print("Enter target calories to remove:");
        double amount = input.nextDouble();

        if (amount >= 0.0) {
            profile.removeCalories(amount);
        } else {
            System.out.println("Cannot remove negative amount...\n");
        }
    }



}