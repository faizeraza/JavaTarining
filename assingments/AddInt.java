package assingments;
import java.util.Scanner;

public class AddInt{
    Scanner sc;

    // Do not need to create the Scanner Class instance again and again using same
    public AddInt(Scanner input) {
        sc = input;
    }

    public String add(){
        try {    
            System.out.print("First Operand ");
            int firstOperand = sc.nextInt();
            sc.nextLine();
            System.out.print("Second Operand: ");
            int secondOperand = sc.nextInt();
            sc.nextLine();                            
            int sum = firstOperand + secondOperand;
            return "num1=" + firstOperand + " num2=" + secondOperand + " sum=" + sum;
        } catch (Exception e) {
            return "Error: Please enter valid whole numbers. "+e;
        }
    }
}
