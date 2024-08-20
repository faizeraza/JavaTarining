package assingments;
import assingments.support.InnerAdd;

public class Addition {
    public InnerAdd innerAdd;

    
    public Addition(InnerAdd innerAdd) {
        this.innerAdd = innerAdd;
    }

    public void add(){
        innerAdd.add();
    }
}
