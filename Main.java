import java.util.Scanner;

import assingments.*;
import assingments.support.BasicDateOperations;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Question Number:");
        String choice = sc.next();
		sc.nextLine();

        // Instance Creation of support classes is Done before switch case,
        // As they are general for several High level classes.
        BasicDateOperations dateOps = new BasicDateOperations();
        StatLoop statistics = new StatLoop(sc);


        switch (choice) {
            case "1":
                Hello Q1 = new Hello();
                System.out.println(Q1.getMessage());
                break;
            case "2":
                GetWithScanner gc = new GetWithScanner(sc);
                System.out.println(gc.getWithScanner());
                break;
            case "5":
                AddInt addInt =new AddInt(sc);
                addInt.add();
                break;
            case "6":
                AddFloat addFloat = new AddFloat(sc);
                addFloat.add();
                break;
            case "7":
                Calculator cal = new  Calculator(sc);
                cal.calculate();
                break;
            case "8" :
                System.out.println(" Result: "+ statistics.statLoop());
                break;
            case "9" :
                System.out.println(" Result: "+ statistics.statLoop());
                break;
            case "10":
                SortList sorter =new SortList(sc);
                System.out.println("sorted list: "+sorter.sort());  
                break;  
            case "11":
                CountEvenOdd counter = new CountEvenOdd(sc);
                counter.countEvenOdd();     
                break;
            case "12":
                Table table = new Table(sc);
                table.printTable();
                break;
            case "13":
                Matrix mat = new Matrix(sc);
                mat.printMatrix();
                break;
            case "14":
                DateManipulation dm = new DateManipulation(sc);
                dm.dateManipulator();
                break;
            case "15":
                IstTimezone istZone = new IstTimezone();
                istZone.getWithISTzone();
            case "16":
                WithZone zone = new WithZone(sc);
                zone.getWithZone();
                break;
            case "17":
                DueInBetween due = new DueInBetween(dateOps, sc);
                due.dueInBetween();
                break;
            case "18":
                LeapYearDetector leapYearDetector = new LeapYearDetector(sc, dateOps);
                if(leapYearDetector.isInLeapYear())
                    System.out.println("the Given date hase Leap Year");
                else
                    System.out.println("no Leap Year Found!! ");
                break;
            case "19":
                DateComparator comparator =  new DateComparator(sc, dateOps);
                System.out.println(comparator.dateComparision());
                break;
            case "20":
                WeekendCounter weekendCounter = new WeekendCounter(sc);
                weekendCounter.countWeekEnds();
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