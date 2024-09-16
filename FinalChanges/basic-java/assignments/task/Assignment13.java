package assignments.task;

// 13. Write a program to prompt for three inputs: character to be used for display, num1 to
// represent number of rows and num2 to represent number of columns. The output will be a
// rectangular matrix where each cell will print a character input as a first input value.

import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.Matrix;

public class Assignment13 implements Task<String>{
    InputHandler inputHandler;
    public Assignment13(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public String execute() { 
        Matrix matrix = new Matrix(inputHandler); // Calling support class which takes number and times as input
        return matrix.printMatrix();
    }
    
}
