class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        // Appraoch 1
        // String[] words = text.split(" ");
        // int count = 0;
        // for(String word : words){
        //     boolean canType = true;

        //     for(char ch : brokenLetters.toCharArray()){
        //         if(word.indexOf(ch) != -1){
        //             canType = false;
        //             break;
        //         }
        //     }
        //     if(canType){
        //         count++;
        //     }
        // }
        // return count;

        // Approach 2
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