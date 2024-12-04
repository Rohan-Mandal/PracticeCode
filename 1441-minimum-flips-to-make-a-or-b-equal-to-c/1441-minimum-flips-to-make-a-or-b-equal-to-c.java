class Solution {
    public int minFlips(int a, int b, int c) {
        int result = ((a | b) ^ c); // flips
        
        // if both bit is 1 in a & b
        int temp = (a & b);
        int result2 = (result & temp);

        return Integer.bitCount(result) + Integer.bitCount(result2);
    }
}