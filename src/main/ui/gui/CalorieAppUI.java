package ui.gui;

import model.Event;
import model.EventLog;
import model.Exercise;
import model.Food;
import model.Profile;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Calorie tracking application
public class CalorieAppUI extends JFrame {
    private static final String JSON_STORE = "./data/profile.json";
    private Profile profile;
    private Event event;
    private EventLog eventLog;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JFrame frame;
    private JLabel label;
    private static final int WIDTH = 720;
    private static final int HEIGHT = 1280;

    // MODIFIES: this
    // EFFECTS: runs the calorie counting application
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public CalorieAppUI() throws FileNotFoundException {
        frame = new JFrame();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        profile = new Profile("User", 0, 0, 0, 0, 0, 0, "");

        Container c = frame.getContentPane();
        GridLayout grid = new GridLayout(5, 3, 10, 10);
        c.setLayout(grid);

        label = new JLabel("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories() + "</html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon originalIcon = new ImageIcon("data/chad.jpg");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        label.setIcon(scaledIcon);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        label.setIconTextGap(1);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);


        JButton maintenanceCalories = new JButton("Find Calorie Target");
        JButton modifyCalories = new JButton("Modify Calorie Target (+/-)");
        JButton addFood = new JButton("Add Food");
        JButton removeFood = new JButton("Remove Food");
        JButton addExercise = new JButton("Add Exercise");
        JButton removeExercise = new JButton("Remove Exercise");
        JButton resetCalories = new JButton("Reset today's calorie count");
        JButton viewFoods = new JButton("View List of Foods");
        JButton viewExercises = new JButton("View List of Exercises");
        JButton saveLoadProfile = new JButton("Save/Load Profile");
        JButton exit = new JButton("Exit");

        maintenanceCalories.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        modifyCalories.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        addFood.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        removeFood.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        addExercise.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        removeExercise.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        resetCalories.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        viewFoods.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        viewExercises.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        saveLoadProfile.setFont((new Font("Segoe UI", Font.PLAIN, 15)));
        exit.setFont((new Font("Segoe UI", Font.PLAIN, 15)));

        c.add(maintenanceCalories);
        c.add(label);
        c.add(modifyCalories);
        c.add(addFood);
        c.add(removeFood);
        c.add(viewFoods);
        c.add(addExercise);
        c.add(removeExercise);
        c.add(viewExercises);
        c.add(resetCalories);
        c.add(saveLoadProfile);
        c.add(exit);

        validate();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setTitle("Calorie Counting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((JPanel) frame.getContentPane()).setBorder((new EmptyBorder(12, 12, 12, 12)));


        // MODIFIES: this
        // EFFECTS: produces BMI and target calories based on user information
        maintenanceCalories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter your height(cm):");
                double height = Integer.parseInt(input);

                if (height <= 0) {
                    JOptionPane.showMessageDialog(frame, "Invalid height entered...");
                } else {
                    profile.setHeight(height);
                    input = JOptionPane.showInputDialog("Enter your weight(kg):");
                    double weight = Double.parseDouble(input);
                    if (weight <= 0) {
                        JOptionPane.showMessageDialog(frame, "Invalid weight entered...");
                    } else {
                        profile.setWeight(weight);
                        input = JOptionPane.showInputDialog("Enter your age:");
                        int age = Integer.parseInt(input);
                        if (age <= 0) {
                            JOptionPane.showMessageDialog(frame, "Invalid age entered...");
                        } else {
                            profile.setAge(age);
                            input = JOptionPane.showInputDialog("Enter your sex (male/female):");
                            if (input.equals("male")) {
                                profile.setSex("male");
                                profile.setCalories(66.5 + 13.75 * profile.getWeight()
                                        + 5.003 * profile.getHeight() - 6.75 * profile.getAge());
                            } else {
                                if (input.equals("female")) {
                                    profile.setSex("female");
                                    profile.setCalories(655.1 + 9.563 * profile.getWeight()
                                            + 1.850 * profile.getHeight() - 4.676 * profile.getAge());
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Invalid sex entered...");
                                }
                            }
                            profile.setBMI(profile.getWeight()
                                    / ((profile.getHeight() / 100) * (profile.getHeight() / 100)));
                            label.setText("<html>Welcome " + profile.getUsername()
                                    + "," + "<br> TODAY'S CALORIE COUNT: " + profile.getCalorieCount()
                                    + "<br>TARGET CALORIES: " + profile.getTargetCalories() + "</html>");
                        }
                    }
                }
            }
        });

        // MODIFIES: this
        // EFFECTS: adds exercise to workout list and removes burned calories from calorie count
        addExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter exercise name:");
                String exerciseName = input;
                input = JOptionPane.showInputDialog("Enter the amount of calories burned:");
                double caloriesBurned = Integer.parseInt(input);

                profile.getExerciseList().addExercise(exerciseName, caloriesBurned);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, exerciseName + " burning "
                        + caloriesBurned + " calories has been added to the list.");
                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");
            }
        });

        // MODIFIES: this
        // EFFECTS: removes an exercise from workout list and adds burned calories to calorie count
        removeExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter exercise to remove:");
                String exerciseName = input;

                profile.getExerciseList().removeExercise(input);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, exerciseName + "has been removed from the list.");
                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");
            }
        });

        // EFFECTS: prints workout list with exercise names and calories burned
        viewExercises.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (profile.getExerciseList().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Exercise list is empty.");
                } else {
                    JOptionPane.showMessageDialog(frame, "The following have been added to the list:");
                    for (Exercise exercise : profile.getExerciseList().getExerciseList()) {
                        JOptionPane.showMessageDialog(frame, exercise.getExerciseName() + " burned "
                                + exercise.getCaloriesBurned() + " calories");
                    }
                }
            }
        });

        // MODIFIES: this
        // EFFECTS: adds food to food list and adds calories to calorie count
        addFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter food name:");
                String foodName = input;
                input = JOptionPane.showInputDialog("Enter the food's calories:");
                double calories = Integer.parseInt(input);

                profile.getFoodList().addFood(foodName, calories);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, foodName + " with " + input
                        + " calories has been added to the list.");
                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");
            }
        });

        // MODIFIES: this
        // EFFECTS: removes food from food list and removes calories from calorie count
        removeFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter food to remove:");
                String foodName = input;

                profile.getFoodList().removeFood(input);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, foodName + "has been removed from the list.");
                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");
            }
        });

        // EFFECTS: prints food list with food names and calories
        viewFoods.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (profile.getFoodList().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Foods list is empty.");
                } else {
                    JOptionPane.showMessageDialog(frame, "The following have been added to the list:");
                    for (Food food : profile.getFoodList().getFoodList()) {
                        JOptionPane.showMessageDialog(frame, food.getFoodName() + " had "
                                + food.getFoodCalories() + " calories");
                    }
                }
            }
        });

        // MODIFIES: this
        // EFFECTS: sets calorie count to 0 and clears exercise and food list
        resetCalories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Are you sure you want to reset your counted calories?");
                String response = input;

                if (response.equals("yes")) {
                    profile.getFoodList().reset();
                    profile.getExerciseList().reset();
                    profile.calculateCalorieCount();
                    JOptionPane.showMessageDialog(frame, "Target calories have been reset");
                } else {
                    JOptionPane.showMessageDialog(frame, "Target calories have been left unchanged");
                }
                profile.calculateCalorieCount();

                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");
            }
        });

        // MODIFIES: this
        // EFFECTS: adds or removes calories from targeted calorie amount
        modifyCalories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Would you like to add or remove target calories?");

                if (input.equals("add")) {
                    String response = JOptionPane.showInputDialog("How many calories do you wish to be added?");
                    double add = Integer.parseInt(response);
                    profile.addCalories(add);
                } else {
                    if (input.equals("remove")) {
                        String response = JOptionPane.showInputDialog("How many calories do you wish to be removed?");
                        double remove = Integer.parseInt(response);
                        profile.removeCalories(remove);
                    }
                }
                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");

            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eventLog = EventLog.getInstance();
                for (Event event : eventLog) {
                    System.out.println(event.getDescription());
                }
                System.exit(0);
            }
        });

        // MODIFIES: this
        // EFFECTS: saves or loads profile from file
        saveLoadProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Would you like to save, load, or go back?");

                if (input.equals("save")) {
                    try {
                        jsonWriter.open();
                        jsonWriter.write(profile);
                        jsonWriter.close();
                        JOptionPane.showMessageDialog(frame, "Saved profile to " + JSON_STORE);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(frame, "Unable to write to file: " + JSON_STORE);
                    }
                } else {
                    if (input.equals("load")) {
                        try {
                            profile = jsonReader.read();
                            JOptionPane.showMessageDialog(frame, "Loaded profile from " + JSON_STORE);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(frame, "Unable to read from file: " + JSON_STORE);
                        }
                    }
                }
                label.setText("<html>Welcome " + profile.getUsername() + "," + "<br> TODAY'S CALORIE COUNT: "
                        + profile.getCalorieCount() + "<br>TARGET CALORIES: " + profile.getTargetCalories()
                        + "</html>");
            }
        });
    }
}