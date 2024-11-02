class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }
        String[] words = sentence.split(" ");
        
        // Check if the last character of each word matches the first character of the next word
        for (int i = 0; i < words.length - 1; i++) {
            char lastCharOfCurrentWord = words[i].charAt(words[i].length() - 1);
            char firstCharOfNextWord = words[i + 1].charAt(0);
            if (lastCharOfCurrentWord != firstCharOfNextWord) {
                return false;
            }
        }
        // If all conditions are met, the sentence is circular
        return true;
    }
}
