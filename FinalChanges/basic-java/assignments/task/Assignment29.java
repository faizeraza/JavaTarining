package assignments.task;

import assignments.support.FileHandling;
import assignments.support.operations.WordCount;
import java.io.IOException;
import java.util.List;


public class Assignment29 implements Task<String>{
    private String filePath;    // File path for the file to be processed

    // Constructor to initialize the file path
    public Assignment29(String filePath){
        this.filePath = filePath;       
    } 
    
    @Override
    public String execute() {
        try {
             // Create an instance of FileHandling to handle file operations
            FileHandling fileHandler =new  FileHandling(filePath);
            // get List of Wordcount Type by calling countWords() methode for above instance
            List<WordCount> counter = fileHandler.countWords();
            String message = "";
            
            // Construct a message with word counts
            for (WordCount count: counter){
                // Append each word and its count to the message
                message = message + count.toString()+"\n";
            }

            // Return the message containing the word counts
            return message;

        } catch (IOException e) {
            // Return the error message if an IOException occurs
            return e.getMessage();
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
