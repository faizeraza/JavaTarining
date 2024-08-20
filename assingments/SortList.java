package assingments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortList {
    private ArrayList<Integer> arr = new ArrayList<>();
    Scanner sc;

    public SortList(Scanner sc) {
        this.sc = sc;
    }

    public ArrayList<Integer> sort(){
        
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
}
