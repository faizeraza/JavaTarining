package assignments.task;

// 8. Write a program to prompt for one number at a time, till the user enters “proceed”. Upon
// receiving “proceed”, the program shall calculate the sum of all numbers and produce an
// output. Ensure that only valid numbers are considered as an input.

import assignments.support.StatisticalOperations;
import assignments.support.ioHandling.InputHandler;
import java.util.ArrayList;

public class Assignment8 implements Task<String>{
    private ArrayList<Float> numbers;
    public Assignment8(InputHandler op) {
        numbers = op.getListInput("Enter the Number Or Type Proceed:"); // function present in ConsoleInputHandler class
        //for taking number of elements into list and returning array list of them
    }

    @Override
    public String execute() {
        if (numbers.isEmpty()){
            return "No Number provided into list";
        }
        StatisticalOperations stOps = new StatisticalOperations(numbers); // Using general class StatisticalOperations
        return "Sum of all the numbers in the list : "+stOps.getSum(); // StatisticalOperations have methode getSum which return 
    } 

    public ArrayList<Float> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Float> numbers) {
        this.numbers = numbers;
    }

}
