class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;

        for(int num : nums){
            sum += num;
            
            if(sum == k){
                count++;
            }
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
}