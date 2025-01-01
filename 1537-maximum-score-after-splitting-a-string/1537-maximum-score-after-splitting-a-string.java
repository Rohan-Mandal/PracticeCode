class Solution {
    public int maxScore(String s) {
        int n = s.length();
        
        // Calculate the total number of 1's in the string
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }
        
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = totalOnes;

        // Iterate through the string to calculate the maximum score
        // We stop at `n-1` because both substrings must be non-empty
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            // Calculate the score at the current split
            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}