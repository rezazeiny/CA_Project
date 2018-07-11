package Component;

import org.junit.Test;

import static Component.Functions.*;
import static org.junit.Assert.assertEquals;

public class FunctionsTest {
    @Test
    public void convertHEXtoBINTest() throws Exception {
        assertEquals("11111111111111111111111111111111", convertHEXtoBIN("FFFFFFFF"));
        assertEquals("00000001001000110100010101100111", convertHEXtoBIN("01234567"));
    }

    @Test
    public void convertBINtoHEXTest() throws Exception {
        assertEquals("FFFFFFFF", convertBINtoHEX("11111111111111111111111111111111"));
    }

    @Test
    public void convertHEXtoDECTest() throws Exception {
        assertEquals(-1, convertHEXtoDEC("FFFFFFFF"));
        assertEquals(19088743, convertHEXtoDEC("01234567"));
        assertEquals(-1985229329, convertHEXtoDEC("89ABCDEF"));
    }

    @Test
    public void convertDECtoHEXTest() throws Exception {
        assertEquals("FFFFFFFF", convertDECtoHEX(-1));
        assertEquals("FFFFFFFE", convertDECtoHEX(-2));
        assertEquals("00000000", convertDECtoHEX(0));
    }

}
