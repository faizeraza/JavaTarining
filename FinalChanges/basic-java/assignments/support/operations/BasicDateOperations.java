package assignments.support.operations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class BasicDateOperations {
    // the patterns are classified into two type either Date or  DateTime
    public static String[] formatPatterns = {
        "dd MMM yyyy",      
        "MMM dd, yyyy",     
        "yyyy-MM-dd",       
        "yyyy-MM-dd'T'HH:mm:ss'Z'",
        "EEEE, dd MMMM yyyy" ,
        "yyyy-MM-dd HH:mm:ss"
    };

    
    // User Can Enter Date into any of the mentioned formates 
    // So it requires a general fuction to detect the formate 
    // So that we can parse it out.

    public String detectDateTimeFormat(String dateTimeString) {
        // Iterate through each format pattern in the formatPatterns list
        for (String format : formatPatterns) {
            try {   
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);  // Create a DateTimeFormatter with the current format pattern
                if (format.contains("HH") || format.contains("mm") || format.contains("ss")) {  // Check if the format pattern contains time components
                    LocalDateTime.parse(dateTimeString, formatter);                             // Try parsing the dateTimeString as a LocalDateTime (which includes time)
                } else {        // If the format pattern doesn't include time, parse it as a LocalDate (date only)
                    LocalDate.parse(dateTimeString, formatter);
                }
                return format; 
                // Return the format if parsing is successful
            } catch (DateTimeParseException e) {
                // If formate is not applicable exception will be thrown and command gets to here in catch statement 
                // Ignore the exception and try the next format
            }
        }
        return null; 
        // Return null if no format matches
    }

    // Simple function which checks if the Give Date have time or not
    // And if not then convert date into "yyyy-MM-dd HH:mm:ss" formate
    // Applicable when working on exact dates such as finding difference among dates

    public LocalDateTime convertToStandardFormat(String dateTimeString, String detectedFormat) {
        // DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //  Defined the target format to which all dates should be converted
            if (dateTimeString.contains("T")) {                                             // If the string contains 'T', it's likely in ISO 8601 format with timezone
                    LocalDateTime zonedDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_DATE_TIME); 
                    return zonedDateTime;            // Convert to LocalDateTime and format to target format
                } else if (dateTimeString.length() > 10 && !dateTimeString.contains(" ")) {     // If the string is longer than 10 characters and doesn't contain a space, it's a date-time format without time zone
                    // Parse date-time format
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(detectedFormat));
                    // Format the LocalDateTime to the target format
                    return dateTime;
                } else {                                                                    // If it's a simple date without time, handle it separately
                     // Combine the date with the default time (00:00:00) and format it
                    LocalDate date = LocalDate.parse(dateTimeString, DateTimeFormatter.ofPattern(detectedFormat));
                    LocalDateTime dateTime = date.atStartOfDay(); // Default time 00:00:00
                    return dateTime;
                }
        // If the detected format contains time components or does not need conversion, return the input as is
        // return dateTimeString;

    }


}
