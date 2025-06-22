class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groupCount = (n + k - 1) / k;
        String[] result = new String[groupCount];

        int index = 0;
        for(int i = 0; i < n; i += k){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < k; j++){
                if(i + j < n){
                    sb.append(s.charAt(i + j));
                } else{
                    sb.append(fill);
                }
            }
            result[index++] = sb.toString();
        }
        return result;
    }
}