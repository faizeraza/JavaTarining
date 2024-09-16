package assignments.task;

// 4. Modify the above program to take two command-line parameters. The first is the string for
//    the message template, like “Hello <name>” or any other template. The second is the actual
//    name to print in the message by replacing “<name>” with the given name.
public class Assignment4 implements Task<String>{
   private String name,message;

   public Assignment4(String message ,String name) {
        this.message = message;
        this.name = name;
    }
    
   @Override
   public String execute() {
    return "Massage before replacement: "+message+"\n"+message.replace("name", name);   // whatever the message is the "name" string will be replaced by variable name 
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
}
