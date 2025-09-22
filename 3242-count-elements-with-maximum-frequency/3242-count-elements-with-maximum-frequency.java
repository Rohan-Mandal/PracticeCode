class Solution {
    public int maxFrequencyElements(int[] nums) {
        int [] freq = new int[101];
        int totalFreqCount = 0;

        for(int num : nums){
            freq[num]++;
        }

        int maxFreq = 0;
        for(int i = 0; i < freq.length; i++){
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        for(int i = 0; i < freq.length; i++){
            if(freq[i] == maxFreq){
                totalFreqCount += maxFreq;
            }
        }
        return totalFreqCount;
    }
}