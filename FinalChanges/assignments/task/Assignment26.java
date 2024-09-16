package assignments.task;

import java.io.File;
import java.io.IOException;

import assignments.support.FileHandling;

public class Assignment26 implements Task<String> {

    @Override
    public String execute() {
        // Set file paths for the HTML file and the zip file
        String htmlFilePath = "/home/admin/Desktop/java/training/basic-java/resources/Merce – Merce Technologies Pvt Ltd.html"; 
        String zipFilePath = htmlFilePath + ".zip"; // Set the desired new zip file name

        try {
            // Create an instance of FileHandling to handle file compression
            FileHandling fileHandler = new FileHandling(htmlFilePath, zipFilePath);
            fileHandler.compressFile(); // Compress the HTML file into a zip file

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
