package assignments.task;

// Write a program same as (4) above, but accept floating point numbers.

import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.ArithmeticOperation;

// bellow code is no different from assingment5 just class name is changed 
// Inshort we dont need this assingment6 module we can use assingment5 module
// with FloatAddition class object as input 
// created for better understanding

@SuppressWarnings("rawtypes")
public class Assignment6 implements Task<String>{
    private float firstOperand;
    private float secondOperand;
    private ArithmeticOperation op;
    public Assignment6(InputHandler io , ArithmeticOperation inadd) {
        this.firstOperand = io.getFloatInput("Enter First Float Operand :");
        this.secondOperand = io.getFloatInput("Enter Second Float Operand :");
        this.op = inadd;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String execute() {
        return "num1=" + firstOperand + " num2=" + secondOperand + " sum=" + op.perform( firstOperand ,secondOperand);
    }

    public float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(float secondOperand) {
        this.secondOperand = secondOperand;
    }

    public float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public ArithmeticOperation getOp() {
        return op;
    }

    public void setOp(ArithmeticOperation op) {
        this.op = op;
    }
}   

