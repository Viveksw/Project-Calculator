import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestStringCalculator {

    StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void test_add_withEmptyString(){
        try {
            Assert.assertEquals(0, stringCalculator.add(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_add_withOneNumber(){
        int number = 12;
        try {
            Assert.assertEquals(number, stringCalculator.add("12"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_add_withTwoNumber(){
        int number1 = 12;
        int number2 = 14;
        int result = number1+number2;

        try {
            Assert.assertEquals(result, stringCalculator.add("12,14"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_add_withUnknownAmountOfNumbers(){
        try {
            Assert.assertEquals(120, stringCalculator.add("10,20,30,10,20,30"));
            Assert.assertEquals(110, stringCalculator.add("10,20,30,20,30"));
            Assert.assertEquals(60, stringCalculator.add("10,10,30,10"));
            Assert.assertEquals(80, stringCalculator.add("30,20,30"));
            Assert.assertEquals(80, stringCalculator.add("10,20,20,30"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_add_withUnknownAmountOfNumbersAndNewLine(){
        try {
            Assert.assertEquals(120, stringCalculator.add("10\n20,30,10,20,30"));
            Assert.assertEquals(110, stringCalculator.add("10,20,30\n20,30"));
            Assert.assertEquals(60, stringCalculator.add("10,10\n30,10"));
            Assert.assertEquals(80, stringCalculator.add("30,20\n30"));
            Assert.assertEquals(80, stringCalculator.add("10,20\n20,30"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_add_withDifferentDelimiters(){
        try {
            Assert.assertEquals(120, stringCalculator.add("//;\n10;20;30;10;20;30"));
            Assert.assertEquals(120, stringCalculator.add("//:\n10:20:30:10:20:30"));
            Assert.assertEquals(120, stringCalculator.add("//#\n10#20#30#10#20#30"));
            Assert.assertEquals(120, stringCalculator.add("//.\n10.20.30.10.20.30"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_add_withNegativeNumber(){
        ExpectedException exceptionRule = ExpectedException.none();
        int number = -10;
        try {
            exceptionRule.expect(Exception.class);
            exceptionRule.expectMessage("negatives not allowed:"+number);
            stringCalculator.add("-10");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_add_withMultipleNegativeNumbers(){
        ExpectedException exceptionRule = ExpectedException.none();
        int number = -10;
        try {
            exceptionRule.expect(Exception.class);
            exceptionRule.expectMessage("negatives not allowed:"+number);
            stringCalculator.add("10,-20,30,-10,20,30");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_getCalledCount(){
        stringCalculator.resetCalledCount();
        try {
            stringCalculator.add("10,20,30,10,20,30");
            stringCalculator.add("10,20,30,20,30");
            stringCalculator.add("10,10,30,10");
            stringCalculator.add("30,20,30");
            stringCalculator.add("10,20,20,30");
            Assert.assertEquals(5, stringCalculator.getCalledCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
