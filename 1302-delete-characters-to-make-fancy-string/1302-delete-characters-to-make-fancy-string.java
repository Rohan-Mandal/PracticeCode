class Solution {
    public String makeFancyString(String s) {
        char[] result = new char[s.length()];
        int length = 0;  // Tracks current length of the valid fancy string

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // Check if adding `current` would create three consecutive identical characters
            if (length >= 2 && result[length - 1] == current && result[length - 2] == current) {
                continue;  // Skip this character
            }
            
            // Otherwise, add `current` to the result array
            result[length] = current;
            length++;
        }
        
        // Convert the result array to a string based on the valid length
        return new String(result, 0, length);
    }
}