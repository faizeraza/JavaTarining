package assignments.task;

// 5. Write a program to prompt the user for 2 inputs: num1 and num2 and generate a sum of two
//    numbers as output. The program must accept only whole numbers (positive or negative) or
//    throw an error. The output shall be “num1=<num1> num2=<num2> sum=<result>” where
//    “<num1>”, “<num2>” and “<result>” will be replaced with actual value

import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.ArithmeticOperation;

@SuppressWarnings("rawtypes")
public class Assignment5 implements Task<String>{
    private int firstOperand;
    private int secondOperand;
    private ArithmeticOperation operation; // will be able to hold any child class instance of type ArithmeticOperation
    public Assignment5(InputHandler io , ArithmeticOperation intAdd) {
        this.firstOperand = io.getIntInput("Enter First Integer Operand :"); //will ask for input until and unless 
        this.secondOperand = io.getIntInput("Enter Second Integer Operand :"); //valid value is not provided
        this.operation = intAdd; //instance of IntAddition class has been passed here
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() {
        // bellow operation object containes overrided 
        // methode "perform()" from interface ArithmeticOperation
        // that is how we made programe flexible
        return "num1=" + firstOperand + " num2=" + secondOperand + " sum=" + operation.perform( firstOperand ,secondOperand);
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public ArithmeticOperation getOperation() {
        return operation;
    }

    public void setOperation(ArithmeticOperation operation) {
        this.operation = operation;
    }
}   
