class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        
        for(int frequency : map.values()){
            if(frequency > 1){
                count += (frequency * (frequency - 1) / 2) * 8;
            }
        }
        return count;
    }
}