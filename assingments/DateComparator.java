package assingments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import assingments.support.DateOperations;

public class DateComparator {
    Scanner sc;
    DateOperations ops;
    
    public DateComparator(Scanner sc, DateOperations ops) {
        this.sc = sc;
        this.ops = ops;
    }

    public String dateComparision(){
        System.out.println("Enter Starting date : ");
        String firstDate = sc.nextLine();
        
        System.out.println("Enter Ending date : ");
        String secondDate = sc.nextLine();

        // String firstDate= "2024-08-14 00:00:00";
        // String secondDate = "2024-08-14 00:30:00";

        String firstDateFormat = ops.detectDateTimeFormat(firstDate);
        String secondDateFormat = ops.detectDateTimeFormat(secondDate);

        if (firstDateFormat == null || secondDateFormat == null) {
            System.out.println("Could not detect the date-time format of one or both inputs.");
            return null;
        }

        firstDate = ops.addDefaultTimeIfNeeded(firstDate, firstDateFormat);
        secondDate = ops.addDefaultTimeIfNeeded(secondDate, secondDateFormat);

        // Re-detect format after adding default time if needed
        if (!firstDateFormat.contains("HH") && !firstDateFormat.contains("mm") && !firstDateFormat.contains("ss")) {
            firstDateFormat = firstDateFormat + " HH:mm:ss";
        }
        
        if (!secondDateFormat.contains("HH") && !secondDateFormat.contains("mm") && !secondDateFormat.contains("ss")) {
            secondDateFormat = secondDateFormat + " HH:mm:ss";
        }

        // Parsing the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(firstDateFormat);
        LocalDateTime firstDateTime = LocalDateTime.parse(firstDate, formatter);

        formatter = DateTimeFormatter.ofPattern(secondDateFormat);
        LocalDateTime secondDateTime = LocalDateTime.parse(secondDate, formatter);

        if (firstDateTime.isEqual(secondDateTime)){
            return "Both Dates Are Equals";
        }
        else if (firstDateTime.isBefore(secondDateTime)){
            return " "+firstDateTime+" is Earlier than "+secondDate;
        }
        else{
            return " "+ firstDateTime +" is later than "+ secondDate;
        }
    }
}
