public class Solution {

    private int getState(int countA, int countB) {
        int parityA = countA % 2;
        int parityB = countB % 2;

        if (parityA == 0 && parityB == 0) return 0; // even-even
        if (parityA == 0 && parityB == 1) return 1; // even-odd
        if (parityA == 1 && parityB == 0) return 2; // odd-even ✅ target
        return 3; // odd-odd
    }

    public int maxDifference(String s, int k) {
        int n = s.length();
        int result = Integer.MIN_VALUE;

        for (char a = '0'; a <= '4'; a++) {
            for (char b = '0'; b <= '4'; b++) {
                if (a == b) continue;

                // For tracking the minimum diff (a - b) for each of the 4 parity states
                int[] stateMinDiff = new int[4];
                Arrays.fill(stateMinDiff, Integer.MAX_VALUE);

                int countA = 0, countB = 0;
                int prevA = 0, prevB = 0;
                int l = -1, r = 0;

                while (r < n) {
                    if (s.charAt(r) == a) countA++;
                    if (s.charAt(r) == b) countB++;

                    while ((r - l) >= k && (countB - prevB >= 2) && (countA - prevA >= 1)) {
                        int leftState = getState(prevA, prevB);
                        int diff = prevA - prevB;
                        stateMinDiff[leftState] = Math.min(stateMinDiff[leftState], diff);

                        l++;
                        if (s.charAt(l) == a) prevA++;
                        if (s.charAt(l) == b) prevB++;
                    }

                    int rightState = getState(countA, countB);
                    int bestLeftState = rightState ^ 2; // Flip parity of a only

                    if (stateMinDiff[bestLeftState] != Integer.MAX_VALUE) {
                        int currentDiff = (countA - countB) - stateMinDiff[bestLeftState];
                        result = Math.max(result, currentDiff);
                    }

                    r++;
                }
            }
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
