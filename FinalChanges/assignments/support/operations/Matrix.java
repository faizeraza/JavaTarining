package assignments.support.operations;

import assignments.support.ioHandling.InputHandler;

/**
 * Matrix class is responsible for creating and printing a matrix of a specified letter
 * with a defined number of rows and columns.
 */
public class Matrix {
    String letter;
    int rows,columns;
     /**
     * Constructor that initializes the Matrix object by taking user input for 
     * the letter, number of rows, and number of columns.
     * 
     * @param inputHandler an instance of ConsoleInputHandler to manage user input.
     */
    public Matrix(InputHandler inputHandler) {
        this.letter = inputHandler.getStringInput("Which letter of matrix do you want? ").trim();
        this.rows = inputHandler.getIntInput("How Many Number of Rows");
        this.columns = inputHandler.getIntInput("How many columns? ");
    }
    /**
     * Prints the matrix using the specified letter, rows, and columns.
     * Each cell of the matrix is filled with the chosen letter.
     */
    public String printMatrix(){
         // Loop through each row
         String message = "";
        for(int row=0;row<rows;row++){
             // Print the matrix row
            for(int column=0;column<columns;column++ ){
                message = message + letter+" | ";
            }
            message = message +"\n";
             // Print a separator line for the matrix row
            for(int column=0;column<columns;column++ ){
                message = message+"__  ";
            }
            message = message + "\n";
            
        }
        return message;
    } 
}