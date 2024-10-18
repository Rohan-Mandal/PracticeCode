class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int len = nums.length;
        int i = 1;
        while(i < len){
            if(nums[i - 1] != nums[i]){
                nums[k] = nums[i];
                k++;
            }
            i++;
        }
        return k;
    }
}
