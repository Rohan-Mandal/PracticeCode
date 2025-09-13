class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // Skip non-alphanumeric characters from the left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Skip non-alphanumeric characters from the right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare (case-insensitive)
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
