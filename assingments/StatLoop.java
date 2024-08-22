package assingments;

import java.util.Scanner;

public class StatLoop extends SumLoop{
    private Float add = 0f;
    private Float max=Float.MIN_VALUE,min=Float.MAX_VALUE, count=0f,mean = 0f;
    public StatLoop(Scanner sc) {
        super(sc);
    }

    public float statLoop(){
        try{
            while(true){
                System.err.println("Enter Number or Type Proceed/Mean/Min/Max/Count:");
                String input = sc.nextLine();
                if(input.toLowerCase().contains("proceed")){
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
                    add = sum(add, newNumber);
                    count ++;
                    max = Math.max(max, newNumber);
                    min = Math.min(min, newNumber);
                    mean = add/count;
                }
            }
        }
        catch(Exception e){
            System.out.println("Please Enter a valid number or Type Proceed: ");
        }
    return 0f;
    }
}
