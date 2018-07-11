package Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public final class Functions {
    static String convertHEXtoBIN(String input) {
        String temp = "00000000000000000000000000000000" + new BigInteger(input, 16).toString(2);
        return temp.substring(temp.length() - 32, temp.length());
    }

    static String convertBINtoHEX(String input) {
        String temp = "00000000000000000000000000000000" + new BigInteger(input, 2).toString(16);
        return temp.substring(temp.length() - 8, temp.length()).toUpperCase();
    }

    public static int convertHEXtoDEC(String input) {
        input = convertHEXtoBIN(input);
        int output;
        if (input.substring(0, 1).equals("1")) {
            output = Integer.parseInt(input.substring(1, 32), 2);
            output = ~output;
            output++;
            String temp = "00000000000000000000000000000000" + Integer.toBinaryString(output);
            output = Integer.parseInt(temp.substring(temp.length() - 31, temp.length()), 2);
            output *= -1;
        } else {
            output = Integer.parseInt(input.substring(0, 32), 2);
        }
        return output;
    }

    static String convertDECtoHEX(int input) {
        StringBuilder temp = new StringBuilder();
        if (input >= 0) {
            temp = new StringBuilder("00000000" + Integer.toString(input, 16));
        } else {
            String bin = "00000000000000000000000000000000" + Integer.toBinaryString(input);
            bin = bin.substring(bin.length() - 32, bin.length());
            for (int i = 0; i < 8; i++) {
                temp.append(Integer.toString(Integer.parseInt(bin.substring(i * 4, (i + 1) * 4), 2), 16));
            }
        }
        return temp.substring(temp.length() - 8, temp.length()).toUpperCase();
    }

    public static ArrayList<String> getFromFile(String fileAddress) {
        ArrayList<String> INSTs = new ArrayList<>();
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
        return INSTs;
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
