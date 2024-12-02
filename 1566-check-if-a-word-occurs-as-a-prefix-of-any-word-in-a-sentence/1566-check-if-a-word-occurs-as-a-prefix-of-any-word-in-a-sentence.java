class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] word = sentence.split(" ");
        for(int i = 0; i < word.length; i++){
            if(isPrefix(word[i], searchWord)){
                return i + 1;
            }
        }
        return -1;
    }

    private boolean isPrefix(String word, String search){
        int len = search.length();
        if(len > word.length()){
            return false;
        }
        for(int i  = 0; i < len; i++){
            if(word.charAt(i) != search.charAt(i)){
                return false;
            }
        }
        return true;
    }
}