package assignments.task;

import assignments.support.FileHandling;
import assignments.support.operations.WordCount;
import java.io.IOException;
import java.util.*;


public class Assignment30 implements Task<String>{
    private String filePath;        // File path for the file to be processed

    public Assignment30(String filePath){   // Constructor to initialize the file path
        this.filePath = filePath;
    } 

    // Override the execute method from the Task interface
    @Override
    public String execute() {
         // Create a list of common words to ignore during word counting
         List<String> commonWords = new ArrayList<>(Arrays.asList(
            "i","a", "an", "the", "and", "but", "or", "nor", "for", "so", "yet", 
            "in", "on", "at", "by", "with", "about", "against", "between", 
            "into", "through", "during", "before", "after", "above", "below", 
            "to", "from", "up", "down", "over", "under", "again", "further", 
            "then", "once", "here", "there", "when", "where", "why", "how", 
            "all", "any", "both", "each", "few", "more", "most", "other", 
            "some", "such", "no", "not", "only", "own", "same", "so", "than", 
            "too", "very", "s", "t", "can", "will", "just", "don", "should", 
            "now"
        ));
        try {
             // Create an instance of FileHandling to handle file operations
            FileHandling fileHandler =new  FileHandling(filePath,commonWords);

            // Count words in the file, ignoring common words
            List<WordCount> counter = fileHandler.countWordsIgnoreCommon();
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
