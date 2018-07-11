package CPU;

import java.util.ArrayList;

import static Component.Functions.convertHEXtoDEC;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Memory {
    private int memorySize;
    private String[] data;
    /**
     * length of strings = 8 ( only HEX )
     */
    Memory (ArrayList<String> inputInst){
        memorySize = 512;
        data = new String[this.memorySize];
        for (int i = 0; i < inputInst.size(); i++) {
            data[i] = inputInst.get(i);
        }
    }

    void readData() {
        int address = convertHEXtoDEC(CPU.getInstance().getDataPath().getReg("MAR"));
        if (address >= this.memorySize) {
            System.err.println("in readData function in Memory we have invalid address");
        }
        else {
            CPU.getInstance().getState().setMDR_M(this.data[address]);
            CPU.getInstance().getState().setMemReady(false);
        }
    }

    void fetchInst() {
        int address = convertHEXtoDEC(CPU.getInstance().getDataPath().getReg("PC"));
        if (address >= this.memorySize) {
            System.err.println("in fetchInst function in Memory we have invalid address");
        }
        else {
            CPU.getInstance().getState().setMBR_M(this.data[address]);
            CPU.getInstance().getState().setMemReady(false);
        }
    }

    void writeData() {
        int address = convertHEXtoDEC(CPU.getInstance().getDataPath().getReg("MAR"));
        if (address >= this.memorySize) {
            System.err.println("in writeData function in Memory we have invalid address");
        }
        else {
            CPU.getInstance().getState().setMemReady(false);
            this.data[address] = CPU.getInstance().getDataPath().getReg("MDR");
        }
    }

    public void readAll() {
        for (int i = 0; i < memorySize; i++) {
            System.out.printf("%3d: %s\n",i,this.data[i]);
        }
    }
}
