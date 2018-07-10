package Component;

import java.math.BigInteger;

public final class Functions {
    public static String convertHEXtoBIN(String input) {
        String temp = "00000000000000000000000000000000" + new BigInteger(input, 16).toString(2);
        return temp.substring(temp.length() - 32, temp.length());
    }

    public static String convertBINtoHEX(String input) {
        String temp = "00000000000000000000000000000000" + new BigInteger(input, 2).toString(16);
        return temp.substring(temp.length() - 8, temp.length());
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
            output = Integer.parseInt(input.substring(0, 8), 16);
        }
        return output;
    }
}
