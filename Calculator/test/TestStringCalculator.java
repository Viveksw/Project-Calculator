import org.junit.Assert;
import org.junit.Test;

public class TestStringCalculator {

    StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void testAdd_withEmptyString(){
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testAdd_withOneNumber(){
        int number = 12;
        Assert.assertEquals(number, stringCalculator.add("12"));
    }

    @Test
    public void testAdd_withTwoNumber(){
        int number1 = 12;
        int number2 = 14;
        int result = number1+number2;

        Assert.assertEquals(result, stringCalculator.add("12,14"));
    }

    @Test
    public void testAdd_withUnknownAmountOfNumbers(){
        Assert.assertEquals(120, stringCalculator.add("10,20,30,10,20,30"));
        Assert.assertEquals(110, stringCalculator.add("10,20,30,20,30"));
        Assert.assertEquals(60, stringCalculator.add("10,10,30,10"));
        Assert.assertEquals(80, stringCalculator.add("30,20,30"));
        Assert.assertEquals(80, stringCalculator.add("10,20,20,30"));
    }

    @Test
    public void testAdd_withUnknownAmountOfNumbersAndNewLine(){
        Assert.assertEquals(120, stringCalculator.add("10\n20,30,10,20,30"));
        Assert.assertEquals(110, stringCalculator.add("10,20,30\n20,30"));
        Assert.assertEquals(60, stringCalculator.add("10,10\n30,10"));
        Assert.assertEquals(80, stringCalculator.add("30,20\n30"));
        Assert.assertEquals(80, stringCalculator.add("10,20\n20,30"));
    }

    @Test
    public void testAdd_withDifferentDelimiters(){
        Assert.assertEquals(120, stringCalculator.add("//;\n10;20;30;10;20;30"));
        Assert.assertEquals(120, stringCalculator.add("//:\n10:20:30:10:20:30"));
        Assert.assertEquals(120, stringCalculator.add("//#\n10#20#30#10#20#30"));
        Assert.assertEquals(120, stringCalculator.add("//.\n10.20.30.10.20.30"));
    }

}
