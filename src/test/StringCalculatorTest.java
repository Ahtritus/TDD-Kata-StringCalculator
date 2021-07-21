package test;
import main.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
	public void testEmptyString() {
		assertEquals("empty string input should return 0", 0, StringCalculator.Add(""));
	}

    @Test
    public void testOneNumber() {
        assertEquals("one number input should return that number", 5, StringCalculator.Add("5"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals("two numbers input should return sum of those numbers", 5, StringCalculator.Add("3,2"));
    }

    @Test
    public void testNewLine() {
        assertEquals("new line input should return sum of those numbers", 9, StringCalculator.Add("3\n2,4"));
    }

    @Test
    public void testDifferentDelimiter() {
        assertEquals("different delimiter input should return sum of those numbers", 9, StringCalculator.Add("//;\n3;2,4"));
    }

    @Test
    public void testNegativeNumver(){
        try {
                StringCalculator.Add("-1,2");
            } catch (IllegalArgumentException e){
                assertEquals(e.getMessage(), "Negatives not allowed: -1");
            }

        try {
                StringCalculator.Add("//;\n-3;2,-4");
            } catch (IllegalArgumentException e){
                assertEquals(e.getMessage(), "Negatives not allowed: -3,-4");
            }
        
        try {
                StringCalculator.Add("-1,-2,-3");
            } catch (IllegalArgumentException e){
                assertEquals(e.getMessage(), "Negatives not allowed: -1,-2,-3");
            }
    }

    @Test
    public void testNumberOverThousand(){
        assertEquals("Numbers bigger than 1000 are ignored", 2, StringCalculator.Add("1001,2"));
    }

    @Test
    public void testAnyLengthDelimiter(){
        assertEquals("Delimiters can be of any length", 9, StringCalculator.Add("//[***]\n3***2***4"));
    }

    @Test
    public void testMultipleDelimiters() {
        assertEquals("Multiple delimiters are allowed", 21, StringCalculator.Add("//[*][;][!]//;\n1*2;3!4\n5,6"));
    }

    @Test
    public void testMultipleDelimitersOfAnyLength() {
        assertEquals("Multiple delimiters are allowed and they can be of any length", 21, StringCalculator.Add("//[**][;;;][%%]//;;;\n1**2;;;3%%4\n5,6"));
    }
}
