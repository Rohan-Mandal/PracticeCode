class Solution {
    public int maximumLength(String s) {
        int len = s.length();

        Map<Pair<Character, Integer>, Integer> map = new HashMap<>();
        int subStringLength = 0;

        for(int i = 0; i < len; i++){
            char currChar = s.charAt(i);
            subStringLength = 0;
            for(int j = i; j < len; j++){
                if(currChar == s.charAt(j)){
                    subStringLength++;
                    Pair<Character, Integer> key = new Pair<>(currChar, subStringLength);
                    map.put(key, map.getOrDefault(key , 0) + 1);
                } else{
                    break;
                }
            }
        }
        int ans = 0;
        for(Map.Entry<Pair<Character, Integer>, Integer> entry : map.entrySet()){
            int length = entry.getKey().getValue();
            if(entry.getValue() >= 3 && length > ans){
                ans = length;
            }
        }
        return ans == 0 ? -1 : ans;
    }
}