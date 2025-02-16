class Solution {
    public int[] constructDistancedSequence(int n) {
        int len = 2 * (n - 1) + 1;
        int[] result = new int[len];
        boolean[] used = new boolean[n + 1]; // Track used numbers
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        // Skip already filled positions
        while (index < result.length && result[index] != 0) {
            index++;
        }
        if (index == result.length) return true; // All filled

        // Try placing numbers from n to 1
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;

            // Place number num at index and index + num (if possible)
            if (num == 1) {
                result[index] = num;
                used[num] = true;
                if (backtrack(result, used, index + 1, n)) return true;
                result[index] = 0;
                used[num] = false;
            } else {
                int secondPos = index + num;
                if (secondPos < result.length && result[secondPos] == 0) {
                    result[index] = result[secondPos] = num;
                    used[num] = true;
                    if (backtrack(result, used, index + 1, n)) return true;
                    result[index] = result[secondPos] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
    }
}
