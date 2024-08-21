package assingments;
import java.util.Scanner;

public class AddFloat {
    Scanner sc;

    // Do not need to create the Scanner Class instance again and again using same
    public AddFloat(Scanner input) {
        sc = input;
    }

    public String add() {
        try {
            System.out.print("First Operand ");
            Float firstOperand = sc.nextFloat();
            sc.nextLine();
            System.out.print("Second Operand: ");
            Float secondOperand = sc.nextFloat();
            sc.nextLine();
            float sum = firstOperand + secondOperand;
            return "First Operand="+firstOperand+" Second Operand="+secondOperand+" sum="+sum;

        } catch (Exception e) {
            return "Error:Please enter valid Float numbers. "+e;
        }         
    }
    
}
