package assignments.support;

import assignments.support.operations.WordCount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileHandling {
    private String inputFilePath ;      // to set file path of input file
    private String outputFilePath ;       // to set file path of output file
    private String url;                 // to set url for ferther operations
    private List<String> commonWords;
    List<WordCount> wordCounts = new ArrayList<>();     // is used for operation dont need to get from class user
    public FileHandling(String inputFilePath, String outputFilePath) {        // constructor for operations where we need input file as well as output file
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;                                  // for ex : file compression operation
    }

    public FileHandling(String inputFilePath, String outputFilePath, String url) {      // constructor when we need url as additional
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;                                           // ex: compressing the html code of url provided
        this.url = url;
    }

    public FileHandling(String inputFilePath, List<String> commonWords) {                     // constructor used while performing single file operstions
        this.inputFilePath = inputFilePath;                         // ex : finding word counts
        this.commonWords = commonWords;
    }

    public FileHandling(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }
    
    // Methode to compress file
    public void compressFile() throws IOException {
        // Create streams for input and output
        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // Create a new ZIP entry for the HTML file
            ZipEntry zipEntry = new ZipEntry(new File(inputFilePath).getName());
            zos.putNextEntry(zipEntry);

            // Buffer for reading and writing
            byte[] buffer = new byte[1024];
            int length;

            // Read the HTML file and write it to the ZIP entry
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            // Close the ZIP entry
            zos.closeEntry();
        }
    }

    // methode to download file
    public boolean downloadFile() throws IOException{
        // Create a URL object from the provided URL string
        URL urlObj = new URL(url);

        // Open a connection to the specified URL
        URLConnection connection = urlObj.openConnection();

        // Open input stream to read from the URL
        try (InputStream inputStream = connection.getInputStream();      // Create an InputStream from the URL connection
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));         // Wrap the InputStream in a BufferedReader to read text lines
             FileWriter fileWriter = new FileWriter(inputFilePath)) {                     // Create a FileWriter to write the read data into a file at inputFilePath

            String line;             // Read each line from the BufferedReader
            while ((line = reader.readLine()) != null) {
                fileWriter.write(line + "\n");           // Write each line into the file
            }       
            return true;            // Return true to indicate the file was successfully downloaded and written
        }
    }

     // Method to add a new word or update the count of an existing word
    private void addOrUpdateWord( String word) {        

        // Iterate over each WordCount object in the wordCounts list
        for (WordCount wc : wordCounts) {

            // Check if the current WordCount object has the same word as the input
            if (wc.getWord().equals(word)) {

                // If the word is found, increment its count
                wc.increment();
                return; // Exit the method since the word has been updated
            }
        }
        // If word is not found, add a new WordCount object to the list
        wordCounts.add(new WordCount(word));
    }

    public List<WordCount> countWords() throws IOException {

        // Open the file at inputFilePath and create a BufferedReader to read it
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;        // Read the file line by line
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split each line into words using a regex for word boundaries
                String[] words = line.toLowerCase().split("\\W+");      
                for (String word : words) {             // Iterate over each word in the array
                    if (!word.isEmpty()) {              // Check if the word is not empty
                        addOrUpdateWord( word);         // Add the word to the word count list or update its count
                    }
                }
            }
        }
        return wordCounts;
    }

    public List<WordCount> countWordsIgnoreCommon() throws IOException {

            // Open the file at inputFilePath and create a BufferedReader to read it
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
                String line;
                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Split each line into words using a regex for word boundaries
                    String[] words = line.toLowerCase().split("\\W+");      // Convert the line to lowercase and split it into words using a regex for word boundaries
                    for (String word : words) {                      // Iterate over each word in the array
                        if (!word.isEmpty() && !commonWords.contains(word)) { // Check if the word is not empty
                            addOrUpdateWord(word);          // Add the word to the word count list or update its count
                        }
                    }
                }
            }
        return wordCounts;      // Return the list of WordCount objects after processing the file
    }
}
