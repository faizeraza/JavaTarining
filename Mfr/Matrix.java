package Mfr;
import java.util.Scanner;

public class Matrix {
    Scanner sc;
    public Matrix(Scanner sc) {
        this.sc = sc; 
    }
    public void printMatrix(){
        System.out.println("Which letter of matrix do you want? ");
        String letter = sc.next();
        sc.nextLine();
        System.out.println("How Many Number of Rows");
        int rows = sc.nextInt();
        System.out.println("How many columns? ");
        int columns = sc.nextInt();
        for(int row=0;row<rows;row++){
            for(int column=0;column<columns;column++ ){
                System.out.print(letter+" | ");
            }
            System.out.println();
            for(int column=0;column<columns;column++ ){
                System.out.print("__  ");
            }
            System.out.println();
            
        }
    } 
}
