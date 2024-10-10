class Solution {
    public int maxWidthRamp(int[] nums) {
        int rampValue = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= min){
                continue;
            }
            min = nums[i];
            for(int j = nums.length - 1; j > i; j--){
                if(nums[i] <= nums[j]){
                    rampValue = Math.max(rampValue, j - i);
                    break;
                }
            }
            if(rampValue > nums.length - i){
                break;
            }
        }
        return rampValue;
    }
}