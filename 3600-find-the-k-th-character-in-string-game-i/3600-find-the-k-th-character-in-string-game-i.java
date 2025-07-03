class Solution {

    private String nextWordChar(String word){
        StringBuilder newWord = new StringBuilder();
        for(char ch : word.toCharArray()){
            if(ch == 'z'){
                newWord.append('a');
            } else{
                newWord.append((char)(ch + 1));
            }
        }
        return newWord.toString();
    }
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        while(word.length() < k){
            String nextWord = nextWordChar(word.toString());
            word.append(nextWord);
        }
        return word.charAt(k - 1);
    }
}