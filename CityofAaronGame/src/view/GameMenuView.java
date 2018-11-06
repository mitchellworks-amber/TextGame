/*
 * Describe class. This view engages when...
 */
package view;

import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class GameMenuView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public GameMenuView() {
        message = "\n\n--------------------\n"
                + "Game Menu\n"
                + "------------\n"
                + "M - view (M)ap\n"
                + "L - move to a new (L)ocation\n"
                + "\n";
    }

    /**
     * Get the user's input. Keep prompting them until they enter a value.
     *
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return
     */
    protected String getUserInput(String prompt, boolean allowEmpty) {

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        while (inputReceived == false) {

            System.out.println(prompt);
            input = keyboard.nextLine();

            // Make sure we avoid a null-pointer error.
            if (input == null) {
                input = "";
            }

            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();

            if (input.equals("") == false || allowEmpty == true) {
                inputReceived = true;
            }
        }

        return input;
    }

    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have to type it ourselves.
     *
     * @param prompt
     * @return
     */
    protected String getUserInput(String prompt) {
        return getUserInput(prompt, false);
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    public String[] getInputs() {

        // Declare the array to have the number of elements we'll get 
        // from the user.
        String[] inputs = new String[1];
        inputs[0] = getUserInput("Please select a choice from the Game Menu.");

        // Repeat for each input we need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        switch (inputs[0].trim().toUpperCase()) {
            case "M":
                viewMap();
                break;
            case "L":
                moveLocation();
                break;
            case "X":
                System.out.println("Returning to the Main Menu.");
                return false;
        }

        return true;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses an action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    // Define action handlers here. These are the methods that the doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void viewMap() {
        MapView view = new MapView();
        view.displayView();
    }
    private void moveLocation() {
        MoveLocationView view = new MoveLocationView();
        view.displayView();
    }

}