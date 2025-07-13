class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int matchCount = 0;

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) { // player mathces or can match the trainers capacity
                matchCount++;
                i++;
            }
            j++; // trainer is weak
        }
        return matchCount;
    }
}