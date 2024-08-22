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
                System.out.println("Enter Number Or Type Proceed: ");
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
                    System.out.println("Number Of Even "+countEven+" Number of Odd : "+countOdd); 
                    System.out.println(arr);
                    return;
                }
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
