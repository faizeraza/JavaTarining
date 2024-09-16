package assignments.support.operations;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateManipulation {

    public ArrayList<String> getDateInFormates(LocalDateTime localDateTime){
        
        // instead of passing the String manualluy,
        // created an array passing the pattern string and formatter object generation.
        ArrayList<String> dateList = new ArrayList<>();
        for (String pattern : BasicDateOperations.formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            dateList.add(localDateTime.format(formatter));
        }
        return dateList;
    }

}