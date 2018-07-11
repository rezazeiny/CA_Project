package Component;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ShifterTest {
    private Shifter shifter = new Shifter();

    @Test
    public void pathTest() throws Exception {
        assertEquals("FFFFFFFF", shifter.path(true, 8, "FFFFFFFF"));
        assertEquals("3FFFFFFF", shifter.path(true,1,"7FFFFFFF"));
        assertEquals("1FFFFFFF", shifter.path(true,2,"7FFFFFFF"));
        assertEquals("0FFFFFFF", shifter.path(true,3,"7FFFFFFF"));
        assertEquals("07FFFFFF", shifter.path(true,4,"7FFFFFFF"));
        assertEquals("03FFFFFF", shifter.path(true,5,"7FFFFFFF"));
        assertEquals("01FFFFFF", shifter.path(true,6,"7FFFFFFF"));
        assertEquals("00FFFFFF", shifter.path(true,7,"7FFFFFFF"));
        assertEquals("007FFFFF", shifter.path(true,8,"7FFFFFFF"));
        assertEquals("003FFFFF", shifter.path(true,9,"7FFFFFFF"));
        assertEquals("001FFFFF", shifter.path(true,10,"7FFFFFFF"));
        assertEquals("000FFFFF", shifter.path(true,11,"7FFFFFFF"));
        assertEquals("0007FFFF", shifter.path(true,12,"7FFFFFFF"));
        assertEquals("0003FFFF", shifter.path(true,13,"7FFFFFFF"));
        assertEquals("0001FFFF", shifter.path(true,14,"7FFFFFFF"));
        assertEquals("0000FFFF", shifter.path(true,15,"7FFFFFFF"));
        assertEquals("00007FFF", shifter.path(true,16,"7FFFFFFF"));
        assertEquals("00003FFF", shifter.path(true,17,"7FFFFFFF"));
        assertEquals("00001FFF", shifter.path(true,18,"7FFFFFFF"));
        assertEquals("00000FFF", shifter.path(true,19,"7FFFFFFF"));
        assertEquals("000007FF", shifter.path(true,20,"7FFFFFFF"));
        assertEquals("000003FF", shifter.path(true,21,"7FFFFFFF"));
        assertEquals("000001FF", shifter.path(true,22,"7FFFFFFF"));
        assertEquals("000000FF", shifter.path(true,23,"7FFFFFFF"));
        assertEquals("0000007F", shifter.path(true,24,"7FFFFFFF"));
        assertEquals("0000003F", shifter.path(true,25,"7FFFFFFF"));
        assertEquals("0000001F", shifter.path(true,26,"7FFFFFFF"));
        assertEquals("0000000F", shifter.path(true,27,"7FFFFFFF"));
        assertEquals("00000007", shifter.path(true,28,"7FFFFFFF"));
        assertEquals("00000003", shifter.path(true,29,"7FFFFFFF"));
        assertEquals("00000001", shifter.path(true,30,"7FFFFFFF"));
        assertEquals("00000000", shifter.path(true,31,"7FFFFFFF"));
        assertEquals("00000000", shifter.path(true,32,"7FFFFFFF"));
        assertEquals("FFFFFFFF", shifter.path(false,0,"FFFFFFFF"));
        assertEquals("FFFFFFFE", shifter.path(false,1,"FFFFFFFF"));
        assertEquals("FFFFFFFC", shifter.path(false,2,"FFFFFFFF"));
        assertEquals("FFFFFFF8", shifter.path(false,3,"FFFFFFFF"));
        assertEquals("FFFFFFF0", shifter.path(false,4,"FFFFFFFF"));
        assertEquals("FFFFFFE0", shifter.path(false,5,"FFFFFFFF"));
        assertEquals("FFFFFFC0", shifter.path(false,6,"FFFFFFFF"));
        assertEquals("FFFFFF80", shifter.path(false,7,"FFFFFFFF"));
        assertEquals("FFFFFF00", shifter.path(false,8,"FFFFFFFF"));
        assertEquals("FFFFFE00", shifter.path(false,9,"FFFFFFFF"));
        assertEquals("FFFFFC00", shifter.path(false,10,"FFFFFFFF"));
        assertEquals("FFFFF800", shifter.path(false,11,"FFFFFFFF"));
        assertEquals("FFFFF000", shifter.path(false,12,"FFFFFFFF"));
        assertEquals("FFFFE000", shifter.path(false,13,"FFFFFFFF"));
        assertEquals("FFFFC000", shifter.path(false,14,"FFFFFFFF"));
        assertEquals("FFFF8000", shifter.path(false,15,"FFFFFFFF"));
        assertEquals("FFFF0000", shifter.path(false,16,"FFFFFFFF"));
        assertEquals("FFFE0000", shifter.path(false,17,"FFFFFFFF"));
        assertEquals("FFFC0000", shifter.path(false,18,"FFFFFFFF"));
        assertEquals("FFF80000", shifter.path(false,19,"FFFFFFFF"));
        assertEquals("FFF00000", shifter.path(false,20,"FFFFFFFF"));
        assertEquals("FFE00000", shifter.path(false,21,"FFFFFFFF"));
        assertEquals("FFC00000", shifter.path(false,22,"FFFFFFFF"));
        assertEquals("FF800000", shifter.path(false,23,"FFFFFFFF"));
        assertEquals("FF000000", shifter.path(false,24,"FFFFFFFF"));
        assertEquals("FE000000", shifter.path(false,25,"FFFFFFFF"));
        assertEquals("FC000000", shifter.path(false,26,"FFFFFFFF"));
        assertEquals("F8000000", shifter.path(false,27,"FFFFFFFF"));
        assertEquals("F0000000", shifter.path(false,28,"FFFFFFFF"));
        assertEquals("E0000000", shifter.path(false,29,"FFFFFFFF"));
        assertEquals("C0000000", shifter.path(false,30,"FFFFFFFF"));
        assertEquals("80000000", shifter.path(false,31,"FFFFFFFF"));
        assertEquals("00000000", shifter.path(false,32,"FFFFFFFF"));
    }
}
