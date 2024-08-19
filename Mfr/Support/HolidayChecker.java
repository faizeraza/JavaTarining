package Mfr.Support;

import java.time.LocalDate;
import java.util.List;

public class HolidayChecker {
    private final List<HolidayRule> holidayrules;

    public HolidayChecker(List<HolidayRule> holidayrules) {
        this.holidayrules = holidayrules;
    }

    public boolean isHoliday(LocalDate date){
        for (HolidayRule rule : holidayrules){
            if(rule.isHoliday(date)){
                return true;
            }
        }
        return false;
    }
}
