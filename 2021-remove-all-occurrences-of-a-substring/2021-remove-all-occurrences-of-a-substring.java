class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder stack = new StringBuilder();
        int partLen = part.length();

        for (char c : s.toCharArray()) {
            stack.append(c);

            // Check if the last `part.length()` characters match `part`
            if (stack.length() >= partLen && stack.substring(stack.length() - partLen).equals(part)) {
                stack.setLength(stack.length() - partLen); // Remove `part`
            }
        }

        return stack.toString();
    }
}