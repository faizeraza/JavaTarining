package assignments.support.operations;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class WeekendCounter {
    LocalDateTime startDateParsed , endDateParsed;
    protected int count = 0;
    public WeekendCounter(LocalDateTime startDate, LocalDateTime endDate) { 
        this.startDateParsed = startDate;
        this.endDateParsed = endDate;
    }

    public int countWeekEnds(){
        DayOfWeek saturday = DayOfWeek.SATURDAY;  
        DayOfWeek sunday = DayOfWeek.SUNDAY;

        LocalDateTime day = startDateParsed;    // day tracker 

        while (!day.isAfter(endDateParsed)) { // while day is earlier than end date
            if (day.getDayOfWeek() == saturday || day.getDayOfWeek() == sunday ){    //if it is saturday or sunday increament count
                count++;    //counter
            }
            day = day.plusDays(1);  // day is increamented by one
        }

        return count;

    }
}
