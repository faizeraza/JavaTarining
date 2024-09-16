package assignments.task;

// 17. Write a program to accept two dates (any of the formats supported in the earlier problem)
// and print a difference in human readable format e.g. “1 year 2 day 32 minutes”.

import java.util.HashMap;
import java.time.LocalDateTime;
import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;

public class Assignment17 implements Task<String>{
    public Assignment17() {
    }
    private LocalDateTime[] swapDates(LocalDateTime startDateParsed,LocalDateTime endDateParsed){ // private methode used when dates are entered in reverse order by user
        LocalDateTime[] result = {endDateParsed, startDateParsed};
        return result; // return array of LocalDateTime with swaped entries
    }
    @Override
    public String execute() {
        InputHandler inputHandler = new InputHandler();
        BasicDateOperations dateOperations = new BasicDateOperations();

        String[] dateData;
        dateData = inputHandler.getDate("Enter Starting date : ",dateOperations);    // Calling getDate methode from support class which returns date and its formate 
        String firstDate = dateData[0];
        String firstDateFormat= dateData[1];
        
        // Getting End Date and detecting its formate
        dateData = inputHandler.getDate("Enter Ending date : ",dateOperations);
        String secondDate = dateData[0];
        String secondDateFormat = dateData[1];
        
        // String firstDate= "2024-08-14 00:00:00";
        // String secondDate = "2024-08-14 00:30:00";

        LocalDateTime startDateParsed = dateOperations.convertToStandardFormat(firstDate, firstDateFormat);
        LocalDateTime endDateParsed = dateOperations.convertToStandardFormat(secondDate, secondDateFormat);                     // parsing it into LocalDate
        
            if (endDateParsed.isBefore(startDateParsed)){                                       // if dates are enterd in reverse by user swap them
                LocalDateTime[] swapedDates = this.swapDates(startDateParsed, endDateParsed);       // because user may inter in reverse manner 
                startDateParsed = swapedDates[0];                                               // as it is the concern about duration
                endDateParsed = swapedDates[1];                                                 // program should allow both order of aceepting dates
            }
            Calendar dueInBetween = new Calendar(startDateParsed,endDateParsed);
            HashMap<String,Integer> difference = dueInBetween.dueInBetween();
            String message = "";
            for (String string : difference.keySet()) {

                if (difference.get(string) < 0) { // If difference is -ve convert in positive
                    message = message +" "+-difference.get(string) +" " + string+"\n";
                    // System.out.printf("%d %s ", -difference.get(string), string);

                    continue;

                }
                message = message +" "+difference.get(string) +" " + string+"\n";
                // System.out.printf("%d %s ", difference.get(string), string);

            }
            return message;
    }
}
