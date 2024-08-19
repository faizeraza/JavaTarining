package Mfr;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateManipulation {
    Scanner sc;
    String[] formatPatterns = {
        "dd MMM yyyy",      
        "MMM dd, yyyy",     
        "yyyy-MM-dd",       
        "yyyy-MM-dd'T'HH:mm:ss'Z'",
        "EEEE, dd MMMM yyyy" ,
        "yyyy-MM-dd HH:mm:ss"
    };
    public DateManipulation(Scanner input) {
        this.sc = input;
    }
    public void dateManipulator(){
        
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime isNow = utcNow.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));

        // instead of passing the String manualluy,
        // created an array passing the patter string and formatter object generation.

        for (String pattern : formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            System.out.println("General Time Zone : "+utcNow.format(formatter));
            System.out.println("With IST formate: "+isNow.format(formatter));
        }
    }

    public void getWithZone(){
        // Extended The Same methode for Question 16
        // Taking Zone Name as Input From User
        
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);
        System.out.println("Enter The Zone for print");
        String zone = sc.nextLine();
        ZonedDateTime isNow = utcNow.withZoneSameInstant(ZoneId.of(zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm:ss' Z '");
        System.out.println("General Time Zone : "+utcNow.format(formatter));
        System.out.println("With Selected Zone: "+isNow.format(formatter));

    }

    private String detectDateTimeFormat(String dateTimeString) {
        for (String format : formatPatterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                if (format.contains("HH") || format.contains("mm") || format.contains("ss")) {
                    LocalDateTime.parse(dateTimeString, formatter);
                } else {
                    LocalDate.parse(dateTimeString, formatter);
                }
                return format; // Return the format if parsing is successful
            } catch (DateTimeParseException e) {
                // Ignore the exception and try the next format
            }
        }
        return null; // Return null if no format matches
    }

    
    private String addDefaultTimeIfNeeded(String dateTimeString, String detectedFormat) {
        if (!detectedFormat.contains("HH") && !detectedFormat.contains("mm") && !detectedFormat.contains("ss")) {
            return dateTimeString + " 00:00:00";
        }
        return dateTimeString;
    }

    // https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalUnit.html#between-java.time.temporal.Temporal-java.time.temporal.Temporal-

    public void dueInBetween(){

        System.out.println("Enter Starting date : ");
        String startDate = sc.nextLine();
        
        System.out.println("Enter Ending date : ");
        String endDate = sc.nextLine();

        // String startDate= "2024-08-14 00:00:00";
        // String endDate = "2024-08-14 00:30:00";

        String startDateFormat = detectDateTimeFormat(startDate);
        String endDateFormat = detectDateTimeFormat(endDate);

        if (startDateFormat == null || endDateFormat == null) {
            System.out.println("Could not detect the date-time format of one or both inputs.");
            return;
        }

        startDate = addDefaultTimeIfNeeded(startDate, startDateFormat);
        endDate = addDefaultTimeIfNeeded(endDate, endDateFormat);

        // Re-detect format after adding default time if needed
        if (!startDateFormat.contains("HH") && !startDateFormat.contains("mm") && !startDateFormat.contains("ss")) {
            startDateFormat = startDateFormat + " HH:mm:ss";
        }
        if (!endDateFormat.contains("HH") && !endDateFormat.contains("mm") && !endDateFormat.contains("ss")) {
            endDateFormat = endDateFormat + " HH:mm:ss";
        }

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

    public boolean isInLeapYear(){

        System.out.println("Enter Date : ");
        String date = sc.nextLine();
        

        String dateFormat = detectDateTimeFormat(date);

        if (dateFormat == null ) {
            System.out.println("Could not detect the date-time format");
            return false;
        }

        date = addDefaultTimeIfNeeded(date, dateFormat);

        // Re-detect format after adding default time if needed
        if ( !dateFormat.contains("HH") &&  !dateFormat.contains("mm") &&  !dateFormat.contains("ss")) {
            dateFormat = dateFormat + " HH:mm:ss";
        }
        // Parsing the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        int year = dateTime.getYear();
        if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)){
            return true;
        }
        return false;
    }

    public String dateComparision(){
        String message = "";
        System.out.println("Enter Starting date : ");
        String firstDate = sc.nextLine();
        
        System.out.println("Enter Ending date : ");
        String secondDate = sc.nextLine();

        // String firstDate= "2024-08-14 00:00:00";
        // String secondDate = "2024-08-14 00:30:00";

        String firstDateFormat = detectDateTimeFormat(firstDate);
        String secondDateFormat = detectDateTimeFormat(secondDate);

        if (firstDateFormat == null || secondDateFormat == null) {
            System.out.println("Could not detect the date-time format of one or both inputs.");
            return null;
        }

        firstDate = addDefaultTimeIfNeeded(firstDate, firstDateFormat);
        secondDate = addDefaultTimeIfNeeded(secondDate, secondDateFormat);

        // Re-detect format after adding default time if needed
        if (!firstDateFormat.contains("HH") && !firstDateFormat.contains("mm") && !firstDateFormat.contains("ss")) {
            firstDateFormat = firstDateFormat + " HH:mm:ss";
        }
        
        if (!secondDateFormat.contains("HH") && !secondDateFormat.contains("mm") && !secondDateFormat.contains("ss")) {
            secondDateFormat = secondDateFormat + " HH:mm:ss";
        }

        // Parsing the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(firstDateFormat);
        LocalDateTime firstDateTime = LocalDateTime.parse(firstDate, formatter);

        formatter = DateTimeFormatter.ofPattern(secondDateFormat);
        LocalDateTime secondDateTime = LocalDateTime.parse(secondDate, formatter);

        if (firstDateTime.isEqual(secondDateTime)){
            return "Both Dates Are Equals";
        }
        else if (firstDateTime.isBefore(secondDateTime)){
            return " "+firstDateTime+" is Earlier than "+secondDate;
        }
        else{
            return " "+ firstDateTime +" is later than "+ secondDate;
        }
    }
}