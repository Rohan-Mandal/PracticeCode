class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();

        long countMax = 0;
        long result = 0;
        int i = 0, j = 0;

        while(j < n){
            if(nums[j] == max){
                countMax++;
            }
            while(countMax >= k){
                result += n - j;
                if(nums[i] == max){
                    countMax--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
}