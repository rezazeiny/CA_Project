package Component;

import static Component.Functions.convertBINtoHEX;
import static Component.Functions.convertHEXtoBIN;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Shifter {
    public String path(boolean direction, int distance, String input) {
        StringBuilder result;
        input = convertHEXtoBIN(input);
        if (direction) {
            result = new StringBuilder(input.substring(0, 32 - distance));
            for (int i = 0; i < distance; i++) {
                result.insert(0, input.substring(0, 1));
            }
        } else {
            String temp = "00000000000000000000000000000000" + input.substring(distance, 32);
            result = new StringBuilder(temp.substring(temp.length() - 32, temp.length()));
            for (int i = 0; i < distance; i++) {
                result.append("0");
            }
        }
        return convertBINtoHEX(result.toString()).toUpperCase();
    }

}
