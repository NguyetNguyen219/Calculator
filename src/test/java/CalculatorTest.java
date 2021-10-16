import com.calculator.tool.Checker;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    @Test
    public void checkNumberTest() {
        assertTrue(Checker.checkNumberInRange(9));
        assertTrue(Checker.checkNumberInRange(-7));
        assertTrue(Checker.checkNumberInRange(-20));
        assertTrue(Checker.checkNumberInRange(20));
        assertTrue(Checker.checkNumberInRange(0));
    }
}
