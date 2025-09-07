class Solution {
    public int longestConsecutive(int[] nums) {

        //Approach 1 : Sorting + two pointers
        //Time :- n(log n)
        // int n = nums.length;
        // if(n == 0) return 0;

        // Arrays.sort(nums);

        // int maxLen = 1;
        // int currLen = 1;

        // for(int i = 1; i < n; i++){
        //     if(nums[i] == nums[i - 1]){
        //         continue;
        //     } else if(nums[i] == nums[i - 1] + 1){
        //         currLen++;
        //     } else{
        //         currLen = 1;
        //     }
        //     maxLen = Math.max(maxLen, currLen);
        // }
        // return maxLen;

        // Approach 2: using HashSet
        // Time :O(n)

        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int streak = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    streak++;
                }
                maxLen = Math.max(maxLen, streak);
            }
        }
        return maxLen;
    }
}