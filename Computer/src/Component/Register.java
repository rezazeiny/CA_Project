package Component;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Register {
    private String value;
    private boolean load;
    private boolean inc;
    private boolean dec;

    public boolean isLoad() {
        return load;
    }

    public void setLoad(boolean load) {
        this.load = load;
    }

    public boolean isInc() {
        return inc;
    }

    public void setInc(boolean inc) {
        this.inc = inc;
    }

    public boolean isDec() {
        return dec;
    }

    public void setDec(boolean dec) {
        this.dec = dec;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
