class Solution {
    public boolean isAnagram(String s, String t) {

        // Approach 1 :- Sort and Compare
        // Time : O(n log n) (where n = s.length).
        // Space: O(1)

        // if(s.length() != t.length()){
        //     return false;
        // }
        // char [] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();
        // Arrays.sort(sChar);
        // Arrays.sort(tChar);

        // return Arrays.equals(sChar, tChar);

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }

        for(int count : freq){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}