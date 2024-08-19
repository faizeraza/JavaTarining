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

        Add sum =new Add(sc);
        Calculator cal = new  Calculator(sc);
        DateManipulation dm = new DateManipulation(sc);

        switch (choice) {
            case "1":
                Hello Q1 = new Hello();
                Q1.getMessage();
                break;
            case "2":
                GetWithScanner gc = new GetWithScanner(sc);
                gc.getWithScanner();
                break;
            case "5":
                sum.add();
                break;
            case "6":
                sum.addFloat();
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
                dm.countWeekEnds();
                break;
            // case "17":

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