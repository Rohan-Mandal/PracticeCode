class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] commonArray = new int[n];
        int[] frequency = new int[n + 1];

        int count = 0;

        for(int i = 0; i < n; i++){
            frequency[A[i]]++;
            if(frequency[A[i]] == 2){
                count += 1;
            }

            frequency[B[i]]++;
            if(frequency[B[i]] == 2){
                count += 1;
            }

            commonArray[i] = count;
        }
        return commonArray;
    }
}