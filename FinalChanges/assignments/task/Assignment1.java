package assignments.task;

// 1.Write a program to print “Hello World” on the standard output

// Interface Task has been implement
public class Assignment1 implements Task<String>{
    // Task contains method execute which must be Override based on custom modification
    @Override
    public String execute() {
        return "Hello World";
    }
}
