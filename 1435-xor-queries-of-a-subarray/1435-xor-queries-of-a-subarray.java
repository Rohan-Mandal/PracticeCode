class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = queries.length;
        int [] result = new int[len];
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int XOR = 0;
            for(int j = start; j <= end; j++){
                XOR = XOR ^ arr[j];
            }
            result[i] = XOR;
        }
        return result;
    }
}