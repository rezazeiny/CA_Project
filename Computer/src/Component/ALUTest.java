package Component;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ALUTest {
    private ALU alu = new ALU();

    @Test
    public void pathTest() throws Exception {
        //011000 return input1
        assertEquals("01234567", alu.path("011000", "01234567", "89ABCDEF"));
        //010100 return input2
        assertEquals("89ABCDEF", alu.path("010100", "01234567", "89ABCDEF"));
        //011010 return ~input1
        assertEquals("FEDCBA98", alu.path("011010", "01234567", "89ABCDEF"));
        //101100 return ~input2
        assertEquals("76543210", alu.path("101100", "01234567", "89ABCDEF"));
        //111100 return input1 + input2
        assertEquals("8ACF1356", alu.path("111100", "01234567", "89ABCDEF"));
        //111101 return input1 + input2 + 1
        assertEquals("8ACF1357", alu.path("111101", "01234567", "89ABCDEF"));
        //111001 return input1 + 1
        assertEquals("01234568", alu.path("111001", "01234567", "89ABCDEF"));
        //110101 return input2 + 1
        assertEquals("89ABCDF0", alu.path("110101", "01234567", "89ABCDEF"));
        //111111 return input2 - input1
        assertEquals("88888888", alu.path("111111", "01234567", "89ABCDEF"));
        //110110 return input2 - 1
        assertEquals("89ABCDEE", alu.path("110110", "01234567", "89ABCDEF"));
        //111011 return  -input1
        assertEquals("FEDCBA99", alu.path("111011", "01234567", "89ABCDEF"));
        //001100 return input2 AND input1
        assertEquals("01234567", alu.path("001100", "01234567", "89ABCDEF"));
        //011100 return input2 OR input1
        assertEquals("89ABCDEF", alu.path("011100", "01234567", "89ABCDEF"));
        //010000 return 0
        assertEquals("00000000", alu.path("010000", "01234567", "89ABCDEF"));
        //110001 return 1
        assertEquals("00000001", alu.path("110001", "01234567", "89ABCDEF"));
        //110010 return -1
        assertEquals("FFFFFFFF", alu.path("110010", "01234567", "89ABCDEF"));
    }
}
