class Solution {
    public int longestContinuousSubstring(String s) {
        int count = 1;
        int len = s.length();
        int max = 1;
        char prevChar = s.charAt(0);
        for(int i = 1; i < len; i++){
            char currChar = s.charAt(i);
            if(prevChar + 1 == currChar){
                max = Math.max(++count, max);
            }else{
                count = 1;
            }
            prevChar = currChar;
        }
        return max;
    }
}