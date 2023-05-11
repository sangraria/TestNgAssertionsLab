import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExampleTest {
    public int multiply (int operand1, int operand2) {
        return operand1 * operand2;
    }

    @Test
    public void testMultiplication (){
        int operand1 = 5;
        int operand2 = 3;
        int expectedProduct = 15;

        int actualProduct = multiply(operand1, operand2);
        Assert.assertEquals(actualProduct, expectedProduct, "Multiplication result is not as expected");
    }

    @Test
    public void testObjectEquality(){
        String str1 = "Hello";
        String str2 = "Hello";
        Assert.assertSame(str1, str2, "String references are not the same");}

    @Test
    public void testArrayEquality() {
        int[] expectedArray = {1,2,3};
        int[] actualArray = {1,2,3};
        Assert.assertEquals(expectedArray, actualArray, "Arrays are not equal");
    }
}