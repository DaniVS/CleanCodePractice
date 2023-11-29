public class ReplaceChars {
    public static String replaceNth(String text, int n, char oldValue, char newValue) {

        if (n <= 0) {
            return text;
        }

        char[] chars = text.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int idx = 0; idx < text.length(); idx++) {
            char actual = chars[idx];

            if (isAMatch(oldValue, actual)) {
                count++;
            }

            if (!isAMatch(oldValue, actual) || !isASubstitution(n, count)) {
                result.append(actual);
            }

            if (isAMatch(oldValue, actual) && isASubstitution(n, count)) {
                result.append(newValue);
                count = 0;
            }
        }

        return result.toString();
    }

    private static boolean isASubstitution(int n, int count) {
        return count == n;
    }

    private static boolean isAMatch(char oldValue, char actual) {
        return isASubstitution(oldValue, actual);
    }
}
