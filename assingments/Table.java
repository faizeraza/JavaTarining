package assingments;

import java.util.Scanner;

public class Table {
    Scanner sc;
    public Table(Scanner input) {
        sc = input;
    }
    public void printTable(){
        try{
            System.out.println("Which Number you want table of?");
            int number = sc.nextInt();
            System.out.println("how many multiplications?");
            int times = sc.nextInt();
            for (int i = 1 ; i<=times; i++){
                System.out.println(number+" * "+i);
            }
        }
        catch(Exception e){
            System.out.println("Enter a Valid Input");
        }
    } 
}
