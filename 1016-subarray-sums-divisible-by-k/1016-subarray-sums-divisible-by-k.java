class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        int[] remainderArray = new int[k];
        remainderArray[0] = 1;
        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            if (remainder < 0) {
                remainder += k;
            }
            count += remainderArray[remainder];
            remainderArray[remainder]++;
        }
        
        return count; 
    }
}