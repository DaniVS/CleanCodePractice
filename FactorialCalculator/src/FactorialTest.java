import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test(expected = NegativeNumberException.class)
    public void factorialOfNegativeThrowsException() throws NegativeNumberException, InputTooLargeException {
        Factorial.calculate(BigInteger.valueOf(-1));
    }

    @Test
    public void factorialOfZeroIsOne() throws NegativeNumberException, InputTooLargeException {
        assertEquals(BigInteger.ONE, Factorial.calculate(BigInteger.ZERO));
    }

    @Test
    public void factorialOfOneIsOne() throws NegativeNumberException, InputTooLargeException {
        assertEquals(BigInteger.ONE, Factorial.calculate(BigInteger.ONE));
    }

    @Test
    public void factorialOfTwoIsTwo() throws NegativeNumberException, InputTooLargeException {
        assertEquals(BigInteger.valueOf(2), Factorial.calculate(BigInteger.valueOf(2)));
    }

    @Test
    public void factorialOfThreeIsSix() throws NegativeNumberException, InputTooLargeException {
        assertEquals(BigInteger.valueOf(6), Factorial.calculate(BigInteger.valueOf(3)));
    }

    @Test
    public void factorialOfTwelveIsCorrect() throws NegativeNumberException, InputTooLargeException {
        assertEquals(BigInteger.valueOf(479001600), Factorial.calculate(BigInteger.valueOf(12)) );
    }
    @Test
    public void factorialOfThirteenIsCorrect() throws NegativeNumberException, InputTooLargeException {
        assertEquals(BigInteger.valueOf(6227020800L), Factorial.calculate(BigInteger.valueOf(13)));
    }

    @Test
    public void factorialOfTwenty() throws NegativeNumberException, InputTooLargeException{
        assertEquals(BigInteger.valueOf(2432902008176640000L), Factorial.calculate(BigInteger.valueOf(20)));
    }

    @Test(expected = InputTooLargeException.class)
    public void factorialOfTwentyOneShouldCrash() throws NegativeNumberException, InputTooLargeException {
        Factorial.calculate(BigInteger.valueOf(21));
    }
}
