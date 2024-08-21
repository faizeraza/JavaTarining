package assingments;
import java.util.Scanner;

public class Calculator {
    Scanner sc;
    public Calculator(Scanner input) {
        sc = input;
    }
    public String calculate(){
        try {
            System.out.print("First Operand: ");
            float num1 = Float.parseFloat(sc.nextLine());
            System.out.print("Second Operand ");
            float num2 = Float.parseFloat(sc.nextLine());
            System.out.print("Enter operation to be performed (+, -, *, /): ");
            String operation = sc.nextLine().trim();
            float result;
            String operationName;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    operationName = "ADD";
                    break;
                case "-":
                    result = num1 - num2;
                    operationName = "Substract";
                    break;
                case "*":
                    result = num1 * num2;
                    operationName = "Multiply";
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        sc.close();
                        return null;
                    }
                    result = num1 / num2;
                    operationName = "Divide";
                    break;
                default:
                    System.out.println("Error: Invalid operator provided. Use +, -, *, or /.");
                    sc.close();
                    return null;
            }

            return "num1="+num1+" num2="+num2+" "+operationName+"="+result;
        } 
        catch (Exception e) {
            return "Error: Please enter valid floating-point numbers.";
        } 
	}
}
