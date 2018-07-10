package CPU;

import Component.ALU;
import Component.Shifter;
import Domain.CTO;
import Domain.DataPathResponseObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class DataPath {
    ALU alu;
    Shifter shifter;
    Map<String, Integer> register = new HashMap<>();
    Shifter shifter;
    Map<String, String> registers = new HashMap<>();
    String busValue;
    String aluInput1;



    public DataPath() {
        alu = new ALU();
        shifter = new Shifter();
        registers.put("PC", "00000000");//from zero
        registers.put("MDR", "00000000");
        registers.put("MAR", "00000000");
        registers.put("MBR", "00000000");
        registers.put("SP", "00000080");//from 128
        registers.put("SDR", "00000000");//secondary data register
        registers.put("CPP", "00000100");//from 256
        registers.put("LVP", "00000180");//from 384

    }

    /**
     * 1- ki bayad bere ru baas (done)
     * 2- az alu radesh kon (done)
     * 3- az shifter radesh kon (done)
     * 4- load e kia roshane ke meqdaare bus ro begiran (done)
     * 5- inc o dec e kia active e? inc o dec shan (done, faqat methodaash mundan)
     * 6- amaliat e ba memory anjaam she
     *
     * @param cto
     * @return
     */
    public DataPathResponseObject exertCto(CTO cto) {

        switch (cto.busSource) {
            case 0:
                aluInput1 = registers.get("PC");
                break;
            case 1:
                aluInput1 = registers.get("MDR");
                break;
            case 2:
                aluInput1 = registers.get("MAR");
                break;
            case 3:
                aluInput1 = registers.get("MBR");
                break;
            case 4:
                aluInput1 = registers.get("SP");
                break;
            case 5:
                aluInput1 = registers.get("SDR");
                break;
            case 6:
                aluInput1 = registers.get("CPP");
                break;
            case 7:
                aluInput1 = registers.get("LV");
                break;
        }
        //pathing from alu and shifter
        busValue = shifter.path(cto.controlBits.get("shiftDirection"),
                cto.shiftDistance,
                alu.path(cto.aluControl, aluInput1, registers.get("SDR")));

        Set<String> controlBits = cto.controlBits.keySet();
        for (String controlBit : controlBits) {
            if ((controlBit.contains("load")) && (cto.controlBits.get(controlBit))) {
                registers.put(controlBit.substring(4) , busValue);
            }
            if ((controlBit.contains("inc")) && (cto.controlBits.get(controlBit))) {
                String inced = hexInc(registers.get(controlBit.substring(3)));
                registers.put(controlBit.substring(3) , inced);
            }
            if ((controlBit.contains("dec")) && (cto.controlBits.get(controlBit))) {
                String deced = hexDec(registers.get(controlBit.substring(3)));
                registers.put(controlBit.substring(3) , deced);
            }
            if ((controlBit.equals("memStart")) && (cto.controlBits.get(controlBit))) {
                //TODO REZA INJA TA'AAMOL E BA MEMORY RO HARJUR SALAAH MIDUNI PIADE SAAZI KON.
            }
        }

        //last lines
        DataPathResponseObject dataPathResponseObject = new DataPathResponseObject();
        dataPathResponseObject.setNeg(alu.isNeg());
        dataPathResponseObject.setZero(alu.isZero());
        dataPathResponseObject.setRegisters(registers);
        return dataPathResponseObject;
    }

    private String hexInc (String input){
        //todo implement
        return "";
    }

    private String hexDec (String input){
        //todo implement
        return "";
    }

}
