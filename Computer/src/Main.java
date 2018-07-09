import CPU.ControlUnit;
import Domain.MainCuResponseObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Main {
    private static ArrayList<String> INSTs = new ArrayList<>();
    private static ControlUnit controlUnit;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        controlUnit = new ControlUnit();
        getFromFile("Computer/INSTs.txt");
        startCPU();
    }


    private static void startCPU() {
        int PC = 0;
        while (INSTs.size() > PC) {
            MainCuResponseObject result = controlUnit.executeCommand(INSTs.get(PC));
            PC = result.getPc();
        }

    }

    private static void getFromFile(String fileAddress) {
        File file = new File(fileAddress);
        int currentLine = 0;
        String currentINST;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                currentLine++;
                currentINST = scanner.nextLine();
                if (getInst(currentINST).equals("INVALID"))
                    System.err.println("Ignore line " + String.valueOf(currentLine) + ": \""
                            + currentINST + "\" is not valid");
                else
                    INSTs.add(getInst(currentINST));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Doesn't exist");
            System.exit(0);
        }

    }

    private static String getInst(String input) {
        String inputs[] = input.split(" ");
        String inst;
        switch (inputs[0].toUpperCase()) {
            case "BIPUSH":
                inst = "10" + inputs[1];
                break;
            case "GOTO":
                inst = "A7" + inputs[1];
                break;
            case "IADD":
                inst = "60";
                break;
            case "IFEQ":
                inst = "99" + inputs[1];
                break;
            case "IFLT":
                inst = "9B" + inputs[1];
                break;
            case "IF _ICMPEQ":
                inst = "9F" + inputs[1];
                break;
            case "IINC":
                inst = "84" + inputs[1] + inputs[2];
                break;
            case "ILOAD":
                inst = "15" + inputs[1];
                break;
            case "ISTORE":
                inst = "36" + inputs[1];
                break;
            case "ISUB":
                inst = "64";
                break;
            case "NOP":
                inst = "00";
                break;
            default:
                return "INVALID";
        }
        return inst;
    }
}
