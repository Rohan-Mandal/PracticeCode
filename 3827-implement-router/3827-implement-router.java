class Router {
    private int memoryLimit;
    private Deque<int[]> queue;  // FIFO
    private Set<String> seen;    // to detect duplicates
    private Map<Integer, List<Integer>> destMap; // dest -> timestamps list

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) {
            return false; // duplicate
        }

        // If memory full -> remove oldest
        if (queue.size() == memoryLimit) {
            int[] oldest = queue.poll();
            String oldKey = oldest[0] + "#" + oldest[1] + "#" + oldest[2];
            seen.remove(oldKey);

            // Remove from destination map
            List<Integer> lst = destMap.get(oldest[1]);
            lst.remove(0); // oldest timestamp always at front
        }

        // Add new packet
        queue.offer(new int[]{source, destination, timestamp});
        seen.add(key);

        // Add to destMap
        destMap.putIfAbsent(destination, new ArrayList<>());
        destMap.get(destination).add(timestamp); // timestamps always increasing

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};

        int[] pkt = queue.poll();
        String key = pkt[0] + "#" + pkt[1] + "#" + pkt[2];
        seen.remove(key);

        // Remove from destination map
        List<Integer> lst = destMap.get(pkt[1]);
        if (lst != null && !lst.isEmpty()) {
            lst.remove(0); // remove earliest timestamp for that destination
            if (lst.isEmpty()) destMap.remove(pkt[1]);
        }

        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        List<Integer> lst = destMap.get(destination);

        // binary search for range
        int left = lowerBound(lst, startTime);
        int right = upperBound(lst, endTime);

        return Math.max(0, right - left);
    }

    // first index >= target
    private int lowerBound(List<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // first index > target
    private int upperBound(List<Integer> arr, int target) {
        int lo = 0, hi = arr.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr.get(mid) > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */