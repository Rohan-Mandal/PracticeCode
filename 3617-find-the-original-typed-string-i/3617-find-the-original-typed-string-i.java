class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int result = 0;
        for(int i = 1; i < n; i++){
            if(word.charAt(i) == word.charAt(i - 1)){
                result++;
            }
        }
        return result + 1;
    }
}