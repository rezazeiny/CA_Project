package CPU;

import Domain.CTO;
import Domain.MainCuResponseObject;
import Domain.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class ControlUnit {
    Map<String, Integer> commandlevel = new HashMap<>();

    public ControlUnit(){
        commandlevel = new HashMap<>();
        //todo fill this map

    }

    /**
     * flow method.
     * 1 - getting command name
     * 2 - getting first state of command.
     * 3 - fires command and sends state to {@link DataPath#exertCto(CTO)} and gets a response object.
     * 4 - make a {@link MainCuResponseObject} and return
     * @param command
     * @return
     */
    public MainCuResponseObject executeCommand(String command) {
        //todo write a for on command levels, extract ctos and fire
        return null;
    }

    private State extractCommandStartState(String command){
        //todo fill fields of state and put the level = 1
        return null;
    }


    private CTO extractCtoFromState(State state) {
        //TODO switch cases are here, get an state and extract cto

        return null;
    }

}
