class Solution {
    public int numTilePossibilities(String tiles) {
        // Count frequency of each letter
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        return backtrack(freqMap);
    }

    private int backtrack(Map<Character, Integer> freqMap) {
        int count = 0;
        for (char c : freqMap.keySet()) {
            if (freqMap.get(c) == 0) continue; // Skip if letter is unavailable
            
            // Use this letter
            freqMap.put(c, freqMap.get(c) - 1);
            count += 1 + backtrack(freqMap); // Include current choice and explore
            
            // Backtrack (restore frequency)
            freqMap.put(c, freqMap.get(c) + 1);
        }
        return count;
    }
}
