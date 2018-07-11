package CPU;


import static Component.Functions.getFromFile;

public class CPU {
    private static CPU instance = new CPU();
    private ControlUnit controlUnit;
    private Memory memory;
    private DataPath dataPath;
    private State state;

    private CPU() {
        memory = new Memory(getFromFile("Computer/INSTs.txt"));
        controlUnit = new ControlUnit();
        dataPath = new DataPath();
        state = new State();
    }
    public static CPU getInstance(){
        return instance;
    }
    public void start(){
        this.printData();
    }
    public void pulse(){
        controlUnit.execute();
        this.printData();
    }
    private void printData(){
        System.out.println("Next Clock INST: "+state.getInstName()+" - "+ state.getLevel());
        System.out.println("PC:  "+ dataPath.getReg("PC"));
        System.out.println("SP:  "+ dataPath.getReg("SP"));
        System.out.println("LV:  "+ dataPath.getReg("LV"));
        System.out.println("CPP: "+ dataPath.getReg("CPP"));
        System.out.println("MAR: "+ dataPath.getReg("MAR"));
        System.out.println("MDR: "+ dataPath.getReg("MDR"));
        System.out.println("MBR: "+ dataPath.getReg("MBR"));
        System.out.println("TOS: "+ dataPath.getReg("TOS"));
        System.out.println("OPC: "+ dataPath.getReg("OPC"));
        System.out.println("H:   "+ dataPath.getReg("H"));
        System.out.println("MBR_M:"+ state.getMBR_M());
        System.out.println("MDR_M:"+ state.getMDR_M());
        System.out.println("BUS: "+ state.getBusValue());
        System.out.println("MEM_ready:"+ state.isMemReady());
        System.out.println("ZERO:     "+ state.isZero());
        System.out.println("NEGATIVE: "+ state.isNegative());
        System.out.println("END_INST: "+ state.isEndInst());
        System.out.println("INST:");
        System.out.println("MEM: " + state.getCto().getMem().toString());
        System.out.println("BUS_SOURCE: " + state.getCto().getBusSource().toString());
        System.out.println("WriteBits: " + state.getCto().getWriteBits());
        System.out.println("ALU: " + state.getCto().getAluControl());
        System.out.println("Shift Distance: " + state.getCto().getShiftDistance());
        System.out.println("Shift Direction: " + state.getCto().isShiftDirection());
        System.out.println("INC: " + state.getCto().isINC());
        System.out.println("DEC: " + state.getCto().isDEC());

    }

    DataPath getDataPath() {
        return dataPath;
    }

    public Memory getMemory() {
        return memory;
    }

    public State getState() {
        return state;
    }
}
