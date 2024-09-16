package assignments.task;

import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;
import java.time.LocalDateTime;
// 18. Write a program to accept a date and print whether the date falls into a leap year. Accept a
// date in any format supported in one of the previous problems.

public class Assignment18 implements Task<String>{    
    public Assignment18() {
    }

    @Override
    public String execute() {
        String[] dateData;                                                 // Temporary Array created for storing ConsoleInputHandler.getDate() methode output
        InputHandler inputHandler = new InputHandler();
        BasicDateOperations dateOperations = new BasicDateOperations();
        // Geting Start Date and detecting its formate
        dateData = inputHandler.getDate("Enter Starting date : ",dateOperations);    // Calling getDate methode from support class which returns date and its formate 
        String date = dateData[0];
        String dateFormat = dateData[1];
        

        // for this problem time duration is mendatory so adding default 00:00:00 into dates if not provided
        LocalDateTime dateTime = dateOperations.convertToStandardFormat(date, dateFormat);


        // Parsing the dates
        Calendar detector = new Calendar(dateTime);
        if(detector.isInLeapYear())
            return "the Given date has Leap Year";
        else
            return "No Leap Year Found!! ";
    }
}
