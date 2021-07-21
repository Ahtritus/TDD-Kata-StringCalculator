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

    @Test
    public void testOneNumber() {
        assertEquals("one number input should return that number", 6, StringCalculator.Add("6"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals("two numbers input should return sum of those numbers", 5, StringCalculator.Add("3,2"));
    }
}
