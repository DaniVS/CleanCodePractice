package lychrel;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class LychrelTest {

    private final int LIMIT = 1000;

    @Test
    public void facts(){
        convergesAtIteration(1, 0);
        convergesAtIteration(2, 0);
        convergesAtIteration(10, 1);
        convergesAtIteration(11, 0);
        convergesAtIteration(19, 2);
        convergesAtIteration(78, 4);
        convergesAtIteration(89, 24);

        doesNotConverge(196);
    }

    private void doesNotConverge(int number) {
        convergesAtIteration(number, LIMIT);
    }

    private void convergesAtIteration(int number, int iteration) {
        assertEquals(iteration, Lychrel.convergesAtIteration(number, LIMIT));
    }

    @Test
    public void palindromes(){
        isPalindrome(1);
        isPalindrome(11);
        isPalindrome(121);
        isPalindrome(12321);
        isPalindrome(1234321);
    }

    @Test
    public void notPalindromes(){
        isNotPalindrome(10);
        isNotPalindrome(12331);
        isNotPalindrome(124321);
    }

    private void isNotPalindrome(int number) {
        assertFalse(Lychrel.isPalindrome(BigInteger.valueOf(number)));
    }

    private void isPalindrome(int number){
        assertTrue(Lychrel.isPalindrome(BigInteger.valueOf(number)));
    }

    @Test
    public void reversals(){
        reversed(1,1);
        reversed(12, 21);
        reversed(13, 31);
        reversed(123, 321);
        reversed(1234, 4321);
    }

    private void reversed(int n, int r) {
        assertEquals(BigInteger.valueOf(r), Lychrel.reverse(BigInteger.valueOf(n)));
    }
}
