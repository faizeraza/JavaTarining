package assignments.task;

import assignments.support.Calendar;
import java.time.*;
// 14. Write a program to print current date/time in following formats (one line per format) in UTC
// time e.g. “16 Mar 2022” “Mar 16, 2022” “2022-03-16” “2022-03-16T15:52:00Z” “Tuesday, 16
// March 2022”
public class Assignment14 implements Task<String>{
    public Assignment14() {
    }
    @Override
    public String execute() {
        LocalDateTime utcNow = LocalDateTime.now(ZoneOffset.UTC);
        Calendar calender =new  Calendar(utcNow); // No input required here simple class
        String message = "";
        for (String line : calender.getCurrentDateTime()){  //print date in each mentioned formate
            message = message + line + "\n";
        }
        return message; // return varification message after printing all required dates
    }
}
