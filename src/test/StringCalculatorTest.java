package test;
import main.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
    public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("test.StringCalculatorTest");
    }

    @Test
	public void testEmptyString() {
		assertEquals("empty string input should return 0", 0, StringCalculator.Add(""));
	}
}
