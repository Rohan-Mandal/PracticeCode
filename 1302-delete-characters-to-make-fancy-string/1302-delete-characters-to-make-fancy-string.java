class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // Check if the last two characters in the result are the same as the current character
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == current && result.charAt(len - 2) == current) {
                continue;  // Skip adding current character
            }
            
            result.append(current);
        }
        
        return result.toString();
    }
}