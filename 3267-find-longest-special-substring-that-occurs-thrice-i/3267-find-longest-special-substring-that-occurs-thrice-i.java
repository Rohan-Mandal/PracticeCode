class Solution {
    public int maximumLength(String s) {
        int len = s.length();
        if (len == 0) return -1; // Handle edge case for empty string.

        int[][] matrix = new int[26][len + 1]; // Extend size to len + 1.
        char prevChar = s.charAt(0);
        int length = 0;

        // Populate the matrix with counts of consecutive character lengths.
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i);
            if (currChar == prevChar) {
                length++;
                length = Math.min(length, len); // Prevent length from exceeding len.
                matrix[currChar - 'a'][length]++;
            } else {
                length = 1;
                matrix[currChar - 'a'][length]++;
                prevChar = currChar;
            }
        }

        int result = 0;

        // Find the maximum length where cumulative count >= 3.
        for (int row = 0; row < 26; row++) {
            int cumSum = 0;
            for (int col = len; col >= 1; col--) {
                cumSum += matrix[row][col];
                if (cumSum >= 3) {
                    result = Math.max(result, col);
                    break;
                }
            }
        }

        return result == 0 ? -1 : result;
    }
}
