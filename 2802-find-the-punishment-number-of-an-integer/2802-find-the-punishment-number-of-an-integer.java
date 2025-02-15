class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String s = String.valueOf(square);
            if (partition(s, 0, i, 0)) {
                sum += square;
            }
        }
        
        return sum;
    }
    
    private boolean partition(String s, int index, int target, int currentSum) {
        if (index == s.length()) {
            return currentSum == target;
        }
        
        int num = 0;
        for (int j = index; j < s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0');
            if (num + currentSum > target) {
                break;
            }
            if (partition(s, j + 1, target, currentSum + num)) {
                return true;
            }
        }
        
        return false;
    }
}
