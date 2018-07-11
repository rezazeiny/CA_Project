package Component;

import static Component.Functions.convertDECtoHEX;
import static Component.Functions.convertHEXtoDEC;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Register {
    private String value;

    public Register(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getValueThenInc() {
        String tempValue = this.value;
        int value = convertHEXtoDEC(this.value);
        value++;
        this.value = convertDECtoHEX(value);
        return tempValue;
    }

    public String getValueThenDec() {
        String tempValue = this.value;
        int value = convertHEXtoDEC(this.value);
        value--;
        this.value = convertDECtoHEX(value);
        return tempValue;
    }

    public String decThenGetValue() {
        int value = convertHEXtoDEC(this.value);
        value--;
        this.value = convertDECtoHEX(value);
        return this.value;
    }

}
