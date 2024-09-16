package assignments.task;

import assignments.support.FileHandling;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment28 implements Task<String> {
    private String url; // URL of the webpage to be downloaded and compressed

    // Constructor to initialize the URL
    public Assignment28(String url) {
        this.url = url;
    }

    // Method to extract the domain name from the given URL using a regex pattern
    public String getDomain() {
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

    @Override
    public String execute() {
        // Extract the domain name from the URL
        String domain = getDomain();
        
        // Construct file paths for the HTML and zip files based on the domain name
        String htmlFilePath = "/home/admin/Desktop/java/training/basic-java/resources/" + domain + ".html"; // Set saved HTML file's name
        String zipFilePath = htmlFilePath + ".zip"; // Set the desired new zip file name

        try {
            // Create an instance of FileHandling to handle file download and compression
            FileHandling fileHandler = new FileHandling(htmlFilePath, zipFilePath, url);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
