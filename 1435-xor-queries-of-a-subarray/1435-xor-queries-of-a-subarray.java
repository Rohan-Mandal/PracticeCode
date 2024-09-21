class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] prefixSumArray = new int[len];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            result[i] = prefixSumArray[R] ^ (L == 0 ? 0 : prefixSumArray[L - 1]);
        }
        return result;
    }
}