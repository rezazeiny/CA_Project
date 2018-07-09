package Component;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class ALU {
    private boolean zero;
    private boolean neg;

    public String path (String controlBits, String input1, String input2){
        String result = new String();

        return result;
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
