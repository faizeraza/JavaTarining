import java.util.Scanner;

public class Basic{
	// First Question
	void getMessage(){
		System.out.println("Hello World");
	}
    // Second Question
	void getWithScanner(String name){
		System.out.println("Hello "+name);
	}
	// 3rd Question
	void setWithArg(String name){
		System.out.println("Hellow "+name);
	}
    // 4th Question
	void setAndReplace(String message, String name){
		System.out.println("Massage before replacement: "+name);
		System.out.println(message.replace("<name>", name));
	}
    // 5th Question
	void add(Scanner sc){
		try {
            System.out.print("First Operand ");
            int num1 = sc.nextInt();
            sc.nextLine();                                       
            System.out.print("Second Operand: ");
            int num2 = sc.nextInt();
            sc.nextLine();
            int sum = num1 + num2;
            System.out.println("num1=" + num1 + " num2=" + num2 + " sum=" + sum);

        } catch (Exception e) {
            System.out.println("Error: Please enter valid whole numbers.");
        }
	}
    // 6th Question
	void addFloat(Scanner sc){
		try {
			System.out.print("Enter num1: ");
			float num1 = sc.nextFloat();
            sc.nextLine();
			System.out.print("Enter num2: ");
			float num2 = sc.nextFloat();
            sc.nextLine();
			float sum = num1 + num2;
			System.out.println("num1=" + num1 + " num2=" + num2 + " sum=" + sum);

		} catch (Exception e) {
			System.out.println("Error: Please enter valid Float numbers.");
		} 
	}
    // 7th Question
	void calculate(Scanner sc){
        try {
            System.out.print("First Operand ");
            float num1 = Float.parseFloat(sc.nextLine());
            sc.nextLine();
            System.out.print("Second Operand ");
            float num2 = Float.parseFloat(sc.nextLine());
            sc.nextLine();
            System.out.print("Enter operation to be performed (+, -, *, /): ");
            String operation = sc.nextLine().trim();
            sc.nextLine();
            float result;
            String operationName;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    operationName = "ADD";
                    break;
                case "-":
                    result = num1 - num2;
                    operationName = "Substract";
                    break;
                case "*":
                    result = num1 * num2;
                    operationName = "Multiply";
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        sc.close();
                        return;
                    }
                    result = num1 / num2;
                    operationName = "Divide";
                    break;
                default:
                    System.out.println("Error: Invalid operator provided. Use +, -, *, or /.");
                    sc.close();
                    return;
            }

            System.out.println("num1=" + num1 + " num2=" + num2 + " " + operationName + "=" + result);

        } catch (Exception e) {
            System.out.println("Error: Please enter valid floating-point numbers.");
        } 
	}

    void sort(Scanner sc){
        
    }
    int statLoop(Scanner sc){
        Boolean flag = true; 
        int sum = 0;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE, count=0,mean = 0;
        try{
           
            while(flag){
                System.err.println("Enter Number to add or Type Proceed/Mean/Min/Max/Count:");
                String input = sc.nextLine();
                if(input.toLowerCase().equals("proceed")){
                    System.out.print("Addition");
                    return sum;
                }
                else if(input.toLowerCase().contains("min")){
                    System.out.println("Minimun ");
                    return min;
                }
                else if(input.toLowerCase().contains("max")){
                    System.out.println("Maximum ");
                    return max;
                }
                else if(input.toLowerCase().contains("mean")){
                    System.out.println("Mean ");
                    return mean;
                }
                else if(input.toLowerCase().contains("count")){
                    System.out.println("Count ");
                    return count;
                }
                else{
                    int newNumber = Integer.parseInt(input);
                    sum = sum + newNumber;
                    count ++;
                    max = Math.max(max, newNumber);
                    min = Math.min(min, newNumber);
                    mean = sum/count;
                }
            }
        }
        catch(Exception e){
            System.out.println("Please Enter a valid number or Type Proceed: ");
        }
        return sum;
    }
    public static void main(String args[]){
		Scanner sc =  new Scanner(System.in);
        Basic bs=  new Basic();
        System.out.println("Enter Ouestion Number:");
        String choice = sc.next();
		sc.nextLine();
        switch (choice) {
            case "1":
                bs.getMessage();
                break;
            case "2":
                System.out.println("Enter Name :");
                String name = sc.next();
                bs.getWithScanner(name);
                break;
            case "5":
                bs.add(sc);
                break;
            case "6":
                bs.addFloat(sc);
                break;
            case "7":
                bs.calculate(sc);
            case "8":
                System.out.println(" Result: "+bs.statLoop(sc));
            default:
                    if (args.length == 1){
                        bs.setWithArg(args[0]);
                    }
                    else if (args.length == 2){
                        bs.setAndReplace(args[0], args[1]);
                    }
                    else{
                        System.out.println("Enter A valid Input");
                    }
                break;
        }	
		sc.close();
	}

}
