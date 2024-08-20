package assingments;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import assingments.support.DateOperations;

public class DueInBetween {
    private final DateOperations dateOperations;
    Scanner sc;
    public DueInBetween(DateOperations dateOperations, Scanner input) {
        this.dateOperations = dateOperations;
        this.sc = input;
    }

    public void dueInBetween(){

        System.out.println("Enter Starting date : ");
        String startDate = sc.nextLine();
        
        System.out.println("Enter Ending date : ");
        String endDate = sc.nextLine();

        // String startDate= "2024-08-14 00:00:00";
        // String endDate = "2024-08-14 00:30:00";

        String startDateFormat = dateOperations.detectDateTimeFormat(startDate);
        String endDateFormat = dateOperations.detectDateTimeFormat(endDate);

        if (startDateFormat == null || endDateFormat == null) {
            System.out.println("Could not detect the date-time format of one or both inputs.");
            return;
        }

        startDate = dateOperations.addDefaultTimeIfNeeded(startDate, startDateFormat);
        endDate = dateOperations.addDefaultTimeIfNeeded(endDate, endDateFormat);


        // Parsing the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(startDateFormat);
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);

        formatter = DateTimeFormatter.ofPattern(endDateFormat);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());

        // Print the difference in a human-readable format
        System.out.printf("%d years %d months %d days %d hours %d minutes%n", period.getYears(), period.getMonths(), period.getDays(), duration.toHoursPart(), duration.toMinutesPart());
    }

}
