package assingments.support;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendHolidayRule implements HolidayRule{
    @Override
    public boolean isHoliday(LocalDate date){
        DayOfWeek day = date.getDayOfWeek();
        return day == day.SATURDAY || day == day.SUNDAY;
    }
}
