package ui.gui;

import model.Profile;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class CalorieAppUI extends JFrame {
    private static final String JSON_STORE = "./data/profile.json";
    private Profile profile;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JFrame frame;
    private JLabel label;
    private static final int WIDTH = 720;
    private static final int HEIGHT = 1280;


    // P3 EdX Reference
    public CalorieAppUI() {
        frame = new JFrame();

            profile = new Profile("User", 0, 0, 0, 0, 0, 0, "");

        Container c = frame.getContentPane();
        GridLayout grid = new GridLayout(5, 3, 10, 10);
        c.setLayout(grid);

        label = new JLabel("<html>Welcome " + profile.getUsername() + ","
                + "<br> TODAY'S CALORIE COUNT: " + profile.getCalorieCount() + "<br>TARGET CALORIES: "
                + profile.getTargetCalories() + "</html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        JButton maintenanceCalories = new JButton("Find Calorie Target");
        JButton modifyCalories = new JButton("Modify Calorie Target (+/-)");
        JButton addFood = new JButton("Add Food");
        JButton removeFood = new JButton("Remove Food");
        JButton addExercise = new JButton("Add Exercise");
        JButton removeExercise = new JButton("Remove Exercise");
        JButton resetCalories = new JButton("Reset today's calorie count");
        JButton viewFoods = new JButton("View List of Foods");
        JButton viewExercises = new JButton("View List of Exercises");
        JButton saveProfile = new JButton("Save/Load Profile");
        JButton exit = new JButton("Exit");

        c.add(maintenanceCalories);
        c.add(label);
        c.add(addFood);
        c.add(modifyCalories);
        c.add(removeFood);
        c.add(addExercise);
        c.add(removeExercise);
        c.add(viewFoods);
        c.add(viewExercises);
        c.add(saveProfile);
        c.add(exit);

        frame.pack();
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setTitle("Calorie Counting App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((JPanel) frame.getContentPane()).setBorder((new EmptyBorder(12, 12, 12, 12)));

        addExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter exercise name:");
                String exerciseName = input;
                input = JOptionPane.showInputDialog("Enter the amount of calories burned:");
                double caloriesBurned = Integer.parseInt(input);

                profile.getExerciseList().addExercise(exerciseName, caloriesBurned);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, exerciseName + ", burning " + caloriesBurned + " calories has been added to the list.");
                label.setText("<html>Welcome " + profile.getUsername() + ","
                        + "<br> TODAY'S CALORIE COUNT: " + profile.getCalorieCount() + "<br>TARGET CALORIES: "
                        + profile.getTargetCalories() + "</html>");
            }
        });

        removeExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter exercise to remove:");
                String exerciseName = input;

                profile.getExerciseList().removeExercise(input);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, exerciseName + "has been removed from the list.");
                label.setText("<html>Welcome " + profile.getUsername() + ","
                        + "<br> TODAY'S CALORIE COUNT: " + profile.getCalorieCount() + "<br>TARGET CALORIES: "
                        + profile.getTargetCalories() + "</html>");
            }
        });

        addFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter food name:");
                String foodName = input;
                input = JOptionPane.showInputDialog("Enter the food's calories:");
                double calories = Integer.parseInt(input);

                profile.getFoodList().addFood(foodName, calories);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, foodName + " with " + input + " calories has been added to the list.");
                label.setText("<html>Welcome " + profile.getUsername() + ","
                        + "<br> TODAY'S CALORIE COUNT: " + profile.getCalorieCount() + "<br>TARGET CALORIES: "
                        + profile.getTargetCalories() + "</html>");
            }
        });

        removeFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter food to remove:");
                String foodName = input;

                profile.getFoodList().removeFood(input);
                profile.calculateCalorieCount();

                JOptionPane.showMessageDialog(frame, foodName + "has been removed from the list.");
                label.setText("<html>Welcome " + profile.getUsername() + ","
                        + "<br> TODAY'S CALORIE COUNT: " + profile.getCalorieCount() + "<br>TARGET CALORIES: "
                        + profile.getTargetCalories() + "</html>");
            }
        });


    }

}