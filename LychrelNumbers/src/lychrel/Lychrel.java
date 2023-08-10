package lychrel;

public class Lychrel {
    public static int convergesAtIteration(int number, int limit) {
        if (isPalindrome(number)) return 0;
        else return 1;
    }

    private static boolean isPalindrome(int number) {
        if(number <= 9) return true;

        return false;
    }
}
