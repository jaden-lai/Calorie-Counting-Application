package ui;

import model.Profile;

import java.util.Scanner;

// Bank teller application
public class CalorieApp {
    private Profile profile;
    private Scanner input;
    private double targetCalories;
    private double height;
    private double weight;
    private double bmi;
    private int age;
    private String sex;


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
        if (command.equals("b")) {
            calculateCalories();
        } else if (command.equals("s")) {
            calorieSurplus();
        } else if (command.equals("d")) {
            calorieDeficit();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        profile = new Profile("User", 0, 0, 0, 0, 0, "blank");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.print("BMI:" + profile.getBMI() + "\n");
        System.out.print("TARGET CALORIES:" + profile.getCalories() + "\n");
        System.out.println("\nSelect from:");
        System.out.println("\te -> add exercise");
        System.out.println("\tf -> add food");
        System.out.println("\nModify calorie target:");
        System.out.println("\tb -> maintenance calories based on BMI");
        System.out.println("\ts -> calorie surplus (add calories)");
        System.out.println("\td -> calorie deficit (remove calories)");
        System.out.println("\tq -> save/quit");
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
            this.height = amount;
            System.out.print("Enter weight(kg):");
            double amount2 = input.nextDouble();
            if (amount2 <= 0) {
                System.out.println("Invalid weight entered...\n");
            } else {
                this.weight = amount2;
                System.out.print("Enter age:");
                int amount3 = input.nextInt();
                if (amount3 <= 0) {
                    System.out.println("Invalid age entered...\n");
                } else {
                    this.age = amount3;
                    System.out.print("Enter sex (male/female):");
                    String amount4 = input.next();
                    if (amount4.equals("male")) {
                        this.sex = amount4;
                        profile.newCalories(66.5 + 13.75 * weight + 5.003 * height - 6.75 * age);
                    } else {
                        if (amount4.equals("female")) {
                            this.sex = amount4;
                            profile.newCalories(655.1 + 9.563 * weight + 1.850 * height - 4.676 * age);
                        } else {
                            System.out.println("Invalid sex entered...\n");
                        }
                        this.sex = amount4;
                    }
                    profile.newBMI(weight / ((height / 100) * (height / 100)));
                    bmi = profile.getBMI();
                    targetCalories = profile.getCalories();
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