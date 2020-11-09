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

}
