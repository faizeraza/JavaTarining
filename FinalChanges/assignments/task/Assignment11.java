package assignments.task;

// 11. Extend (9) to support “countodd” and “counteven” operations to respectively print number of
//     times odd numbers and number of even numbers found within the list

import assignments.support.StatisticalOperations;
import assignments.support.ioHandling.InputHandler;
import java.util.ArrayList;

public class Assignment11 implements Task<String>{
    private ArrayList<Float> numbers;
    private int evenCount =0;
    private int oddCount =0;
    public Assignment11(InputHandler ipHandler) {
        // Get the list of numbers from the user via the input handler
        this.numbers = ipHandler.getListInput("Enter the Number Or Type Proceed:");
    }

    @Override
    public String execute() {
        StatisticalOperations counter = new StatisticalOperations(numbers);
        evenCount = counter.getEvenCount();
        oddCount = counter.getOddCount();
        return "The Number of Even values are :" + evenCount + "\nThe Number of Odd values are: "+oddCount;
    }

    public ArrayList<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Float> numbers) {
        this.numbers = numbers;
    }
}
