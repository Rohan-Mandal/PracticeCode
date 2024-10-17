class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int len = digits.length;
        int[] index = new int[10];
        for(int i = 0; i < len; i++){
            index[digits[i] - '0'] = i;
        }
        for(int i = 0; i < len; i++){
            for(int digit = 9; digit > digits[i] - '0'; digit--){
                if(index[digit] > i){
                    char temp = digits[i];
                    digits[i] = digits[index[digit]];
                    digits[index[digit]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}