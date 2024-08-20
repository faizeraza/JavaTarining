package assingments;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import assingments.support.BasicDateOperations;

public class IstTimezone {
    public void getWithISTzone(){
        
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime isNow = utcNow.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));

        // instead of passing the String manualluy,
        // created an array passing the patter string and formatter object generation.

        for (String pattern : BasicDateOperations.formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            System.out.println("General Time Zone : "+utcNow.format(formatter));
            System.out.println("With IST formate: "+isNow.format(formatter));
        }
    }
}
