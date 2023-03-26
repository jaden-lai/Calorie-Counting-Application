package ui;

import model.Exercise;
import model.Food;
import model.Profile;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Calorie tracking application
public class CalorieApp {
    private static final String JSON_STORE = "./data/profile.json";
    private Profile profile;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the calorie application
    public CalorieApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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

        System.out.println("\nCounting so you don't have to!");
    }

    // EFFECTS: saves the profile to file
    private void saveProfile() {
        try {
            jsonWriter.open();
            jsonWriter.write(profile);
            jsonWriter.close();
            System.out.println("Saved profile to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads profile from file
    private void loadProfile() {
        try {
            profile = jsonReader.read();
            System.out.println("Loaded profile from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
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
        } else if (command.equals("k")) {
            saveProfile();
        } else if (command.equals("l")) {
            loadProfile();
        } else {
            System.out.println("Please select a valid option...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes profile
    private void init() {
        profile = new Profile("User", 0, 0, 0, 0, 0, 0, "");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.print("Hello " + profile.getUsername() + "," + "\n");
        System.out.print("BMI:" + profile.getBMI() + "\n");
        System.out.print("TODAY'S CALORIE COUNT:" + profile.getCalorieCount() + "\n");
        System.out.print("TARGET CALORIES:" + profile.getTargetCalories() + "\n");
        System.out.println("\nDay's calorie count:");
        System.out.println("\te -> add exercise");
        System.out.println("\tt -> remove exercise");
        System.out.println("\tc -> view current exercise list");
        System.out.println("\tf -> add food");
        System.out.println("\tx -> remove food");
        System.out.println("\tv -> view current food list");
        System.out.println("\tr -> reset calorie and day's lists");
        System.out.println("Modify calorie target:");
        System.out.println("\tb -> maintenance calories (reset any added/removed calories)");
        System.out.println("\ts -> calorie surplus (add calories)");
        System.out.println("\td -> calorie deficit (remove calories)");
        System.out.println("miscellaneous:");
        System.out.println("\tn -> change username");
        System.out.println("\tk -> SAVE/OVERRIDE PROFILE");
        System.out.println("\tl -> LOAD PROFILE");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds exercise to workout list and removes burned calories from calorie count
    private void addExercise() {
        System.out.print("Enter exercise name:");
        String amount = input.next();
        System.out.print("Enter calories burned:");
        double amount2 = input.nextDouble();
        profile.getExerciseList().addExercise(amount, amount2);

        profile.calculateCalorieCount();
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: removes an exercise from workout list and adds burned calories to calorie count
    private void removeExercise() {
        System.out.print("Enter exercise name to remove:");
        String amount = input.next();

        profile.getExerciseList().removeExercise(amount);
        profile.calculateCalorieCount();
    }

    // EFFECTS: prints workout list with exercise names and calories burned
    private void viewExerciseList() {
        if (profile.getExerciseList().isEmpty()) {
            System.out.println("Exercise list is empty");
        } else {
            System.out.println("Current exercise list: \n");
            for (Exercise exercise : profile.getExerciseList().getExerciseList()) {
                System.out.println(exercise.getExerciseName()
                        + " @ " + exercise.getCaloriesBurned() + " calories burned");
            }
        }
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: adds food to food list and adds calories to calorie count
    private void addFood() {
        System.out.print("Enter food name:");
        String amount = input.next();
        System.out.print("Enter calories:");
        double amount2 = input.nextDouble();
        profile.getFoodList().addFood(amount, amount2);

        profile.calculateCalorieCount();
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: removes food from food list and removes calories from calorie count
    private void removeFood() {
        System.out.print("Enter food name to remove:");
        String amount = input.next();

        profile.getFoodList().removeFood(amount);
        profile.calculateCalorieCount();
        System.out.println("\n");
    }

    // EFFECTS: prints food list with food names and calories
    private void viewFoodList() {
        if (profile.getFoodList().isEmpty()) {
            System.out.println("Food list is empty");
        } else {
            System.out.println("Current food list: \n");
            for (Food food : profile.getFoodList().getFoodList()) {
                System.out.println(food.getFoodName() + " @ " + food.getFoodCalories() + " calories");
            }
        }
        System.out.println("\n");
    }


    // MODIFIES: this
    // EFFECTS: sets calorie count to 0 and clears exercise and food list
    private void caloriesReset() {
        System.out.print("Are you sure you want to reset your calories? (yes or no)");
        String amount = input.next();

        if (amount.equals("yes")) {
            profile.getFoodList().reset();
            profile.getExerciseList().reset();
            profile.calculateCalorieCount();

        }
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: produces BMI and target calories based on user information
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void calculateCalories() {
        System.out.print("Enter your height(cm):");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid height entered...\n");
        } else {
            profile.setHeight(amount);
            System.out.print("Enter your weight(kg):");
            double amount2 = input.nextDouble();
            if (amount2 <= 0) {
                System.out.println("Invalid weight entered...\n");
            } else {
                profile.setWeight(amount2);
                System.out.print("Enter your age:");
                int amount3 = input.nextInt();
                if (amount3 <= 0) {
                    System.out.println("Invalid age entered...\n");
                } else {
                    profile.setAge(amount3);
                    System.out.print("Enter your sex (male/female):");
                    String amount4 = input.next();
                    if (amount4.equals("male")) {
                        profile.setSex("male");
                        profile.setCalories(66.5 + 13.75 * profile.getWeight()
                                + 5.003 * profile.getHeight() - 6.75 * profile.getAge());
                    } else {
                        if (amount4.equals("female")) {
                            profile.setSex("female");
                            profile.setCalories(655.1 + 9.563 * profile.getWeight()
                                    + 1.850 * profile.getHeight() - 4.676 * profile.getAge());
                        } else {
                            System.out.println("Invalid sex entered...\n");
                        }
                        profile.setSex("");
                    }
                    profile.setBMI(profile.getWeight() / ((profile.getHeight() / 100) * (profile.getHeight() / 100)));
                }
            }
        }
        System.out.println("\n");
    }

    // MODIFIES: this
    // EFFECTS: adds calories to targeted calorie amount
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
    // EFFECTS: removes calories from targeted calorie amount
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
    // EFFECTS: changes name of user
    private void changeName() {
        System.out.print("What would you like to be called?");
        String amount = input.next();

        profile.setName(amount);
        System.out.println("\n");
    }


}