class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int k = 0; k < 32; k++){
            int onesCount = 0;
            int temp = (1 << k);
            for(int num : nums){
                if((num & temp) != 0){
                    onesCount++;
                }
            }
            if(onesCount % 3 == 1){
                result = (result | temp);
            }
        }
        return result;
    }
}