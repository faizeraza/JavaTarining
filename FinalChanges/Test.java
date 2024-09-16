import assignments.support.ioHandling.InputHandler;
import assignments.support.operations.FloatAddition;
import assignments.support.operations.IntAddition;
import assignments.task.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// Main Methode this contains initialization of classes.
// The Classes have there own seperate module.
// Each module is dedicated to each question.

public class Test {
    @SuppressWarnings("rawtypes")
    private final static Map<String, Supplier<Task>> taskMap = new HashMap<>();
    final static InputHandler inputHandler = new InputHandler();
    // Instance Creation of support classes is Done before switch case,
    // Support classes are stored into sub-package named <support>
    // these are the classes which contains general methods 
    // Now we dont need to write the same redendant logics for each task
    // Jst call the class and Boom we are good to go.
    // As they are general for several High level classes.


      static {
        // Initialize the taskMap with lambda expressions or method references
        taskMap.put("1", Assignment1::new);
        taskMap.put("2", () -> new Assignment2(inputHandler));
        taskMap.put("5", () -> new Assignment5(inputHandler, new IntAddition()));
        taskMap.put("6", () -> new Assignment6(inputHandler, new FloatAddition()));
        taskMap.put("7", () -> new Assignment7(inputHandler));
        taskMap.put("8", () -> new Assignment8(inputHandler));
        taskMap.put("9", () -> new Assignment9(inputHandler));
        taskMap.put("10", () -> new Assignment10(inputHandler));
        taskMap.put("11", () -> new Assignment11(inputHandler));
        taskMap.put("12", () -> new Assignment12(inputHandler));
        taskMap.put("13", () -> new Assignment13(inputHandler));
        taskMap.put("14", Assignment14::new);
        taskMap.put("15", Assignment15::new);
        taskMap.put("16", () -> new Assignment16());
        taskMap.put("17", () -> new Assignment17());
        taskMap.put("18", () -> new Assignment18());
        taskMap.put("19", () -> new Assignment19());
        taskMap.put("20", () -> new Assignment20());
        taskMap.put("21", () -> new Assignment21());
        taskMap.put("22", () -> new Assignment22());
        taskMap.put("23", () -> new Assignment23());
        taskMap.put("24", () -> new Assignment24());
        taskMap.put("25", () -> new Assignment25());
        taskMap.put("26", () -> new Assignment26());
        taskMap.put("27", () -> new Assignment27());
    }

    public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
        Task task = null;
        taskMap.put("29", () -> new Assignment29(args[0]));
        while (true) {
            String choice = inputHandler.getStringInput("Enter Question Number");

            try {
                if (taskMap.containsKey(choice)) {
                    task = taskMap.get(choice).get();
                } else {
                    if ("3".equals(choice)) {
                        task = new Assignment3(args[0]);
                    }
                    else if ("28".equals(choice) ) {
                        task = new Assignment28(args[0]);
                    }
                    else if ("29".equals(choice) ) {
                        task = new Assignment29(args[0]);
                    }
                    else if ("30".equals(choice) && args.length == 1) {
                        task = new Assignment30(args[0]);
                    }
                     else if ("4".equals(choice) && args.length == 2) {
                        task = new Assignment4(args[0], args[1]);
                    }
                    else if("exit".equals(choice)){
                        System.exit(0);
                    } else {
                        System.out.println("Enter a valid input");
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You have not passed any runtime aurguments...");
            }
            if (task != null) {
                System.out.println(task.execute());
                task = null; // Free task after getting executed
            }
        }
    }
}
