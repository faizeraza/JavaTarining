package Mfr;
import java.util.Scanner;
import Mfr.Support.InnerAdd;

public class AddFloat implements InnerAdd{
    Scanner sc;

    // Do not need to create the Scanner Class instance again and again using same
    public AddFloat(Scanner input) {
        sc = input;
    }

    @Override
    public void add() {
        try {
            System.out.print("First Operand ");
            Float num1 = sc.nextFloat();
            sc.nextLine();
            System.out.print("Second Operand: ");
            Float num2 = sc.nextFloat();
            sc.nextLine();
            float sum = num1 + num2;
            System.out.println("num1="+num1+" num2="+num2+" sum="+sum);

        } catch (Exception e) {
            System.out.println("Error:Please enter valid Float numbers. "+e);
        }         
    }
    
}
