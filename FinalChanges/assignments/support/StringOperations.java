package assignments.support;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringOperations {
    Set<String> words; // A set of words to perform operations on
    String word;       // The word to search for within the set

    // Constructor initializes the set of words and the search word
    public StringOperations(HashSet<String> words, String word) {
        this.words = words;
        this.word = word;
    }

    // Method to check if the specified word is present in the set, ignoring case
    public boolean isPresent() {
        // Iterate through each word in the set
        for (String name : words) {
            // Check if the word matches the search word, ignoring case
            if (name.equalsIgnoreCase(this.word)) {
                return true; // Return true if a match is found
            }
        }
        return false; // Return false if no match is found
    }

    // Method to get names that match the search pattern
    public Set<String> getSearchedNames() throws NullPointerException {
        // Compile a regex pattern using the search word
        Pattern pattern = Pattern.compile(word);
        Set<String> filtered = new HashSet<>(); // Set to store matching names
        boolean found = false; // Flag to track if any match is found

        // Iterate through each word in the set
        for (String name : words) {
            // Match the pattern against each word
            Matcher matcher = pattern.matcher(name.toLowerCase());
            if (matcher.find()) { // If a match is found
                filtered.add(name); // Add the word to the filtered set
                found = true; // Set the flag to true
            }
        }

        // Throw an exception if no matching names are found
        if (!found) {
            throw new NullPointerException("No matching names found.");
        }

        return filtered; // Return the set of matching names
    }
}
