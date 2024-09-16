import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.ArithmeticOperation;
import assignments.support.operations.FloatAddition;
import assignments.support.operations.IntAddition;
import assignments.task.Assignment1;
import assignments.task.Assignment10;
import assignments.task.Assignment11;
import assignments.task.Assignment12;
import assignments.task.Assignment13;
import assignments.task.Assignment14;
import assignments.task.Assignment15;
import assignments.task.Assignment16;
import assignments.task.Assignment17;
import assignments.task.Assignment18;
import assignments.task.Assignment19;
import assignments.task.Assignment2;
import assignments.task.Assignment20;
import assignments.task.Assignment21;
import assignments.task.Assignment22;
import assignments.task.Assignment23;
import assignments.task.Assignment24;
import assignments.task.Assignment25;
import assignments.task.Assignment26;
import assignments.task.Assignment27;
import assignments.task.Assignment28;
import assignments.task.Assignment29;
import assignments.task.Assignment3;
import assignments.task.Assignment30;
import assignments.task.Assignment4;
import assignments.task.Assignment5;
import assignments.task.Assignment6;
import assignments.task.Assignment7;
import assignments.task.Assignment8;
import assignments.task.Assignment9;
import assignments.task.Task;

// Main Methode this contains initialization of classes.
// The Classes have there own seperate module.
// Each module is dedicated to each question.

public class Main {
    @SuppressWarnings("rawtypes")

    // Instance Creation of support classes is Done before switch case,
    // Support classes are stored into sub-package named <support>
    // these are the classes which contains general methods 
    // Now we dont need to write the same redendant logics for each task
    // Jst call the class and Boom we are good to go.
    // As they are general for several High level classes.

    public static void main(String[] args) {
        Task task = null;
        ArithmeticOperation op;
        InputHandler inputHandler = new InputHandler();
        String choice = inputHandler.getStringInput("Enter Question Number");
        switch (choice) {
            case "1":
                task = new Assignment1(); // Initailizing the Assignment1 into Task type
                break;
            case "2":
                task = new Assignment2(inputHandler); //Initailizing the Assignment1 ConsoleInputHandler object as parameter with into Task type
                break;
            case "5":
                op = new IntAddition(); // Initailizing the IntAddition object as Task type
                task = new Assignment5(inputHandler, op);
                break;
            case "6":
                op = new FloatAddition(); //There is no difference between code of Assignment6 and Assignment7 
                task = new Assignment6(inputHandler, op); // excluding class name just created the module for the sake of formality                
                break;
            case "7":
                task =new  Assignment7(inputHandler); // class works as claculator which calls the support operation class based on choice
                break;
            case "8":
                task = new Assignment8(inputHandler); // class class the getSum methode from StatisticalOperations class to calculate sum of list of numbers
                break;
            case "9":
                task = new Assignment9(inputHandler); // conceret class used for statistical operations 
                break;
            case "10":
                task = new Assignment10(inputHandler); // its execute methode returns sorted arraylist 
                break;
            case "11":
                task = new Assignment11(inputHandler); // Assignment11 counting even and odd 
                break;
            case "12":
                task = new Assignment12(inputHandler); // Assingment12 is about table printing
                break;
            case "13":
                task = new Assignment13(inputHandler);  //Assignment13 is about matrix printing
                break;
            case "14":
                task = new Assignment14(); // Assignment14 is about printing current date time
                break;
            case "15":
                task = new Assignment15(); //Assignment15 is about printing IST time zone
                break;
            case "16":
                task = new Assignment16(); // Assignment16 is about print 
                break;
            case "17":
                task = new Assignment17(); // Assignment17 is about finding difference among two days
                break;
            case "18":
                task = new Assignment18(); // Assignment18 is about detecting leap year 
                break;
            case "19":
                task = new Assignment19();  // Assignment19 comparision of dates has been done
                break;
            case "20":
                task = new Assignment20(); // Assignment20 counts weekend saturday and sunday
                break;
            case "21":
                task = new Assignment21();
                break;
            case "22":
                task = new Assignment22();
                break;
            case "23":
                task = new Assignment23();
                break;
            case "24":
                task = new Assignment24();
                break;
            case "25":
                task = new Assignment25();
                break;
            case "26":
                task = new Assignment26();
                break;
            case "27":
                task = new Assignment27();
                break;
            case "28":
                task = new Assignment28(args[0]);
                break;
            case "3": // Third is kept defauld So if one argument is provided while running it will be executed 
            case "4": // as there is no break here also if 2 arguments are provided 4 will be executed
            default:
                if (args.length == 1){  //If Only One Argument passed 3rd Qn will execute
                    task = new Assignment3(args[0]);
                }
                else if (args.length == 2){ // 2 arguments for 4th
                    task = new Assignment4(args[0],args[1]);
                }
                else if ("28".equals(choice) && args.length == 1) {
                    task = new Assignment28(args[0]);
                }
                else if ("29".equals(choice) && args.length == 1) {
                    task = new Assignment29(args[0]);
                }
                else if ("30".equals(choice) && args.length == 1) {
                    task = new Assignment30(args[0]);
                }
                else{   // At last if user will not provide any / wrong input
                    System.out.println("Enter A valid Input");
                }   
        }
        if (task != null) {
            System.out.println(task.execute());     // only print statement available
        } else {
            System.out.println("Invalid choice");
        }
        // The bellow free methode from ConsoleInputHandler class close the scanner
        inputHandler.free();
    }
}
