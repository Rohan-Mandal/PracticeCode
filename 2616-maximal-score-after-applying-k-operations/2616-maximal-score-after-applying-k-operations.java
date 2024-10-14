class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int len = nums.length;
        for(int val : nums){
            pq.offer(val);
        }
        long score = 0;
        while(k-- > 0){
            int value = pq.poll();
            score += value;
            pq.offer((value + 2)/ 3);
         }
        return score;
    }
}