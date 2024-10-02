class Solution {
    public int countVowelStrings(int n) {
        return binomialCoefficient(n + 4, 4);
    }

    private int binomialCoefficient(int n, int k) {
        long res = 1;
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return (int) res;
    }
}

