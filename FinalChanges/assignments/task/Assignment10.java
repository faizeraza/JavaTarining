package assignments.task;

// 10. Extend (8) to support “sort” operation. Use an in-built function call for sorting numbers

import assignments.support.StatisticalOperations;
import assignments.support.ioHandling.InputHandler;
import java.util.ArrayList;

// represents a task that reads a list of integers from the user,
// sorts the list, and returns the sorted list.

// Implements the Task interface with ArrayList<Integer> as the return type.
public class Assignment10 implements Task<String> {
    private ArrayList<Float> numbers;
    private String operation;
    InputHandler ipHandler;
    public Assignment10(InputHandler ipHandler) {
        // Get the list of numbers from the user via the input handler
        this.numbers = ipHandler.getListInput("Enter the Number Or Type Proceed:");
        this.ipHandler = ipHandler;
    }

    /**
     * Executes the sorting task.
     * It sorts the list of numbers and returns the sorted list.
     * 
     * @return the sorted list of integers.
     */

    @Override
    public String execute() {
       StatisticalOperations sorter = new StatisticalOperations(numbers);
        operation = ipHandler.getStringInput("Enter Operation : \ncount\nmean\nmaximum\nminimum").toLowerCase();
        // The program should understand if user will put max insted of maximumsorter
        if (operation.contains("max")){
            operation = "maximum";
        }
        // The program should understand if user will put min insted of minimum
        else if (operation.contains("min")){
            operation = "minimum";
        }
        switch (operation) {

            case "count" -> {
                // to count the total number of valid entries by user
                
                return "Count: "+sorter.getCount();
            }

            case "mean" -> {
                // To get the mean of the numbers
                
                return "Mean: "+sorter.getMean();
            }

            case "maximum" -> {
                // for finding the maximum value among the given elements
                
                return "Maximum: "+sorter.getMaximum();
            }

            case "minimum" -> {
                // returns minimum value among the given numbers
                
                return "Minimum: "+sorter.getMinimum();
            }

            case "sort" -> {
                // returns minimum value among the given numbers
                
                return "Sorted List: "+sorter.sortList();
            }

            default -> System.out.println("enter a valid operation");

        }
        return "Null";
    }

    public ArrayList<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Float> numbers) {
        this.numbers = numbers;
    }
}
