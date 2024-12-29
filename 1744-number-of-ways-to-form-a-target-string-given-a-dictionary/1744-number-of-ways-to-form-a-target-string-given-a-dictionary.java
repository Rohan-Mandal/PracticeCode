class Solution {
    public int numWays(String[] words, String target) {
        int mod = 1_000_000_007;
        int m = words[0].length();
        int n = target.length();
        
        // Precompute charCount array
        int[][] charCount = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                charCount[i][word.charAt(i) - 'a']++;
            }
        }
        
        // DP array
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: one way to form an empty target
        
        // Process columns of words
        for (int i = 0; i < m; i++) {
            for (int j = n; j > 0; j--) {
                char c = target.charAt(j - 1);
                dp[j] = (dp[j] + dp[j - 1] * charCount[i][c - 'a']) % mod;
            }
        }
        
        return (int) dp[n];
    }
}
