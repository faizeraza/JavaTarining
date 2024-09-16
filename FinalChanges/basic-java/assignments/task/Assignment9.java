package assignments.task;

import assignments.support.StatisticalOperations;
import assignments.support.ioHandling.InputHandler;
import java.util.ArrayList;

public class Assignment9 implements Task<String>{
    private ArrayList<Float> numbers;   // ArrayList for 
    private String operation;
    private final InputHandler ipHandler;
    public Assignment9(InputHandler ipHandler) {
        numbers = ipHandler.getListInput("Enter the Number Or Type Proceed:");
        this.ipHandler = ipHandler;
    }

    @Override
    public String execute() {

        StatisticalOperations statOps = new StatisticalOperations(numbers);
            operation = ipHandler.getStringInput("Enter Operation : \ncount\nmean\nmaximum\nminimum").toLowerCase();
            // The program should understand if user will put max insted of maximum
            if (operation.contains("max")){
                operation = "maximum";
            }
            // The program should understand if user will put min insted of minimum
            else if (operation.contains("min")){
                operation = "minimum";
            }
        return switch (operation) {
            case "count" -> "Count: "+statOps.getCount();
            case "mean" -> "Mean: "+statOps.getMean();
            case "maximum" -> "Maximum: "+statOps.getMaximum();
            case "minimum" -> "Minimum: "+statOps.getMinimum();
            default -> "enter a valid operation";
        }; // to count the total number of valid entries by user
        // To get the mean of the numbers
        // for finding the maximum value among the given elements
        // returns minimum value among the given numbers
    }

    public ArrayList<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Float> numbers) {
        this.numbers = numbers;
    }
}
