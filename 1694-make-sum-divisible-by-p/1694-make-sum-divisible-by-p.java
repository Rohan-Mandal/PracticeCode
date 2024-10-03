import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int targetRemainder = (int) (totalSum % p);
        if (targetRemainder == 0) {
            return 0; 
        }
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1);
        int prefixSum = 0;
        int minLength = nums.length;
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p; 
            prefixSum = (prefixSum + p) % p; 
            int target = (prefixSum - targetRemainder + p) % p;
            if (prefixSumMap.containsKey(target)) {
                int subarrayLength = i - prefixSumMap.get(target);
                minLength = Math.min(minLength, subarrayLength);
            }
            prefixSumMap.put(prefixSum, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}
