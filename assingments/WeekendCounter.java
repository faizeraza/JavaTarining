package assingments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WeekendCounter {
    Scanner sc;
    
    public WeekendCounter(Scanner sc) {
        this.sc = sc;
    }

    public void countWeekEnds(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Enter Starting date : ");
        String startDate = sc.next();
        sc.nextLine();
        LocalDate startDateParsed = LocalDate.parse(startDate, formatter);

        System.out.println("Enter Ending date : ");
        String endDate = sc.next();
        LocalDate endDateParsed = LocalDate.parse(endDate, formatter);
        sc.nextLine();

        DayOfWeek saturday = DayOfWeek.SATURDAY;
        DayOfWeek sunday = DayOfWeek.SUNDAY;

        int count = 0;
        LocalDate day = startDateParsed;

        while (!day.isAfter(endDateParsed)) {
            if (day.getDayOfWeek() == saturday || day.getDayOfWeek() == sunday){
                count++;
            }
            day = day.plusDays(1);
            // System.out.println(day);
        }

        System.out.printf("Number Of Week End Between %s and %s are %d %n",startDate,endDate,count);

    }
}
