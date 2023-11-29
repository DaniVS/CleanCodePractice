import java.math.BigInteger;

public class Factorial {

    private static final BigInteger MAX_INPUT_VALUE = BigInteger.valueOf(20);

    public static BigInteger calculate(BigInteger input) throws NegativeNumberException, InputTooLargeException {
        BigInteger number = BigInteger.valueOf(input.longValue());

        validateOrThrow(number);

        if (number.compareTo(BigInteger.valueOf(1)) <= 0){
            return BigInteger.ONE;
        }

        BigInteger numberMinusOne = number.subtract(BigInteger.ONE);

        return number.multiply(calculate(numberMinusOne));
    }

    private static void validateOrThrow(BigInteger number) throws InputTooLargeException, NegativeNumberException {
        if (number.compareTo(MAX_INPUT_VALUE) > 0){
            throw new InputTooLargeException();
        }

        if (number.compareTo(BigInteger.valueOf(0)) < 0){
            throw new NegativeNumberException();
        }
    }
}
