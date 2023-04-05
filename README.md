# Daily Calorie Counting Application

## What will the application do?

This application will consist of multiple parts:

- **Main UI** *screen*: Target calorie and calorie counter displayed with ability to modify calories, food consumption,
  and fitness.

This calorie counting application will allow users to calorie count through their daily activities from food
consumption, to fitness. A user's 'target' calorie goal will be calculated using the Harris-Benedict equation based off
user-inputted information about themselves such as height and body weight; they will be able to modify this target based
on their goals.

NOTE: The UI presented in this application references the 'Teller App', 'JsonSerializationDemo', and 'Phase 3 EdX GUI'
closely provided in
CPSC 210.

## Who will use it?

This application aims to help those trying to gain, lose, or maintain their weight by tracking calories to establish a
calorie surplus, deficit, or maintenance to meet the user's goals.

## Why is this project of interest to you?

I committed myself to the gym 5-6 days a week since the October of 2021, growing a passion for fitness and bodybuilding.
It's become an integral part of my day-to-day life Anyone who bodybuilds knows the importance of calorie counting and
its significance in controlling body weight and body fat. There are many calorie and weight tracking apps out there
today. However, I think it would be interesting to tackle this as my first project and attempt creating one of my own.

## User Stories

- As a user, I want to be able to add/remove an exercise to my calorie counter
- As a user, I want to be able to add/remove foods from my calorie counter
- As a user, I want to be able to see my target calorie count
- As a user, I want to be able to choose my calorie goal
- As a user, I want to be able to save my profile if I choose
- As a user, I want to be able to load a previous save when I start the application

## Instructions for Grader

- You can generate the first required action related to adding Xs to a Y by clicking corresponding 'add' food/exercise
  buttons and typing the name and calories of food/exercise
- You can generate the second required action related to adding Xs to a Y by clicking 'remove' food/exercise buttons and
  typing name of food/exercise to remove OR reset button to clear both
- You can locate my visual component by starting the application on the main menu
- You can save the state of my application by clicking the "Save/Load Profile" button and typing "save"
- You can reload the state of my application by "Save/Load Profile" button and typing "load"

## Phase 4: Task 2

- Tue Apr 04 21:18:17 PDT 2023
- banana with 100.0 calories has been added to food list
- Tue Apr 04 21:18:17 PDT 2023
- calorie count updated
- Tue Apr 04 21:18:21 PDT 2023
- apple with 200.0 calories has been added to food list
- Tue Apr 04 21:18:21 PDT 2023
  -calorie count updated
- Tue Apr 04 21:18:25 PDT 2023
- running burning 120.0 calories has been added to the list
- Tue Apr 04 21:18:25 PDT 2023
- calorie count updated
- Tue Apr 04 21:18:31 PDT 2023
- apple with 200.0 calories has been removed from food list
- Tue Apr 04 21:18:31 PDT 2023
- calorie count updated

## Phase 4: Task 3

Many changes could be made to improve the design of my calorie app project. The code in the ExerciseList class and FoodList class are exact replications of one another, the only difference being
that one stores foods, and one stores exercise objects. The methods are exactly identical otherwise. I could improve the
design by creating an abstract class to reduce the significant amount of redundant code in each class by extending ExerciseList
and FoodList to this class.