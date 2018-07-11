package CPU;

import Component.ALU;
import Component.Register;
import Component.Shifter;
import Domain.CTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by amirmhp on 7/9/2018.
 */
class DataPath {
    private Shifter shifter;
    private ALU alu;
    private Map<String, Register> registers;
    private String busValue;


    DataPath() {
        busValue = "00000000";
        alu = new ALU();
        shifter = new Shifter();
        registers = new HashMap<>();
        registers.put("MAR", new Register("00000000"));
        registers.put("MDR", new Register("00000000"));
        registers.put("PC", new Register("00000000"));//from zero
        registers.put("MBR", new Register("00000000"));
        registers.put("SP", new Register("00000080"));//from 128
        registers.put("LV", new Register("00000100"));//from 256
        registers.put("CPP", new Register("00000180"));//from 384
        registers.put("TOS", new Register("00000000"));
        registers.put("OPC", new Register("00000000"));
        registers.put("H", new Register("00000000"));

    }

    void exertCto(CTO cto) {
        switch (cto.getMem()){
            case Read:
                CPU.getInstance().getMemory().readData();
                break;
            case Fetch:
                CPU.getInstance().getMemory().fetchInst();
                break;
            case Write:
                CPU.getInstance().getMemory().writeData();
                break;
        }
        this.busValue = this.getDataFromRegister(cto.getBusSource().toString(), cto.isINC(), cto.isDEC());
        this.busValue = alu.path(cto.getAluControl(),this.busValue,registers.get("H").getValue());
        this.busValue = shifter.path(cto.isShiftDirection(),cto.getShiftDistance(),this.busValue);
        Set<String> writeBits = cto.getWriteBits().keySet();
        for (String writeBit : writeBits) {
            if (cto.getWriteBits().get(writeBit)) {
                this.registers.put(writeBit, new Register(busValue));
            }
        }
        CPU.getInstance().getState().setBusValue(this.busValue);
    }

    private String getDataFromRegister(String registerName, boolean INC, boolean DEC) {
        if (INC && DEC) {
            return this.registers.get(registerName).decThenGetValue();
        } else if (INC) {
            return this.registers.get(registerName).getValueThenInc();
        } else if (DEC) {
            return this.registers.get(registerName).getValueThenDec();
        } else {
            return this.registers.get(registerName).getValue();
        }
    }


    String getReg(String registerName) {
        return registers.get(registerName).getValue();
    }

    void setRegisters(String registerName, String value){
        this.registers.put(registerName, new Register(value));
    }
}
