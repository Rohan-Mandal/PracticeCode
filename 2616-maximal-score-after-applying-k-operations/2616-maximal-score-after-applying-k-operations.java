class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int len = nums.length;
        for(int val : nums){
            pq.offer(val);
        }
        long score = 0;
        while(k > 0){
            int value = pq.poll();
            score += value;
            pq.offer((int) Math.ceil(value / 3.0));
            k--;
        }
        return score;
    }
}