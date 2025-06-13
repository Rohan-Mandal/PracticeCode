class Solution {
    int n;

    public int minimizeMax(int[] nums, int p) {
        n = nums.length;
        Arrays.sort(nums);

        int result = 0;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, p, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean isValid(int[] nums, int p, int mid) {
        int i = 0;
        int pairCount = 0;
        while (i < n - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                pairCount++;
                i += 2;
            } else {
                i++;
            }
        }
        return pairCount >= p;
    }
}