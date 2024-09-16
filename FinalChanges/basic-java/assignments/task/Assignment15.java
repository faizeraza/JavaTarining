package assignments.task;

import java.time.LocalDateTime;
import java.time.ZoneId;
import assignments.support.Calendar;
// 15. Extend (13) to print time in IST timezone. 

public class Assignment15 implements Task<String>{
    public Assignment15() {
    }
    @Override
    public String execute() {
        LocalDateTime isNow = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        Calendar dateprinter =new  Calendar(isNow); // No input required here simple class
        String message = "";
        for (String line : dateprinter.getWithISTzone()){  //print date in each mentioned formate
            message = message + line + "\n";
        }
        return message; // return varification message after printing all required dates in IST
    }
}
