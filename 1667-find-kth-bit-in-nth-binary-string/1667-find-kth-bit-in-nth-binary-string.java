class Solution {
    public char findKthBit(int n, int k) {
        // Base case: if n is 1, the sequence is just "0"
        if(n == 1){
            return '0';
        }
        int len = (1 << n) - 1; //or  Math.pow(2,n) - 1

        if(k < Math.ceil(len / 2.0)){
            return findKthBit(n - 1, k);
        } else if(k == Math.ceil(len / 2.0)){
            return '1';
        } else {
            char ch = findKthBit(n - 1, len - (k - 1));
            return (ch == '0') ? '1' : '0';
        }
    }
}
