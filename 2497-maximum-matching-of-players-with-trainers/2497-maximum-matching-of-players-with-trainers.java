class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int matchCount = 0;

        int i = 0, j = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) { // player mathces or can match the trainers capacity
                matchCount++;
                i++;
            }
            j++; // trainer is weak
        }
        return matchCount;
    }
}