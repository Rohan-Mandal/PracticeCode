class Solution {
    public int maximumLength(String s) {
        int len = s.length();

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++){
            StringBuilder currChar = new StringBuilder();
            for(int j = i; j < len; j++){
                if(currChar.length() == 0 || currChar.charAt(currChar.length() - 1) == s.charAt(j)){
                    currChar.append(s.charAt(j));
                    map.put(currChar.toString(), map.getOrDefault(currChar.toString(), 0) + 1);
                } else{
                    break;
                }
            }
        }

        int result = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String str = entry.getKey();
            int count = entry.getValue();
            if(count >= 3 && str.length() > result){
                result = str.length();
            }
        }
        return result == 0 ? -1 : result;
    }
}