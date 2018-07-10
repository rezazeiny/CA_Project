package Domain;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class CTO {
    public String command;

    public Map<String, Boolean> controlBits = new HashMap<>();

    public int busSource;

    /**
     * 6bit 0/1
     */
    public String aluControl;

    //todo think about whether should be int or not
    public int shiftDistance;

    public CTO(){
        controlBits.put("incPC", false);
        controlBits.put("loadPC", false);
        controlBits.put("decPC", false);

        controlBits.put("loadMDR", false);

        controlBits.put("loadMAR", false);

        controlBits.put("loadMBR", false);

        controlBits.put("incSP", false);
        controlBits.put("loadSP", false);
        controlBits.put("decSP", false);

        controlBits.put("loadSDR", false);

        controlBits.put("shiftDirection", false);

        /**
         * 1 : read mode
         * 0 : write mode
         */
        controlBits.put("rwn", false);
        controlBits.put("memStart", false);
    }

}
