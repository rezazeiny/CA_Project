package Component;
import CPU.CPU;

import static Component.Functions.convertDECtoHEX;
import static Component.Functions.convertHEXtoDEC;
/**
 * Created by amirmhp on 7/9/2018.
 */
public class ALU {
    public String path(String controlBits, String input1, String input2) {
        int first = convertHEXtoDEC(input1);
        int second = convertHEXtoDEC(input2);
        int temp;
        switch (controlBits) {
            case "011000":
                temp = first;
                break;
            case "010100":
                temp = second;
                break;
            case "011010":
                temp = ~first;
                break;
            case "101100":
                temp = ~second;
                break;
            case "111100":
                temp = first + second;
                break;
            case "111101":
                temp = first + second + 1;
                break;
            case "111001":
                temp = first + 1;
                break;
            case "110101":
                temp = second + 1;
                break;
            case "111111":
                temp = second - first;
                break;
            case "110110":
                temp = second - 1;
                break;
            case "111011":
                temp = first * -1;
                break;
            case "001100":
                temp = first & second;
                break;
            case "011100":
                temp = first | second;
                break;
            case "010000":
                temp = 0;
                break;
            case "110001":
                temp = 1;
                break;
            case "110010":
                temp = -1;
                break;
            default:
                temp = -1;
        }
        boolean zero;
        boolean neg;
        if (temp == 0) {
            zero = true;
            neg = false;
        } else if (temp < 0) {
            zero = false;
            neg = true;
        } else {
            zero = false;
            neg = false;
        }
        CPU.getInstance().getState().setNegative(neg);
        CPU.getInstance().getState().setZero(zero);
        return convertDECtoHEX(temp);
    }
}
