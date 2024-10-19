class Solution {
    public int kthGrammar(int n, int k) {

        // if n & k == 1 return
        if(n == 1 && k == 1){
            return 0;
        }

        // for n = 2^n
        int len = (int)(Math.pow(2, n - 1) / 2);

        if(k <= len){
            return kthGrammar(n - 1, k); // if k <= len, anser lies in the previous answer
        }else{
            int val = kthGrammar(n - 1, k - len); // if k > len, then (mid + 1)th element is reverse of 1st element, 
            return (val == 0) ? 1 : 0;           //(mid + 2)th element is reverse of 2nd element and so on.
        }
    }
}