package assignments.task;

// 12 . Write a program to prompt for two whole positive numbers -- “num1” and “num2”. Print
// multiplication table for the number e.g. for num1=3 and num2=20, output will be “3 * 1 = 3\n3
// * 2 = 6\n … \n3 * 20 = 60”.
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.Table;

public class Assignment12 implements Task<String>{
    int number,times;

    public Assignment12(InputHandler inputHandler) {
        this.number = inputHandler.getIntInput("Which Number you want table of?");
        this.times = inputHandler.getIntInput("how many multiplications?");
    }

    @Override
    public String execute() { 
        if((number<0)||(times<0)){//Weather the given inputs are positive or not
            return "entered value is not a positive number";
        }

        Table table = new Table(number, times); // Calling support class which takes number and times as input
        return table.printTable();
    }
    
}
