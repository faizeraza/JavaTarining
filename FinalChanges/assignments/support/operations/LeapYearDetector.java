package assignments.support.operations;

import java.time.LocalDateTime;

public class LeapYearDetector {

    private LocalDateTime dateTime;

    public LeapYearDetector(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isInLeapYear(){

        int year = dateTime.getYear();
        if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)){
            return true;
        }
        return false;
    }
}
