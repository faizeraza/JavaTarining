package assignments.task;

import assignments.support.Calendar;
import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.BasicDateOperations;
import java.time.LocalDateTime;
// 19. Write a program to accept two dates (any of the supported period) and print an output
// whether date1 and date2 are equal, date1 is earlier than date2 or date1 is later than date2.


public class Assignment19 implements Task<String>{    
    public Assignment19() {
    }
    @Override
    public String execute() {   
        // Geting Start Date and detecting its formate
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

        // converting to standard formate
        LocalDateTime firstDateTime = dateOperations.convertToStandardFormat(firstDate, firstDateFormat);
        LocalDateTime secondDateTime = dateOperations.convertToStandardFormat(secondDate, secondDateFormat);
   
        // init the Calendar constructor with firstDateTime and secondDateTime
        Calendar detector = new Calendar(firstDateTime,secondDateTime);
        return detector.dateComparision();      // calling dateComparision for abover instance
    }
}