class Solution {
    public int maximumDifference(int[] nums) {
        int minElement = nums[0];
        int n = nums.length;
        int result = -1;

        for(int j = 1; j < n; j++){
            if(nums[j] > minElement){
                result = Math.max(result, nums[j] - minElement);
            } else{
                minElement = nums[j];
            }
        }
        return result;
    }
}