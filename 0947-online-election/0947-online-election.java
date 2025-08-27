class TopVotedCandidate {
    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        this.times = times;
        this.leaders = new int[n];
        
        Map<Integer, Integer> voteCount= new HashMap<>();
        int leader = -1;   // current leader
        int maxVotes = 0;  // leader's vote count

        for(int i = 0; i < n; i++){
            int p = persons[i];
            voteCount.put(p, voteCount.getOrDefault(p, 0) + 1);

            // Update Leader
            if(voteCount.get(p) >= maxVotes){
                leader = p;
                maxVotes = voteCount.get(p);
            }
            leaders[i] = leader; // store leader at this time
        }
    }
    
    public int q(int t) {
        // Binary search to find rightmost index where times[i] <= t
        int low = 0, high = times.length - 1;
        while(low < high){
            int mid = low + (high - low + 1) / 2;
            if(times[mid] <= t){
                low = mid;
            } else{
                high = mid - 1;
            }
        }
        return leaders[low];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */