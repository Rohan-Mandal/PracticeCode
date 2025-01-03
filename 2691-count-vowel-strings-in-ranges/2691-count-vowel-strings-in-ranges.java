class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int q = queries.length;

        int[] result = new int[q];
        int[] cumSum = new int[n];

        // Define a set of vowels for quick lookup
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                sum++;
            }
            cumSum[i] = sum;
        }

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = cumSum[r] - (l > 0 ? cumSum[l - 1] : 0);
        }
        return result;
    }
}
