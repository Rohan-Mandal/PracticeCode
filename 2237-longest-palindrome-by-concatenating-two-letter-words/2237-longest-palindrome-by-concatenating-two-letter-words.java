class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reversed, 0) > 0) {
                result += 4;  // each pair adds 4 characters
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // check if there is a word like "gg" that can be used in the middle
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();
            if (word.charAt(0) == word.charAt(1) && count > 0) {
                hasMiddle = true;
                break;
            }
        }

        if (hasMiddle) result += 2; // add 1 self-palindrome word in center

        return result;
    }
}
