package assingments;
import java.util.Scanner;

public class AddFloat {
    Scanner sc;
    Float firstOperand,secondOperand;
    // Do not need to create the Scanner Class instance again and again using same
    public AddFloat(Scanner input) {
        sc = input;
        System.out.print("First Operand: ");
        firstOperand = sc.nextFloat();
        sc.nextLine();
        System.out.print("Second Operand: ");
        secondOperand = sc.nextFloat();
        sc.nextLine();
    }

    public String add() {
        try {
            float sum = firstOperand + secondOperand;
            return "num1 = "+firstOperand+" num2 = "+secondOperand+" sum = "+sum;

        } catch (Exception e) {
            return "Error:Please enter valid Float numbers. "+e;
        }         
    }
    
}
