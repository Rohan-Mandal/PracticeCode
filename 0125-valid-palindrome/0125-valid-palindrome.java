class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = cleaned.length();
        int i = 0, j = n - 1;
        while(i <= j){
            if(cleaned.charAt(i) != cleaned.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}