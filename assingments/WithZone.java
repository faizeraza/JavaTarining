package assingments;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WithZone {

    private Scanner sc;
    
    public WithZone(Scanner sc) {
        this.sc = sc;
    }

    public void getWithZone(){

        // Extended The Same methode for Question 16
        // Taking Zone Name as Input From User
        
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println("Enter The Zone for print");
        String zone = sc.nextLine();
        ZonedDateTime isNow = utcNow.withZoneSameInstant(ZoneId.of(zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm:ss' Z '");
        System.out.println("General Time Zone : "+utcNow.format(formatter));
        System.out.println("With Selected Zone: "+isNow.format(formatter));

    }
}
