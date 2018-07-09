package CPU;

import Component.ALU;
import Domain.CTO;
import Domain.DataPathResponseObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class DataPath {
    ALU alu;
    Map<String, Integer> registers = new HashMap<>();
    String busValue;


    public DataPath() {
        alu = new ALU();
        registers.put("PC", 0);//from zero
        registers.put("MDR", 0);
        registers.put("MAR", 0);
        registers.put("MBR", 0);
        registers.put("SP", 128);//from 128
        registers.put("SDR", 0);//secondary data register
        registers.put("CPP", 256);//from 256
        registers.put("LVP", 384);//from 384

        //todo fill registers map
    }

    //todo change void
    public DataPathResponseObject exertCto(CTO cto) {

        //todo exert


        //last lines
        DataPathResponseObject dataPathResponseObject = new DataPathResponseObject();
        dataPathResponseObject.setNeg(alu.isNeg());
        dataPathResponseObject.setZero(alu.isZero());
        dataPathResponseObject.setRegisters(registers);
        return dataPathResponseObject;
    }


}
