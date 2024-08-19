import java.util.Scanner;
import Mfr.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Question Number:");
        String choice = sc.next();
		sc.nextLine();

        // Instance Creation of some classes is Done before switch case,
        // As some classes contains two or more methods so we can call same instance. 
        
        Addition addition = new Addition();
        Calculator cal = new  Calculator(sc);
        DateManipulation dm = new DateManipulation(sc);

        switch (choice) {
            case "1":
                Hello Q1 = new Hello();
                System.out.println(Q1.getMessage());
                break;
            case "2":
                GetWithScanner gc = new GetWithScanner(sc);
                System.out.println((gc.getWithScanner()));
                break;
            case "5":
                AddInt addInt =new AddInt(sc);
                addition.add(addInt);
                break;
            case "6":
                AddFloat addFloat = new AddFloat(sc);
                addition.add(addFloat);
                break;
            case "7":
                cal.calculate();
                break;
            case "8":
                System.out.println(" Result: "+ cal.statLoop());
                break;
            case "9":
                System.out.println("sorted list: "+cal.sort());  
                break;  
            case "10":
                cal.countEvenOdd();     
                break;
            case "11":
                Table table = new Table(sc);
                table.printTable();
                break;
            case "12":
                Matrix mat = new Matrix(sc);
                mat.printMatrix();
                break;
            case "13":
                dm.dateManipulator();
                break;
            case "14":
                dm.getWithZone();
                break;
            case "15":
                dm.dueInBetween();
                break;
            case "16":
                if(dm.isInLeapYear())
                    System.out.println("the Given date hase Leap Year");
                else
                    System.out.println("no Leap Year Found!! ");
                break;
            case "17":
                System.out.println(dm.dateComparision());
                break;
            case "18":
                dm.countWeekEnds();
                break;
            default:
                    SetWithArg swa = new SetWithArg();
                    if (args.length == 1){
                        swa.setWithArg(args[0]);
                    }
                    else if (args.length == 2){
                        swa.setAndReplace(args[0], args[1]);
                    }
                    else{
                        System.out.println("Enter A valid Input");
                    }
                break;
        }	
		sc.close();
    }
}