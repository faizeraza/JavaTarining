package assignments.support.operations;
/**
 * Table class is responsible for generating and printing the multiplication table 
 * of a given number up to a specified number of times.
 */
public class Table {
    int number,times;
    /**
     * @param The base number for which the multiplication table will be generated
     * @param The number of times the table will be printed (i.e., up to which multiplier)
     */
    public Table(int number, int times) {
        this.number = number;
        this.times = times;
    }
    private String tablePrinter(int number,int i){
        return number+" * "+i+" = "+ number*i;     
    }
    // Loop through from 1 to 'times' and print the multiplication result
    public String printTable(){
        for (int i = 1 ; i<=times; i++){
            this.tablePrinter(i, i);
        }
        return "Table Printing Done"; // Return a confirmation message
    } 
}
