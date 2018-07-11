package CPU;

import Domain.CTO;
import Enums.BusSource;
import Enums.MemBits;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class State {
    private boolean memReady;
    private boolean zero;
    private boolean negative;
    private String MBR_M;
    private String MDR_M;
    private String instName;
    private boolean endProgramme;
    private String busValue;
    private boolean endInst;
    private int level;
    private CTO cto;
    State() {
        this.cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                new String[]{}, "000000", 0, false);
        this.level = 0;
        this.endInst = false;
        this.memReady = true;
        this.zero = false;
        this.negative = false;
        this.MBR_M = null;
        this.MDR_M = null;
        this.instName = null;
        this.endProgramme = false;
    }

    void setLevel(int level) {
        this.level = level;
    }

    int getLevel() {
        return level;
    }

    String getInstName() {
        return instName;
    }

    String getMBR_M() {
        return MBR_M;
    }

    String getMDR_M() {
        return MDR_M;
    }

    public boolean isEndProgramme() {
        return endProgramme;
    }

    boolean isMemReady() {
        return memReady;
    }

    boolean isNegative() {
        return negative;
    }

    boolean isZero() {
        return zero;
    }

    void setInstName(String instName) {
        this.instName = instName;
    }

    void setMBR_M(String MBR_M) {
        this.MBR_M = MBR_M;
    }

    void setMDR_M(String MDR_M) {
        this.MDR_M = MDR_M;
    }

    void setMemReady(boolean memReady) {
        this.memReady = memReady;
    }

    public void setNegative(boolean negative) {
        this.negative = negative;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    String getBusValue() {
        return busValue;
    }

    void setBusValue(String busValue) {
        this.busValue = busValue;
    }

    void setEndInst(boolean endInst) {
        this.endInst = endInst;
    }

    boolean isEndInst() {
        return endInst;
    }

    CTO getCto() {
        return cto;
    }

    void setCto(CTO cto) {
        this.cto = cto;
    }
}
