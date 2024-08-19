package Mfr;

public class SetWithArg {
	
    public void setWithArg(String name){
		System.out.println("Hellow "+name);
	}
    public void setAndReplace(String message, String name){
		System.out.println("Massage before replacement: "+message);
		System.out.println(message.replace("<name>", name));
	}
}
