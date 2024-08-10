package Mfr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculator {
    Scanner sc;
    public Calculator(Scanner input) {
        sc = input;
    }
    public void calculate(){
        try {
            System.out.print("First Operand ");
            float num1 = Float.parseFloat(sc.nextLine());
            sc.nextLine();
            System.out.print("Second Operand ");
            float num2 = Float.parseFloat(sc.nextLine());
            sc.nextLine();
            System.out.print("Enter operation to be performed (+, -, *, /): ");
            String operation = sc.nextLine().trim();
            sc.nextLine();
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
                        return;
                    }
                    result = num1 / num2;
                    operationName = "Divide";
                    break;
                default:
                    System.out.println("Error: Invalid operator provided. Use +, -, *, or /.");
                    sc.close();
                    return;
            }

            System.out.println("num1="+num1+" num2="+num2+" "+operationName+"="+result);
        } 
        catch (Exception e) {
            System.out.println("Error: Please enter valid floating-point numbers.");
        } 
	}

    public int statLoop(){
        Boolean flag = true; 
        int sum = 0;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE, count=0,mean = 0;
        try{
           
            while(flag){
                System.err.println("Enter Number to add or Type Proceed/Mean/Min/Max/Count:");
                String input = sc.nextLine();
                if(input.toLowerCase().equals("proceed")){
                    System.out.print("Addition");
                    return sum;
                }
                else if(input.toLowerCase().contains("min")){
                    System.out.println("Minimun ");
                    return min;
                }
                else if(input.toLowerCase().contains("max")){
                    System.out.println("Maximum ");
                    return max;
                }
                else if(input.toLowerCase().contains("mean")){
                    System.out.println("Mean ");
                    return mean;
                }
                else if(input.toLowerCase().contains("count")){
                    System.out.println("Count ");
                    return count;
                }
                else{
                    int newNumber = Integer.parseInt(input);
                    sum = sum + newNumber;
                    count ++;
                    max = Math.max(max, newNumber);
                    min = Math.min(min, newNumber);
                    mean = sum/count;
                }
            }
        }
        catch(Exception e){
            System.out.println("Please Enter a valid number or Type Proceed: ");
        }
        return sum;
    }

    public ArrayList<Integer> sort(){
        ArrayList<Integer> arr = new ArrayList<>();
        try{
            while (true) {
                String input = sc.next();
                sc.nextLine();
                if (input.toLowerCase().equals("proceed")){
                    Collections.sort(arr);
                    return arr;
                }
                else{
                    arr.add(Integer.parseInt(input));
                }
            }
        }
        catch(Exception e){
            System.out.println("Enter A valid number :");
        }
        return arr;
    }

    public void countEvenOdd(){
        ArrayList<Integer> arr = new ArrayList<>();
        int countEven = 0,countOdd=0;
        try{
            while (true) {
                String input = sc.next();
                sc.nextLine();
                if (input.toLowerCase().equals("proceed")){
                    for (int ele: arr){
                        if (ele%2==0){
                            countEven++;
                        }
                        else{
                            countOdd++;
                        }
                    }
                    System.out.print("Number Of Even "+countEven+"Number of Odd :"+countOdd);              }
                else{
                    arr.add(Integer.parseInt(input));
                }
            }
        }
        catch(Exception e){
            System.out.println("Enter A valid number :");
        }
    }
}
