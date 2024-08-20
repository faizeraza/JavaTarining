package assingments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import assingments.support.DateOperations;

public class LeapYearDetector {
    Scanner sc;
    DateOperations ops;
    
    public LeapYearDetector(Scanner sc, DateOperations ops) {
        this.sc = sc;
        this.ops = ops;
    }

    public boolean isInLeapYear(){

        System.out.println("Enter Date : ");
        String date = sc.nextLine();
        

        String dateFormat = ops.detectDateTimeFormat(date);

        if (dateFormat == null ) {
            System.out.println("Could not detect the date-time format");
            return false;
        }

        date = ops.addDefaultTimeIfNeeded(date, dateFormat);

        // Re-detect format after adding default time if needed
        if ( !dateFormat.contains("HH") &&  !dateFormat.contains("mm") &&  !dateFormat.contains("ss")) {
            dateFormat = dateFormat + " HH:mm:ss";
        }
        // Parsing the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        int year = dateTime.getYear();
        if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)){
            return true;
        }
        return false;
    }
}
