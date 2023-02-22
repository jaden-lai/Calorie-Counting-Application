package ui;

import model.Gameboard;

import java.util.Scanner;

// Tile matching game
public class MatchingGame {
    private Gameboard board;
    private Gameboard flashing;
    private Scanner input;


    // EFFECTS: runs the tile game
    public MatchingGame() { runTiles();}

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runTiles() {
        boolean keepRunning = true;
        String command = null;

        while (keepRunning) {
            displayStartScreen();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("d")) {
                keepRunning = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nThank you for playing!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("x")) {
            newGame();
        } else {
            System.out.println("Use 'x' to start new game or 'd' to quit");
        }
    }

    // EFFECTS: displays start screen to user
    private void displayStartScreen() {
        System.out.println("\nCHOOSE:");
        System.out.println("\tx -> new game");
        System.out.println("\td -> quit game");

        System.out.println("\nINSTRUCTIONS:");
        System.out.println("\tUser must select all given tiles that flash in order to progress and earn points.");

        printHighscore();
    }

    // MODIFIES: ????????????????????
    // EFFECTS: ?????????????????
    private void newGame() {

    }

    // EFFECTS: prints highest score to screen
    private void printHighscore(???? user) {
        System.out.printf("Highscore: %\n", user.getHighscore());
    }

}