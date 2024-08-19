package Mfr;
import java.util.Scanner;

public class GetWithScanner {
    public String name;
    public GetWithScanner(Scanner sc) {
        System.out.println("Enter Name ");
        name = sc.next();
        sc.nextLine();
    }
    public String getWithScanner(){
		    return "Hello "+name;
	}   
}