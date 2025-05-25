class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26]; // 676 possible 2-letter lowercase words
        int result = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';

            if (count[b][a] > 0) {
                // Pair found: (word) and its reverse already exists
                result += 4;
                count[b][a]--;
            } else {
                // Store for future pairing
                count[a][b]++;
            }
        }

        // Check for a palindromic word (like "gg") to put in the center
        for (int i = 0; i < 26; i++) {
            if (count[i][i] > 0) {
                result += 2;
                break;
            }
        }

        return result;
    }
}
