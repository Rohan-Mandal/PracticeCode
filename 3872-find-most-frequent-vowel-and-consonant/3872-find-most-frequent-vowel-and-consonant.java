class Solution {
    public int maxFreqSum(String s) {
        int [] vowelCount = new int[26];
        int[] consonant = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelCount[ch - 'a']++;
            } else{
                consonant[ch - 'a']++;
            }
        }
        int vowelsMax = 0, consonantMax = 0;
        for(int i = 0; i < 26; i++){
            vowelsMax = Math.max(vowelsMax, vowelCount[i]);
            consonantMax = Math.max(consonantMax, consonant[i]);
        }
        return vowelsMax + consonantMax;
    }
}