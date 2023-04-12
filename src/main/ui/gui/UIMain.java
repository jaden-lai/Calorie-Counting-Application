package ui.gui;

import java.io.FileNotFoundException;

public class UIMain {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            new CalorieAppUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
