class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int result = 1;
        int incr = 1;
        int decr = 1;

        for(int i = 1; i <n; i++){
            if(nums[i] > nums[i - 1]){
                incr++;
                decr = 1;
                result = Math.max(result, incr);
            } else if(nums[i] < nums[i - 1]){
                decr++;
                incr = 1;
                result = Math.max(result, decr);
            } else{
                incr = 1;
                decr = 1;
            }
        }
        return result;
    }
}