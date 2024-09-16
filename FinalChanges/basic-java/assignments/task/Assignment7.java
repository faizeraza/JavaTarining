package assignments.task;

// 7. Extend program (5) to accept 3 inputs: “num1”, “num2” and “operation” where operation
// could be “+”, “-”, “*” or “/” to represent sum, difference, multiplication or division. The output
// will be output of “num1” <operation> “num2”. The output shall be “num1=<num1>
// num2=<num2> <operation>=<result>” where “<operation>” will be replaced by the
// operation name. Use “sum”, “difference”, “multiply” and “divide” as an operation name.

import assignments.support.Calculator;
import assignments.support.ioHandling.InputHandler;


public class Assignment7 implements Task<String>{
    private Float firstOperand;
    private Float secondOperand;
    private Float result;
    private String operator;
    private String operationName;
    private Calculator calculator;

    public Assignment7(InputHandler io ) {
        this.firstOperand = io.getFloatInput("Enter First Float Operand :");
        this.secondOperand = io.getFloatInput("Enter Second Float Operand :");
        operator = io.getStringInput("Enter operation to be performed (+, -, *, /): ");
        calculator = new Calculator(firstOperand,secondOperand);
    }
    
    @Override
    public String execute() {
        switch (operator.trim()) {
            case "+" -> {
                result = calculator.add(); // converting to float Value
                operationName = "ADD";
            }
            case "-" -> {
                result = calculator.substract();
                operationName = "Substract";
            }
            case "*" -> {
                result = calculator.multiply();
                operationName = "Multiply";
            }
            case "/" -> {
                try {
                    result = calculator.divide();
                    operationName = "Divide";
                } catch (ArithmeticException e) {
                    return "Can Not Divide with 0";
                }
            }

            default -> {
                return "Error: Invalid operator provided. Use +, -, *, or /.";
            }
        }
        if (result==0f){
            return "";
        }
        return "num1="+firstOperand+" num2="+secondOperand+" "+operationName+"="+result; //return string into asked formate
    }

    public Float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Float secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    
}
