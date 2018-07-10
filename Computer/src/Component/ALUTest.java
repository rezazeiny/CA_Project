package Component;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ALUTest {
    private ALU alu = new ALU();

    @Test
    public void pathTest() throws Exception {
        assertEquals("01234567", alu.path("011000","01234567","89ABCDEF"));
    }
}
