import com.calculator.tool.NumberChecker;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberTest {
    @Test
    public void checkNumberTestPositive() {
        assertTrue(NumberChecker.checkNumberInRange(19));
        assertTrue(NumberChecker.checkNumberInRange(-7));
        assertTrue(NumberChecker.checkNumberInRange(-20));
        assertTrue(NumberChecker.checkNumberInRange(20));
        assertTrue(NumberChecker.checkNumberInRange(0));
    }
    @Test
    public void checkNumberTestNegative() {
        assertFalse(NumberChecker.checkNumberInRange(29));
        assertFalse(NumberChecker.checkNumberInRange(-41));
        assertFalse(NumberChecker.checkNumberInRange(-20.5));
        assertFalse(NumberChecker.checkNumberInRange(80));
        assertFalse(NumberChecker.checkNumberInRange(101));
    }

}
