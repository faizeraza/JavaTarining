package assignments.support;

import assignments.support.operations.FloatAddition;
import assignments.support.operations.FloatDivision;
import assignments.support.operations.FloatMultiplication;
import assignments.support.operations.FloatSubstraction;

public class Calculator {
    Float firstOperand;
    Float secondOperand;
    public Calculator(Float firstOperand, Float secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    public Float add(){
        return new FloatAddition().perform(firstOperand, secondOperand);
    }
    public Float substract(){
        return new FloatSubstraction().perform(firstOperand, secondOperand);
    }
    public Float multiply(){
        return new FloatMultiplication().perform(firstOperand, secondOperand);
    }
    public Float divide() throws ArithmeticException{
        return new FloatDivision().perform(firstOperand, secondOperand);
    }
}
