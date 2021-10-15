import com.tool.NumberChecker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    @Test
    public void checkNumberTest() {
        assertTrue(NumberChecker.checkNumber(9));
        assertTrue(NumberChecker.checkNumber(-7));
        assertTrue(NumberChecker.checkNumber(-20));
        assertTrue(NumberChecker.checkNumber(20));
        assertTrue(NumberChecker.checkNumber(0));
    }
}
