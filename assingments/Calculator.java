package assingments;
import java.util.Scanner;

public class Calculator extends AddFloat {
    public Calculator(Scanner input) {
        super(input);
    }
    
    public String calculate(){
        try {
            System.out.println("Enter operation to be performed (+, -, *, /): ");
            String operation = sc.nextLine();
            float result;
            String operationName;

            switch (operation) {
                case "+":
                    result = firstOperand + secondOperand;
                    operationName = "ADD";
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    operationName = "Substract";
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    operationName = "Multiply";
                    break;
                case "/":
                    if (secondOperand == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        sc.close();
                        return null;
                    }
                    result = firstOperand / secondOperand;
                    operationName = "Divide";
                    break;
                default:
                    System.out.println("Error: Invalid operator provided. Use +, -, *, or /.");
                    sc.close();
                    return null;
            }

            return "num1="+firstOperand+" num2="+secondOperand+" "+operationName+"="+result;
        } 
        catch (Exception e) {
            return "Error: Please enter valid floating-point numbers."+e;
        } 
	}
}
