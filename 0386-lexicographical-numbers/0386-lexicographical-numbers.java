class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int startNum = 1; startNum <= 9; startNum++){
            solve(startNum, n, result);
        }
        return result;
    }

    private void solve(int currNum, int n, List<Integer> result){
        if(currNum > n){
            return;
        }
        result.add(currNum);
        for(int appendDigit = 0; appendDigit <= 9; appendDigit++){
            int nextNum = (currNum * 10) + appendDigit;
            if(nextNum > n){
                return;
            }
            solve(nextNum, n, result);
        }
    }
}