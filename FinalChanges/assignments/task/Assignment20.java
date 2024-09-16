package assignments.task;
import java.time.LocalDateTime;
import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;

// 20. Write a program to accept two dates and print the count of week-end days (Consider
// Saturdays and Sundays as week-ends).

public class Assignment20 implements Task<String>{
    public Assignment20() {
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
        
        // parsing converting to standard formate
        LocalDateTime startDateParsed = dateOperations.convertToStandardFormat(firstDate, firstDateFormat);
        LocalDateTime endDateParsed = dateOperations.convertToStandardFormat(secondDate, secondDateFormat);                     // parsing it into LocalDate
        Calendar counter = new Calendar(startDateParsed,endDateParsed);
        return "Number Of Week End Between %s and %s are %d %n "+startDateParsed+" "+endDateParsed+" "+counter.countWeekEnds();
    }
}