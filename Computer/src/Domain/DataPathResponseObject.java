package Domain;

import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class DataPathResponseObject {
    private boolean zero;
    private boolean neg;
    Map<String, Integer> registers;


    public Map<String, Integer> getRegisters() {
        return registers;
    }

    public void setRegisters(Map<String, Integer> registers) {
        this.registers = registers;
    }

    public boolean isZero() {
        return zero;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    public boolean isNeg() {
        return neg;
    }

    public void setNeg(boolean neg) {
        this.neg = neg;
    }
}
