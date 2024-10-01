class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] result = new int[k];
        for(int element : arr){ //n
            int rem = ((element % k) + k ) % k;
            result[rem]++;
        }
        if(result[0] % 2 != 0){
            return false;
        }
        for(int rem = 1; rem <= k / 2; rem++){ //k/2
            int comp = k - rem;
            if(result[rem] != result[comp]){
                return false;
            }
        }
        return true;
    }
}