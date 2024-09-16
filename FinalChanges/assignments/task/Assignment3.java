package assignments.task;

// 3.Write a program to accept “<name>” as command line argument, and print “Hello <name>”.
//   Replace “<name>” with the text entered by a user running the program
public class Assignment3 implements Task<String>{
   private String name;         // only need inside this class so keeping private
   public Assignment3(String name) {
        this.name = name;       // the name parameter taken here is args[0] at initailization in Main.java
    }
    
   @Override
   public String execute() {
        return "Hello!! "+name; // String Concatinated with Hello!!
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
