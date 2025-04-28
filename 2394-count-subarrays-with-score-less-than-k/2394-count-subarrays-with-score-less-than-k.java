class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0;
        long count = 0;

        int i = 0, j = 0;
        while (j < n) {
            sum += nums[j];
            while (i <= j && sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }
}