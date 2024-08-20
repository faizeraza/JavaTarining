package assingments;

import java.util.ArrayList;
import java.util.Scanner;

public class CountEvenOdd {
    private ArrayList<Integer> arr = new ArrayList<>();
    Scanner sc;

    public CountEvenOdd(Scanner sc) {
        this.sc = sc;
    }

    public void countEvenOdd(){
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
