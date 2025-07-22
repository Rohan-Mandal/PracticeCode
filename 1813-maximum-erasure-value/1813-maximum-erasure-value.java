class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0, maxSum = 0;

        Set<Integer> set = new HashSet<>();

        while(j < n){
            if(!set.contains(nums[j])){
                sum += nums[j];
                set.add(nums[j]);
                maxSum = Math.max(maxSum, sum);
                j++;
            } else{
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        return maxSum;
    }
}