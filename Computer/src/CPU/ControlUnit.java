package CPU;

import Domain.CTO;
import Enums.BusSource;
import Enums.MemBits;

class ControlUnit {

    ControlUnit() {

    }

    void execute() {
        String temp;
        String inst;
        if (CPU.getInstance().getState().isEndProgramme())
            System.exit(0);
        if (!CPU.getInstance().getState().isMemReady()) {
            CPU.getInstance().getState().setMemReady(true);
            return;
        }
        if (CPU.getInstance().getState().isEndInst()) {
            CPU.getInstance().getState().setMBR_M(null);
            CPU.getInstance().getState().setInstName(null);
            CPU.getInstance().getState().setEndInst(false);
        }
        CTO cto;
        if (CPU.getInstance().getState().getInstName() == null) {
            if (CPU.getInstance().getState().getMBR_M() == null) {
                cto = new CTO(MemBits.Fetch, true, false, BusSource.PC,
                        new String[]{}, "011000", 0, true);
                CPU.getInstance().getState().setCto(cto);
                CPU.getInstance().getDataPath().exertCto(cto);
            } else {
                inst = CPU.getInstance().getState().getMBR_M();
                temp = "00000000" + inst;
                CPU.getInstance().getDataPath().setRegisters("MBR",
                        temp.substring(temp.length()-8,temp.length()));
                CPU.getInstance().getState().setInstName(inst.substring(0, 2));
                CPU.getInstance().getState().setLevel(1);
            }
        } else {
            inst = CPU.getInstance().getState().getInstName();
            State state = CPU.getInstance().getState();
            switch (inst) {
                case "10": {
//                    state.setInstName("BIPUSH");
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, false, BusSource.SP,
                                    new String[]{"MAR"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"MDR"}, "011000", 24, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MDR,
                                    new String[]{"MDR"}, "011000", 24, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            cto = new CTO(MemBits.Write, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "A7":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"PC"}, "011000", 16, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.PC,
                                    new String[]{"PC"}, "011000", 16, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "60":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR","SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR" ,"SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MDR,
                                    new String[]{"H"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MDR,
                                    new String[]{"MDR"}, "111100", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 6:
                            cto = new CTO(MemBits.Write, true, false, BusSource.SP,
                                    new String[]{}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "99":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR","SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.MDR,
                                    new String[]{"MDR"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            if (!state.isZero()){
                                state.setLevel(0);
                                state.setEndInst(true);
                                return;
                            }
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"PC"}, "011000", 16, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.PC,
                                    new String[]{"PC"}, "011000", 16, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "9B":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR","SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.MDR,
                                    new String[]{"MDR"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            if (!state.isNegative()){
                                state.setLevel(0);
                                state.setEndInst(true);
                                return;
                            }
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"PC"}, "011000", 16, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.PC,
                                    new String[]{"PC"}, "011000", 16, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "9F":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR","SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR" ,"SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MDR,
                                    new String[]{"H"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MDR,
                                    new String[]{"MDR"}, "111111", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 6:
                            if (!state.isZero()){
                                state.setLevel(0);
                                state.setEndInst(true);
                                return;
                            }
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"PC"}, "011000", 16, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 7:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.PC,
                                    new String[]{"PC"}, "011000", 16, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "84":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"TOS"}, "011000", 24, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.TOS,
                                    new String[]{"H"}, "011000", 24, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.CPP,
                                    new String[]{"MDR"}, "111100", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"TOS"}, "011000", 16, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.TOS,
                                    new String[]{"H"}, "011000", 24, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 6:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.LV,
                                    new String[]{"MAR"}, "111100", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
//                            state.setEndInst(true);
                            break;
                        case 7:
                            cto = new CTO(MemBits.Write, false, false, BusSource.TOS,
                                    new String[]{}, "011000", 24, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "15":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"TOS"}, "011000", 24, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.TOS,
                                    new String[]{"H"}, "011000", 24, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.LV,
                                    new String[]{"MAR"}, "111100", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            cto = new CTO(MemBits.Read, false, false, BusSource.LV,
                                    new String[]{}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, true, false, BusSource.SP,
                                    new String[]{"MAR"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 6:
                            cto = new CTO(MemBits.Write, false, false, BusSource.LV,
                                    new String[]{"MAR"}, "111100", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "36":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR","SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                        case 4:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{"TOS"}, "011000", 24, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.TOS,
                                    new String[]{"H"}, "011000", 24, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 6:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.LV,
                                    new String[]{"MAR"}, "111100", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
//                            state.setEndInst(true);
                            break;
                        case 7:
                            cto = new CTO(MemBits.Write, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "64":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR","SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 2:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, false);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 3:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, true, true, BusSource.SP,
                                    new String[]{"MAR" ,"SP"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 4:
                            cto = new CTO(MemBits.Read, false, false, BusSource.MDR,
                                    new String[]{"H"}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 5:
                            temp = "00000000" + CPU.getInstance().getState().getMDR_M();
                            CPU.getInstance().getDataPath().setRegisters("MDR",
                                    temp.substring(temp.length()-8,temp.length()));
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MDR,
                                    new String[]{"MDR"}, "111111", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(state.getLevel() + 1);
                            break;
                        case 6:
                            cto = new CTO(MemBits.Write, true, false, BusSource.SP,
                                    new String[]{}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
                case "00":{
                    switch (state.getLevel()) {
                        case 1:
                            cto = new CTO(MemBits.Nothing, false, false, BusSource.MBR,
                                    new String[]{}, "011000", 0, true);
                            state.setCto(cto);
                            CPU.getInstance().getDataPath().exertCto(cto);
                            state.setLevel(0);
                            state.setEndInst(true);
                            break;
                    }
                    break;
                }
            }

        }
    }
}
