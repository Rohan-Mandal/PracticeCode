class Solution {
    public int maxSum(int[] nums) {
        int[] unique = new int[101];

        Arrays.fill(unique, -1);
        int maxNegative = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            if(num <= 0){
                maxNegative = Math.max(maxNegative, num);
            } else if(unique[num] == -1){
                sum += num;
                unique[num] = 1;
            }
        }
        return sum == 0 ? maxNegative : sum;
    }
}