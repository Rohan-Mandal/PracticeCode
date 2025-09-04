class Solution {
    public int findClosest(int x, int y, int z) {
        int stepCountX = Math.abs(z - x);
        int stepCountY = Math.abs(z - y);
        if(stepCountX < stepCountY){
            return 1;
        } else if(stepCountY < stepCountX){
            return 2;
        }
        return 0;
    }
}