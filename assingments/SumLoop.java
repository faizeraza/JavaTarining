package assingments;

import java.util.Scanner;

public class SumLoop {
    Scanner sc;
    public float sum =0f;
    public SumLoop(Scanner sc) {
        this.sc = sc;
    }
    protected float sum(float number , float newNumber){
        return number+newNumber;
    }
    public Float sumLoop(){
        try{
            while(true){
                System.err.println("Enter Number or Type Sum:");
                String input = sc.nextLine();
                if(input.toLowerCase().equals("proceed")){
                    System.out.print("Addition");
                    return sum;
                }
                else{
                    float newNumber = Float.parseFloat(input);
                    sum = sum(sum , newNumber);
                }
            }
        }
        catch(Exception e){
            System.out.println("Please Enter a valid number or Type Proceed: ");
        }
        return sum;
    }
}
