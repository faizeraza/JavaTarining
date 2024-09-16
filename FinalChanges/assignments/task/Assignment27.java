package assignments.task;

import assignments.support.FileHandling;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment27 implements Task<String> {

    // Method to extract the domain name from the given URL using a regex pattern
    public String getDomain(String url) {
        // Regex pattern to match the domain name in the URL
        String regex = "(?:https?:\\/\\/)?(?:www\\.)?([^\\/?:#]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        // Return the domain if a match is found, otherwise return an empty string
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    // Override the execute method from the Task interface
    @Override
    public String execute() {
        FileHandling fileHandler;
        // Set the URL to be processed
        String url = "https://merce.co/";
        // Extract the domain name from the URL
        String domain = getDomain(url);

        // Construct file paths for the HTML and zip files based on the domain name
        String htmlFilePath = "/home/admin/Desktop/java/training/basic-java/resources/" + domain + ".html";
        String zipFilePath = htmlFilePath + ".zip"; // Set the desired new zip file name

        try {
            // Create an instance of FileHandling to handle file download and compression
            fileHandler = new FileHandling(htmlFilePath, zipFilePath, url);
            fileHandler.downloadFile(); // Download the HTML file from the URL
            fileHandler.compressFile(); // Compress the downloaded HTML file

            // Create File objects to get the file sizes
            File htmlFile = new File(htmlFilePath);
            File zipFile = new File(zipFilePath);

            // Return a message with the sizes of the HTML and compressed files
            return "HTML file size: " + htmlFile.length() + " bytes \n" +
                   "Compressed file size: " + zipFile.length() + " bytes";

        } catch (IOException e) {
            // Return the error message if an IOException occurs
            return e.getMessage();
        }
    }
}
