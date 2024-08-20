package assingments;

import java.util.Scanner;

public class StatLoop {
    private int sum = 0;
    private int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE, count=0,mean = 0;
    Scanner sc;

    public StatLoop(Scanner sc) {
        this.sc = sc;
    }

    public int statLoop(){
        try{
           
            while(true){
                System.err.println("Enter Number or Type Proceed/Mean/Min/Max/Count:");
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
}
