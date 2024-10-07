class Solution {
    public int minLength(String s) {
        int n = s.length();
        
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = 1;

        while (j < n) {
            if (i < 0) {
                i++;
                sb.setCharAt(i, sb.charAt(j));
            } else if ((sb.charAt(i) == 'A' && sb.charAt(j) == 'B') ||
                       (sb.charAt(i) == 'C' && sb.charAt(j) == 'D')) {
                i--;
            } else {
                i++;
                sb.setCharAt(i, sb.charAt(j));
            }
            j++;
        }
        return i + 1;
    }
}