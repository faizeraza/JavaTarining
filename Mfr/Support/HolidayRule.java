package Mfr.Support;

import java.time.LocalDate;

public interface HolidayRule {
    public boolean isHoliday(LocalDate date);
}
