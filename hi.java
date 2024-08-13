import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class hi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the start date and time
        System.out.println("Enter the start date and time (yyyy-MM-dd HH:mm:ss):");
        // Read the start date and time entered by the user and parse it into a
        // LocalDateTime object:
        String startDateTimeStr = input.nextLine();

        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Prompt the user to enter the end date and time:
        System.out.println("Enter the end date and time (yyyy-MM-dd HH:mm:ss):");
        // Read the end date and time entered by the user and parse it into a
        // LocalDateTime object
        String endDateTimeStr = input.nextLine();
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Call the findDifference method with the start and end LocalDateTime objects
        findDifference(startDateTime, endDateTime);
        input.close();
    }

    // Define the findDifference method
    static void findDifference(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        // Calculate the period between dates
        Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());

        // Calculate the duration between times
        Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());

        // Print the difference between the two dates and times in terms of years,
        // months, days, hours, minutes, and seconds
        System.out.printf(
                "Difference between two dates is: %d years, %d months, %d days, %d hours, %d minutes, and %d seconds%n",
                period.getYears(), period.getMonths(), period.getDays(),
                duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}