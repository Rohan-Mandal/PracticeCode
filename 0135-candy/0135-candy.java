class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candy  = n;
        int i = 1; 

        while(i < n){
            if(ratings[i] == ratings[i - 1]){
                i++;
                continue;
            }

            //Increaseing slope --> peak
            int peak = 0;
            while(ratings[i] > ratings[i -1]){
                peak++;
                candy += peak;
                i++;
                if(i == n){
                    return candy;
                }
            }

            //Decreasing slope --> dip
            int dip = 0;
            while(i < n && ratings[i] < ratings[i - 1]){
                dip++;
                candy += dip;
                i++;
            }
            candy -= Math.min(peak, dip);
        }
        return candy;
    }
}