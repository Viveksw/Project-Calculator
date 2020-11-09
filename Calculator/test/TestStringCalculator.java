import org.junit.Assert;
import org.junit.Test;

public class TestStringCalculator {

    StringCalculator stringCalculator = new StringCalculator();
    @Test
    public void testAdd_withEmptyString(){
        Assert.assertEquals(0, stringCalculator.add(""));
    }
}
