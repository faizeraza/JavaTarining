package assingments;
import java.util.Scanner;

public class AddInt{
    Scanner sc;
    int firstOperand,secondOperand;
    // Do not need to create the Scanner Class instance again and again using same
    public AddInt(Scanner input) {
        sc = input;
        System.out.print("First Operand: ");
        firstOperand = sc.nextInt();
        sc.nextLine();
        System.out.print("Second Operand: ");
        secondOperand = sc.nextInt();
        sc.nextLine();                   
    }

    public String add(){ 
        try {             
            int sum = firstOperand + secondOperand;
            return "num1=" + firstOperand + " num2=" + secondOperand + " sum=" + sum;
        } catch (Exception e) {
            return "Error: Please enter valid whole numbers. "+e;
        }
    }
}
