class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int maxNegative = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (num <= 0) {
                maxNegative = Math.max(maxNegative, num);
            } else if (!set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }
        return sum == 0 ? maxNegative : sum;
    }
}