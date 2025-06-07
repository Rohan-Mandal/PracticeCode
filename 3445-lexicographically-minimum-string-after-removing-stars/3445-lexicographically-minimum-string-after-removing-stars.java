class Solution {
    public String clearStars(String s) {
        List<Character> stack = new ArrayList<>();
        TreeMap<Character, Deque<Integer>> charMap = new TreeMap<>();

        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                stack.add(ch);
                charMap.putIfAbsent(ch, new ArrayDeque<>());
                charMap.get(ch).addLast(stack.size() - 1); // store index
            } else {
                // Remove the smallest character seen so far
                char minChar = charMap.firstKey(); // get smallest char
                int indexToRemove = charMap.get(minChar).pollLast(); // remove latest occurrence

                stack.set(indexToRemove, null); // mark for removal

                // Clean up the map
                if (charMap.get(minChar).isEmpty()) {
                    charMap.remove(minChar);
                }
            }
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (Character ch : stack) {
            if (ch != null) result.append(ch);
        }

        return result.toString();
    }
}
