package ui;

import model.Exercise;
import model.Food;
import model.Profile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Calorie tracking application
// Partial structure found from Teller Application
public class CalorieApp {
    private Profile profile;
    private Scanner input;
    private ArrayList<Food> foodList = new ArrayList<>();
    private ArrayList<Exercise> workoutList = new ArrayList<>();

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
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void processCommand(String command) {
        if (command.equals("e")) {
            addExercise();
        } else if (command.equals("t")) {
            removeExercise();
        } else if (command.equals("c")) {
            viewExerciseList();
        } else if (command.equals("f")) {
            addFood();
        } else if (command.equals("x")) {
            removeFood();
        } else if (command.equals("v")) {
            viewFoodList();
        } else if (command.equals("r")) {
            caloriesReset();
        } else if (command.equals("b")) {
            calculateCalories();
        } else if (command.equals("s")) {
            calorieSurplus();
        } else if (command.equals("d")) {
            calorieDeficit();
        } else if (command.equals("n")) {
            changeName();
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
        System.out.println("\nDay's calorie count:");
        System.out.println("\te -> add exercise");
        System.out.println("\tt -> remove exercise");
        System.out.println("\tc -> view current exercise list");
        System.out.println("\tf -> add food");
        System.out.println("\tx -> remove food");
        System.out.println("\tv -> view current food list");
        System.out.println("\tr -> reset calorie count");
        System.out.println("Modify calorie target:");
        System.out.println("\tb -> maintenance calories (reset any added/removed calories)");
        System.out.println("\ts -> calorie surplus (add calories)");
        System.out.println("\td -> calorie deficit (remove calories)");
        System.out.println("\n\tn -> change username");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void addExercise() {
        System.out.print("Enter exercise name:");
        String amount = input.next();
        System.out.print("Enter calories burned:");
        double amount2 = input.nextDouble();
        Exercise exercise1 = new Exercise(amount, amount2);

        profile.newCalorieCount(profile.getCalorieCount() - amount2);
        workoutList.add(exercise1);
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void removeExercise() {
        System.out.print("Enter exercise name to remove:");
        String amount = input.next();

        for  (int i = 0; i < workoutList.size(); i++) {
            Exercise e = workoutList.get(i);
            if (amount.equals(e.getExerciseName())) {
                profile.newCalorieCount(profile.getCalorieCount() + e.getCaloriesBurned());
                System.out.println(e.getExerciseName() + " removed");
                workoutList.remove(e);
                i--;
            }
        }
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void viewExerciseList() {
        if (foodList.size() == 0) {
            System.out.println("Exercise list is empty");
        } else {
            System.out.println("Current food list: \n");
            for (Exercise exercise : workoutList) {
                System.out.println(exercise.getExerciseName()
                        + " @ " + exercise.getCaloriesBurned() + " calories burned");
            }
        }
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void addFood() {
        System.out.print("Enter food name:");
        String amount = input.next();
        System.out.print("Enter calories:");
        double amount2 = input.nextDouble();
        Food food1 = new Food(amount, amount2);

        profile.newCalorieCount(amount2 + profile.getCalorieCount());
        foodList.add(food1);
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void removeFood() {
        System.out.print("Enter food name to remove:");
        String amount = input.next();

        for  (int i = 0; i < foodList.size(); i++) {
            Food f = foodList.get(i);
            if (amount.equals(f.getFoodName())) {
                profile.newCalorieCount(profile.getCalorieCount() - f.getFoodCalories());
                System.out.println(f.getFoodName() + " removed");
                foodList.remove(f);
                i--;
            }
        }
        System.out.println("\n");
    }

        // MODIFIES: this
        // EFFECTS: conducts a deposit transaction
    private void viewFoodList() {
        if (foodList.size() == 0) {
            System.out.println("Food list is empty");
        } else {
            System.out.println("Current food list: \n");
            for (Food food : foodList) {
                System.out.println(food.getFoodName() + " @ " + food.getFoodCalories() + " calories");
            }
        }
        System.out.println("\n");
    }






    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void caloriesReset() {
        System.out.print("Are you sure you want to reset your calories? (yes or any string to return)");
        String amount = input.next();

        if (amount.equals("yes")) {
            profile.newCalorieCount(0);
        }
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void calculateCalories() {
        System.out.print("Enter your height(cm):");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid height entered...\n");
        } else {
            profile.newHeight(amount);
            System.out.print("Enter your weight(kg):");
            double amount2 = input.nextDouble();
            if (amount2 <= 0) {
                System.out.println("Invalid weight entered...\n");
            } else {
                profile.newWeight(amount2);
                System.out.print("Enter your age:");
                int amount3 = input.nextInt();
                if (amount3 <= 0) {
                    System.out.println("Invalid age entered...\n");
                } else {
                    profile.newAge(amount3);
                    System.out.print("Enter your sex (male/female):");
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
        System.out.println("\n");
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
        System.out.println("\n");
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
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: conducts a deposit transaction
    private void changeName() {
        System.out.print("What would you like to be called?");
        String amount = input.next();

        profile.newName(amount);
        System.out.println("\n");
    }


}