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

}
