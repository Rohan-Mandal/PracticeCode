class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1 && k == 1){
            return 0;
        }
        int len = (int)(Math.pow(2, n - 1) / 2);

        if(k <= len){
            return kthGrammar(n - 1, k);
        }else{
            int val = kthGrammar(n - 1, k - len);
            return (val == 0) ? 1 : 0;
        }
    }
}