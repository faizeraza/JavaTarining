package assingments;
import java.util.Scanner;

public class AddInt{
    Scanner sc;

    // Do not need to create the Scanner Class instance again and again using same
    public AddInt(Scanner input) {
        sc = input;
    }

    public void add(){
        try {    
            System.out.print("First Operand ");
            int firstOperand = sc.nextInt();
            sc.nextLine();
            System.out.print("Second Operand: ");
            int secondOperand = sc.nextInt();
            sc.nextLine();                            
            int sum = firstOperand + secondOperand;
            System.out.println("num1=" + firstOperand + " num2=" + secondOperand + " sum=" + sum);
        } catch (Exception e) {
            System.out.println("Error: Please enter valid whole numbers. "+e);
        }
    }

    // the input has been taken already at the time of instance creation inside constructor above
    // public void add(){
    //         try {    
    //             System.out.print("First Operand ");
    //             int num1 = sc.nextInt();
    //             sc.nextLine();
    //             System.out.print("Second Operand: ");
    //             int num2 = sc.nextInt();
    //             sc.nextLine();                            
    //             int sum = num1 + num2;
    //             System.out.println("num1=" + num1 + " num2=" + num2 + " sum=" + sum);

    //         } catch (Exception e) {
    //             System.out.println("Error: Please enter valid whole numbers. "+e);
    //         }
    // }

    // Bellow methode do not uses instance variable it is parameterized passing them in Main.java
    // public void addFloat(){
	// 	try {
    //         System.out.print("First Operand ");
    //         Float num1 = sc.nextFloat();
    //         sc.nextLine();
    //         System.out.print("Second Operand: ");
    //         Float num2 = sc.nextFloat();
    //         sc.nextLine();
	// 		float sum = num1 + num2;
	// 		System.out.println("num1="+num1+" num2="+num2+" sum="+sum);

	// 	} catch (Exception e) {
	// 		System.out.println("Error:Please enter valid Float numbers. "+e);
	// 	} 
	// }
}
