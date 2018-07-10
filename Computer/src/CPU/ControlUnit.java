package CPU;
import Domain.CTO;
import Domain.DataPathResponseObject;
import Domain.MainCuResponseObject;
import Domain.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class ControlUnit {
    Map<String, Integer> commandLevel = new HashMap<>();
    DataPath dataPath;
    boolean neg = false;
    boolean zero = false;
    public ControlUnit() {
        dataPath = new DataPath();
        commandLevel = new HashMap<>();
        //todo fill this map

    }

    /**
     * flow method.
     * 2 - getting first state of command.
     * 3 - fires command and sends state to {@link DataPath#exertCto(CTO)} and gets a response object.
     * 4 - make a {@link MainCuResponseObject} and return
     *
     * @param command
     * @return 
     */
    public MainCuResponseObject executeCommand(String command) {
        //todo write a for on command levels, extract ctos and fire
        State tempState = extractCommandStartState(command);
        int levels = commandLevel.get(tempState.name) + 1;
        CTO tempCto;
        DataPathResponseObject tempResponseObject = new DataPathResponseObject();
        for (int i = 0; i < levels; i++) {
            tempCto = extractCtoFromState(tempState);
            tempResponseObject = dataPath.exertCto(tempCto);
            this.zero = tempResponseObject.isZero();
            this.neg = tempResponseObject.isNeg();
            tempState.level = tempState.level + 1;
        }
        MainCuResponseObject mainCuResponseObject = new MainCuResponseObject();
        mainCuResponseObject.setPc(tempResponseObject.getRegisters().get("PC"));
        return mainCuResponseObject;
    }

    private State extractCommandStartState(String command) {
        //todo fill fields of state and put the level = 1
        State state = new State();
        switch (command.substring(0, 2)) {
            case "10":
                state.name = "BIPUSH";
                break;
            case "A7":
                state.name = "GOTO";
                break;
            case "60":
                state.name = "IADD";
                break;
            case "99":
                state.name = "IFEQ";
                break;
            case "9B":
                state.name = "IFLT";
                break;
            case "9F":
                state.name = "IF _ICMPEQ";
                break;
            case "84":
                state.name = "IINC";
                break;
            case "15":
                state.name = "ILOAD";
                break;
            case "36":
                state.name = "ISTORE";
                break;
            case "64":
                state.name = "ISUB";
                break;
            case "00":
                state.name = "NOP";
                break;
        }
        state.level = 1;
        return null;
    }


    private CTO extractCtoFromState (State state) {
        //TODO switch cases are here, get an state and extract cto

        return null;
    }

}
