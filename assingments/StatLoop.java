package assingments;

import java.util.Scanner;

public class StatLoop {
    private Float sum = 0f;
    private Float max=Float.MIN_VALUE,min=Float.MAX_VALUE, count=0f,mean = 0f;
    Scanner sc;

    public StatLoop(Scanner sc) {
        this.sc = sc;
    }

    public float statLoop(){
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
                    float newNumber = Float.parseFloat(input);
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
