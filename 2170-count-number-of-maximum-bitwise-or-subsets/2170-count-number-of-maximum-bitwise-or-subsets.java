class Solution {

    public int countMaxOrSubsets(int[] nums) {
        int maxOrValue = 0;
        for(int num : nums){
            maxOrValue |= num;
        }
        int currOrValue = 0;
        return countSubsets(0, currOrValue, maxOrValue, nums);
    }

    private int countSubsets(int index, int currOrValue, int maxOrValue, int[] nums)
    {
        if(index == nums.length){
            if(currOrValue == maxOrValue)
                return 1;
            return 0;
        }
        // take nums[index]
        int takeCount = countSubsets(index + 1, currOrValue | nums[index], maxOrValue, nums);

        //not taken nums[index]
        int notTakenCount = countSubsets(index + 1, currOrValue, maxOrValue, nums);

        return takeCount + notTakenCount;
    }
}