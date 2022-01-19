package calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class StringCalculatorTest {
    private StringCalculator cal;
    
    @Before
    public void setup() {
        cal = new StringCalculator();
    }
    
    @Test
    public void addNullOrBlank() {
        assertEquals(0, cal.add(""));
        assertEquals(0, cal.add(null));
    }
    
    @Test
    public void addOneNumber() {
        assertEquals(1, cal.add("1"));
        assertEquals(10, cal.add("10"));
    }
    
    @Test
    public void addComma() throws Exception {
        assertEquals(3, cal.add("1,2"));
        assertEquals(14, cal.add("10,2,2"));
    }
    
    @Test
    public void addColon() throws Exception {
        assertEquals(3, cal.add("1:2"));
        assertEquals(14, cal.add("10:2:2"));
    }
    
    @Test
    public void addCommaAndColon() throws Exception {
        assertEquals(14, cal.add("10,3:1"));
    }
    
    @Test
    public void addCustom() throws Exception {
        assertEquals(6, cal.add("//;\n1;2;3"));
        assertEquals(10, cal.add("//]\n1]2:3,4"));
    }
    
    @Test(expected = RuntimeException.class)
    public void addNegative() throws Exception {
        cal.add("-1:-2");
    }
}
