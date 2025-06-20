class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int maxDistance = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'E') {
                x++;
            } else if (ch == 'W') {
                x--;
            } else if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            }
            int distance = Math.abs(x) + Math.abs(y);
            int stepsTillNow = i + 1;
            int wastedSteps = stepsTillNow - distance;
            int extraIncrement = Math.min(2 * k, wastedSteps);
            int possibleDistance = distance + extraIncrement;

            maxDistance = Math.max(maxDistance, possibleDistance);
        }

        return maxDistance;

    }
}