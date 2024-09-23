import java.util.*;
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int len = s.length();
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] t = new int[len + 1];
        for(int i = len - 1; i >= 0; i--){
            t[i] = 1 + t[i + 1];
            for(int j = i; j < len; j++){
                String curr = s.substring(i, j + 1);
                if(set.contains(curr)){
                    t[i] = Math.min(t[i], t[j + 1]);
                }
            }
        }
        return t[0];
    }
}