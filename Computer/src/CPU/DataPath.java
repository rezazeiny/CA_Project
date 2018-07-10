package CPU;

import Component.ALU;
import Component.Shifter;
import Domain.CTO;
import Domain.DataPathResponseObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class DataPath {
    ALU alu;
    Shifter shifter;
    Map<String, Integer> register = new HashMap<>();
    String busValue;


    public DataPath(){
        alu = new ALU();
        register.put("MAR", 0);
        register.put("MDR", 0);
        register.put("PC", 0);
        register.put("SP", 0);
        register.put("LV", 0);
        register.put("CPP", 0);
        register.put("TOS", 0);
        register.put("OPC", 0);
        register.put("H", 0);
        //todo fill register map
    }

    //todo change void
    public DataPathResponseObject exertCto (CTO cto) {

        //todo exert


        //last lines
        DataPathResponseObject dataPathResponseObject = new DataPathResponseObject();
        dataPathResponseObject.setNeg(alu.isNeg());
        dataPathResponseObject.setZero(alu.isZero());
        return dataPathResponseObject;
    }


}
