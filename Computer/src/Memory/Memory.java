package Memory;

import java.util.List;

/**
 * Created by amirmhp on 7/9/2018.
 */
public class Memory {
    /**
     * length of strings = 32 ( only 0 and 1 is legal )
     */
    private String[] data = new String[512];

    //completed
    public String getData(String address) {
        int intAddress = extractIntAddress(address);
        return data[intAddress];
    }

    //completed
    public void putData(String address, String data) {
        int intAddress = extractIntAddress(address);
        this.data[intAddress] = data;
    }

    private int extractIntAddress(String stringAddress) {
        int result = 0;
        //todo convert
        return result;
    }


    private String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        this.data = data;
    }
}
