package assignments.task;

import assignments.support.StringOperations;
import assignments.support.ioHandling.InputHandler;
import java.util.HashSet;

public class Assignment25 implements Task<String> {
    private HashSet<String> names; // Set to store student names
    private String name; // String to store the regex pattern or name to search

    // Override the execute method from the Task interface
    @Override
    public String execute() {
        try {
            // Create an instance of InputHandler to handle user inputs
            InputHandler inputHandler = new InputHandler();

            // Prompt the user to enter student names, ensuring only valid alphabetic inputs are accepted
            names = inputHandler.getWords("Enter Student Names: ", "^[a-zA-Z ]*$");

            // Prompt the user to enter a regular expression or search string
            name = inputHandler.getStringInput("Enter Regular Expression to search names: ");

            // Create an instance of StringOperations to perform the search operation on names
            StringOperations strOps = new StringOperations(names, name);

            // Return the names that match the search criteria using the provided regex
            return name + " Has Searched the following names:\n " + strOps.getSearchedNames();

        } catch (NullPointerException e) {
            // Return the error message if an exception occurs
            return e.getMessage();
        }
    }
}
