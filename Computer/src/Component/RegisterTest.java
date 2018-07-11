package Component;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegisterTest {
    @Test
    public void getValue() throws Exception {
        Register register = new Register("00001234");
        assertEquals("00001234",register.getValue());
    }

    @Test
    public void getValueThenInc() throws Exception {
        Register register = new Register("00001234");
        assertEquals("00001234",register.getValueThenInc());
        assertEquals("00001235",register.getValueThenInc());
        assertEquals("00001236",register.getValueThenInc());
        assertEquals("00001237",register.getValueThenInc());
        assertEquals("00001238",register.getValueThenInc());
    }

    @Test
    public void getValueThenDec() throws Exception {
        Register register = new Register("00001234");
        assertEquals("00001234",register.getValueThenDec());
        assertEquals("00001233",register.getValueThenDec());
        assertEquals("00001232",register.getValueThenDec());
        assertEquals("00001231",register.getValueThenDec());
        assertEquals("00001230",register.getValueThenDec());
    }

    @Test
    public void decThenGetValue() throws Exception {
        Register register = new Register("00001234");
        assertEquals("00001233",register.decThenGetValue());
        assertEquals("00001232",register.decThenGetValue());
        assertEquals("00001231",register.decThenGetValue());
        assertEquals("00001230",register.decThenGetValue());
    }
}
