import java.util.*;
class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long sum = 0; 
        int nextHeight = maximumHeight[maximumHeight.length - 1];
        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            if (nextHeight > maximumHeight[i]) {
                nextHeight = maximumHeight[i];
            }
            if (nextHeight <= 0) {
                return -1;
            }
            sum += nextHeight;
            nextHeight--;
        }
        return sum;
    }
}