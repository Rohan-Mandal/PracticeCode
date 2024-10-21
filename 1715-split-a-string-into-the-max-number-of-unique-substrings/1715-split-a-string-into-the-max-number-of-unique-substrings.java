import java.util.*;
class Solution {
    public int maxUniqueSplit(String s) {
        return solve(s, 0, new HashSet<>());
    }

     private int solve(String s, int i, HashSet<String> set){
        if(i == s.length()){
            return 0;
        }
        int count = 0;

        // Try splitting the string starting from 'start' to each subsequent character
        for (int j = i + 1; j <= s.length(); j++) {
            String currentSubstring = s.substring(i, j);

            // If the current substring hasn't been seen yet, add it to the set and recurse
            if (!set.contains(currentSubstring)) {
                set.add(currentSubstring);

                // Recursively check the rest of the string
                count = Math.max(count, 1 + solve(s, j, set));

                // Backtrack by removing the current substring from the set
                set.remove(currentSubstring);
            }
        }
        return count;
     }
}