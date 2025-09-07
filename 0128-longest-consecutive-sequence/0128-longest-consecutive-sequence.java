class Solution {
    public int longestConsecutive(int[] nums) {

        //Approach 1 : Sorting + two pointers
        //Time :- n(log n)
        int n = nums.length;
        if(n == 0) return 0;

        Arrays.sort(nums);

        int maxLen = 1;
        int currLen = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                continue;
            } else if(nums[i] == nums[i - 1] + 1){
                currLen++;
            } else{
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}