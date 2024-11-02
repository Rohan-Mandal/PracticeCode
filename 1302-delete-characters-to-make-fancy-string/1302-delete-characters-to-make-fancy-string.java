class Solution {
    public String makeFancyString(String s) {
        char[] result = new char[s.length()];
        int consecutiveLength = 0;

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(consecutiveLength >= 2 && result[consecutiveLength - 1] == currChar && result[consecutiveLength - 2] == currChar){
                continue;
            }
            result[consecutiveLength] = currChar;
            consecutiveLength++;
        }
        return new String(result, 0, consecutiveLength);
    }
}