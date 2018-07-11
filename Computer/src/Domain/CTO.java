package Domain;

import Enums.BusSource;
import Enums.MemBits;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class CTO {
    private Map<String, Boolean> writeBits = new HashMap<>();
    private boolean INC;
    private boolean DEC;
    private BusSource busSource;
    private String aluControl;
    private MemBits mem;
    private int shiftDistance;
    private boolean shiftDirection;

    public CTO(MemBits mem, boolean INC, boolean DEC, BusSource busSource,
               String[] writeBits, String aluControl, int shiftDistance, boolean shiftDirection) {
        this.shiftDirection = shiftDirection;
        this.shiftDistance = shiftDistance;
        this.aluControl = aluControl;
        this.INC = INC;
        this.DEC = DEC;
        this.mem = mem;
        this.busSource = busSource;
        this.writeBits.put("MAR", false);
        this.writeBits.put("MDR", false);
        this.writeBits.put("PC", false);
        this.writeBits.put("SP", false);
        this.writeBits.put("LV", false);
        this.writeBits.put("CPP", false);
        this.writeBits.put("TOS", false);
        this.writeBits.put("OPC", false);
        this.writeBits.put("H", false);
        for (String writeBit : writeBits) {
            this.writeBits.put(writeBit, true);
        }
    }


    public BusSource getBusSource() {
        return busSource;
    }

    public Map<String, Boolean> getWriteBits() {
        return writeBits;
    }

    public int getShiftDistance() {
        return shiftDistance;
    }

    public MemBits getMem() {
        return mem;
    }

    public String getAluControl() {
        return aluControl;
    }

    public boolean isDEC() {
        return DEC;
    }

    public boolean isINC() {
        return INC;
    }

    public boolean isShiftDirection() {
        return shiftDirection;
    }
}
