class Solution {
    public int longestContinuousSubstring(String s) {
        int count = 1;
        int len = s.length();
        int max = 1;
        for(int i = 0; i < len; i++){
            if(i == len - 1){
                break;
            }
            int checkVal = ((s.charAt(i + 1) - 'a') - (s.charAt(i) - 'a'));
            if(checkVal == 1){
                max = Math.max(++count, max);
            }else{
                count = 1;
            }
        }
        return max;
    }
}