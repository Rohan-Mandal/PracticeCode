class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr); // Sorting helps in avoiding duplicates easily
        boolean[] used = new boolean[arr.length];
        return backtrack(arr, used);
    }

    private int backtrack(char[] arr, boolean[] used) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (used[i] == true){  // Skip duplicate letters in the same recursive level
                continue;
            }
    
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]){
                continue;
            }

            used[i] = true; // do
            count += 1 + backtrack(arr, used); // Include current choice and explore further
            used[i] = false; // Backtrack or undo
        }
        return count;
    }
}
