package Mfr;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateManipulation {
    public void dateManipulator(){
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        String[] formatPatterns = {
            "dd MMM yyyy",      
            "MMM dd, yyyy",     
            "yyyy-MM-dd",       
            "yyyy-MM-dd' T 'HH:mm:ss'Z'",
            "EEEE, dd MMMM yyyy" 
        };
        // instead of passing the String manualluy,
        // created an array passing the patter string and formatter object generation.
        for (String pattern : formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            System.out.println(utcNow.format(formatter));
        }
    }
}
