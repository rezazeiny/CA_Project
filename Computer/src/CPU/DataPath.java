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
    Map<String, Integer> register = new HashMap<>();
    String busValue;


    public DataPath(){
        alu = new ALU();

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
