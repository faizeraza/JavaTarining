package Mfr;

public class aisehi {
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
}
