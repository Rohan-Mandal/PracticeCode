class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            int j = (i + k - 1 >= n) ? n - 1 : (i + k - 1);
            String temp = s.substring(i, j + 1);

            if ((j - i + 1) < k) {
                int remain = k - (j - i + 1);
                StringBuilder tempBuilder = new StringBuilder(temp);
                for (int x = 0; x < remain; x++) {
                    tempBuilder.append(fill);
                }
                temp = tempBuilder.toString();
            }

            result.add(temp);
            i += k;
        }

        return result.toArray(new String[0]);
    }
}
