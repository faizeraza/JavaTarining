package assingments;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import assingments.support.BasicDateOperations;

public class DateManipulation {
    Scanner sc;
    public DateManipulation(Scanner input) {
        this.sc = input;
    }

    public void dateManipulator(){
        
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        // instead of passing the String manualluy,
        // created an array passing the patter string and formatter object generation.

        for (String pattern : BasicDateOperations.formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            System.out.println("General Time Zone : "+utcNow.format(formatter));
        }
    }
    
}