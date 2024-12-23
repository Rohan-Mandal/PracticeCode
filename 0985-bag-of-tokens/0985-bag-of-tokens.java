class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int score = 0, maxScore = 0;
        int i = 0, j = n - 1;

        Arrays.sort(tokens);

        while(i <= j){
            if(power >= tokens[i]){
                score += 1;
                maxScore = Math.max(maxScore, score);
                power -= tokens[i];
                i++;
            } else if(score >= 1){
                score -= 1;
                power += tokens[j];
                j--;
            } else{
                return maxScore;
            }
        }
        return maxScore;
    }
}