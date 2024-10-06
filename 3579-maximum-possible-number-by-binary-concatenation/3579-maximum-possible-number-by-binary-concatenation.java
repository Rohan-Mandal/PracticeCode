class Solution {
    public int maxGoodNumber(int[] nums) {
        int[][] possiblePairs = new int[][]{
            {nums[0], nums[1], nums[2]},
            {nums[0], nums[2], nums[1]},
            {nums[1], nums[0], nums[2]},
            {nums[1], nums[2], nums[0]},
            {nums[2], nums[0], nums[1]},
            {nums[2], nums[1], nums[0]}
        };
        int result = Integer.MIN_VALUE;
        for(int[] pair : possiblePairs){
            int num = Integer.parseInt((toBinary(pair[0]) + toBinary(pair[1]) + toBinary(pair[2])), 2);
            result = Math.max(result, num);
        }
        return result;
    }

    private static String toBinary(int num){
        return Integer.toBinaryString(num);
    }
}