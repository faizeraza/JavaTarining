package assignments.task;

import java.util.HashSet;

import assignments.support.StringOperations;
import assignments.support.ioHandling.InputHandler;

public class Assignment24 implements Task<String> {
    private HashSet<String> names; // Set to store student names
    private String name; // String to store the student's name to be checked

    // Override the execute method from the Task interface
    @Override
    public String execute() {
        // Create an instance of InputHandler to handle user inputs
        InputHandler inputHandler = new InputHandler();

        // Prompt the user to enter student names, ensuring only valid alphabetic inputs are accepted
        names = inputHandler.getWords("Enter Student Names: ", "^[a-zA-Z ]*$");

        // Prompt the user to enter a student's name to check
        name = inputHandler.getStringInput("Enter Student Name to check: ");

        // Create an instance of StringOperations to check if the student name is present in the set
        StringOperations strOps = new StringOperations(names, name);

        // Check if the name is present in the list and return the appropriate message
        if (strOps.isPresent())
            return name + " is present in Student List";
        return name + " is not present in Student List";
    }
}
