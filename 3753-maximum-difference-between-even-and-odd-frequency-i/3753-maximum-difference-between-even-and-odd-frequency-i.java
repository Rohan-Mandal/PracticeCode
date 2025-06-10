class Solution {
    public int maxDifference(String s) {
        int[] frequency = new int[26];
        for(char ch : s.toCharArray()){
            frequency[ch - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int freq : frequency){
            if(freq == 0){
                continue;
            }
            if(freq % 2 == 1){
                maxOdd = Math.max(maxOdd, freq);
            } else{
                minEven = Math.min(minEven, freq);
            }
        }
        return maxOdd - minEven;
    }
}