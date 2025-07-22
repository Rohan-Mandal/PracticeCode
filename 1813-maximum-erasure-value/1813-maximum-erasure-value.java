class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0;

        int[] set = new int[10001]; // since nums[i] <= 10^4

        int sum = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int cur = nums[right];
            sum += cur;
            set[cur]++;
            while (set[cur] > 1) { // if the frequency of the element is > 1,
                sum -= nums[left]; // we subtract it from sum
                set[nums[left]]--; // decrease the frequency
                left++;           // move the pointer to right
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}