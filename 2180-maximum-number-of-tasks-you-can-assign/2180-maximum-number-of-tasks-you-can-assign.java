class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int left = 1, right = Math.min(m, n), ans = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(check(tasks, workers, pills, strength, mid)){
                ans = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid){
        int p = pills;
        int n = workers.length;
        TreeMap<Integer, Integer> workersMap = new TreeMap<>();
        for(int i = n - mid; i < n; ++i){
            workersMap.put(workers[i], workersMap.getOrDefault(workers[i], 0) + 1);
        }

        for(int i = mid - 1; i >= 0; --i){
            Integer key = workersMap.lastKey();
            if(key >= tasks[i]){
                workersMap.put(key, workersMap.get(key) - 1);
                if(workersMap.get(key) == 0){
                    workersMap.remove(key);
                }
            } else{
                if(p == 0){
                    return false;
                }
                key = workersMap.ceilingKey(tasks[i] - strength);
                if(key == null){
                    return false;
                }
                workersMap.put(key, workersMap.get(key) - 1);
                if(workersMap.get(key) == 0){
                    workersMap.remove(key);
                }
                --p;
            }
        }
        return true;
    }
}