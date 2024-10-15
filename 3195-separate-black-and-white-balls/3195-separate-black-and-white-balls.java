class Solution {
    public long minimumSteps(String s) {
        long black = 0;
        long swap = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '1'){
                black++;
            } else if(s.charAt(i) == '0'){
                swap += black;
            }
        }
        return swap;
    }
}