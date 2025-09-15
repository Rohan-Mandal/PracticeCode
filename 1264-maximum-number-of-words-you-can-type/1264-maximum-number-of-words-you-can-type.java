class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        String[] words = text.split(" ");
        Set<Character> brokenSet = new HashSet<>();

        for (char ch : brokenLetters.toCharArray()) {
            brokenSet.add(ch);
        }

        int count = 0;
        for (String word : words) {
            boolean canType = true;

            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) { // fast lookup
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }
        return count;
    }
}