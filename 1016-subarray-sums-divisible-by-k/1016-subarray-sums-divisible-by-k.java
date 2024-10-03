class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int sum = 0, count = 0;
        remainderMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int remainder = sum % k;
            if(remainder < 0){
                remainder += k;
            }

            if(remainderMap.containsKey(remainder)){
                count += remainderMap.get(remainder);
            }
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }
        return count;   
    }
}