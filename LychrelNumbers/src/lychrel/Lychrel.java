package lychrel;

import java.math.BigInteger;

public class Lychrel {
    public static int convergesAtIteration(int number, int limit) {
        return converge(BigInteger.valueOf(number), 0, limit);
    }

    private static int converge(BigInteger number, int iteration, int limit) {
        if (!isPalindrome(number) && iteration < limit)
            return converge(number.add(reverse(number)), iteration + 1, limit);
        else
            return iteration;
    }

    static BigInteger reverse(BigInteger number) {
        char[] nDigits = number.toString().toCharArray();
        char[] rDigits = new char[nDigits.length];
        int lastIndex = nDigits.length - 1;

        for (int idx = 0; idx < nDigits.length; idx++)
            rDigits[idx] = nDigits[lastIndex - idx];

        return new BigInteger(new String(rDigits));
    }

    static boolean isPalindrome(BigInteger number) {
        String digits = number.toString();
        int lastIndex = digits.length() - 1;

        for (int idx = 0; idx < digits.length(); idx++)
            if (digits.charAt(idx) != digits.charAt(lastIndex - idx))
                return false;

        return true;
    }
}
