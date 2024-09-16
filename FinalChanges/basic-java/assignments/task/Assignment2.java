package assignments.task;
import assignments.support.ioHandling.InputHandler;

// 2.Write a program to prompt the user to enter a name, and print “Hello <name>”.
//   Replace “<name>” with the text entered by a user running the program

public class Assignment2 implements Task<String>{
    // We dont need name vriable outside of Assignment2 module so keeping it private 
    private String name;
    // Using the Support class for taking input
    public Assignment2(InputHandler io) {
        name = io.getStringInput("Enter Name: ");
    }
    @Override
    public String execute() {
        return "Hello "+name; // String concatination has been done here.
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
