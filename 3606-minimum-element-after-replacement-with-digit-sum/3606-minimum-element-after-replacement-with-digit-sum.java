class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            nums[i] = sumOfDigits(nums[i]);
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    private int sumOfDigits(int val){
        int sum = 0;
        while(val != 0){
            int remainder = val % 10;
            sum = sum + remainder;
            val /= 10;
        }
        return sum;
    }
}