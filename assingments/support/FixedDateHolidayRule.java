package assingments.support;
import java.time.LocalDate;
import java.util.List;

public class FixedDateHolidayRule implements HolidayRule{
    private final List<LocalDate> holidays;

    public FixedDateHolidayRule(List<LocalDate> holidays) {
        this.holidays = holidays;
    }

    @Override
    public boolean isHoliday(LocalDate date){
        return holidays.contains(date);
    }
}
