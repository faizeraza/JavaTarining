package assingments.support;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class BasicDateOperations implements DateOperations {
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
    
    @Override
    public String detectDateTimeFormat(String dateTimeString) {
        for (String format : formatPatterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                if (format.contains("HH") || format.contains("mm") || format.contains("ss")) {
                    LocalDateTime.parse(dateTimeString, formatter);
                } else {
                    LocalDate.parse(dateTimeString, formatter);
                }
                return format; 
                // Return the format if parsing is successful
            } catch (DateTimeParseException e) {
                // If formate is not applicable exception wiil be thrown and command gets to here in catch statement 
                // Ignore the exception and try the next format
            }
        }
        return null; 
        // Return null if no format matches
    }

    // Simple function which checks if the Give Date have time or not
    // And if not then Attach 00:00:00 default time
    // Applicable when working exact dates such as finding difference among dates

    @Override
    public String addDefaultTimeIfNeeded(String dateTimeString, String detectedFormat) {
        if (!detectedFormat.contains("HH") && !detectedFormat.contains("mm") && !detectedFormat.contains("ss")) {
            return dateTimeString + " 00:00:00";
        }
        return dateTimeString;
    }
}
