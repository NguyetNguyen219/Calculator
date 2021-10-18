import com.calculator.tool.ExtentChecker;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberTest {
    @Test
    public void checkNumberTestPositive() {
        assertTrue(ExtentChecker.checkNumberInRange(19));
        assertTrue(ExtentChecker.checkNumberInRange(-7));
        assertTrue(ExtentChecker.checkNumberInRange(-20));
        assertTrue(ExtentChecker.checkNumberInRange(20));
        assertTrue(ExtentChecker.checkNumberInRange(0));
    }
    @Test
    public void checkNumberTestNegative() {
        assertFalse(ExtentChecker.checkNumberInRange(29));
        assertFalse(ExtentChecker.checkNumberInRange(-41));
        assertFalse(ExtentChecker.checkNumberInRange(-20.5));
        assertFalse(ExtentChecker.checkNumberInRange(80));
        assertFalse(ExtentChecker.checkNumberInRange(101));
    }

}
