package assignments.support.operations;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class WithZone {
    private final ZoneId zone;
    public WithZone(ZoneId zondId) {
        this.zone = zondId;
    }

    public String getWithZone(){ // Taking Zone Name as Input From User
        
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);   // get Current time 
        ZonedDateTime isNow = utcNow.withZoneSameInstant(zone); // get ZoneDateTime on this time in provided  zone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm:ss' Z '");  // get formater object based on provided patter
        return "General Time Zone : "+utcNow.format(formatter)+"\n With Selected Zone: "+isNow.format(formatter);
    }
}
