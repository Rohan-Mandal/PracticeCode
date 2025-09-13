class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        // Count frequencies of all letters
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int vowelsMax = 0, consonantMax = 0;

        // Check each letter
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelsMax = Math.max(vowelsMax, freq[i]);
            } else {
                consonantMax = Math.max(consonantMax, freq[i]);
            }
        }

        return vowelsMax + consonantMax;
    }
}
