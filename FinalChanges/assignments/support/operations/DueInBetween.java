package assignments.support.operations;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DueInBetween {
    private LocalDateTime startDateTime, endDateTime;
    public DueInBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
    
    public HashMap<String, Integer> dueInBetween(){

        HashMap<String, Integer> difference = new LinkedHashMap<String, Integer>();         // HashMap for storing claculated diff HHs, MMs, DDs, YYs and Months 
        

        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        Duration due = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());

        // Add to HashMap
        difference.put("years", period.getYears());
        difference.put("months",period.getMonths());
        difference.put("days",period.getDays());
        difference.put("hours",due.toHoursPart());
        difference.put("minutes",due.toMinutesPart());
   

        // Print the difference in a human-readable format
        // System.out.printf("%d years %d months %d days %d hours %d minutes%n", period.getYears(), period.getMonths(), period.getDays(), duration.toHoursPart(), duration.toMinutesPart());

        return difference;
    }

}
