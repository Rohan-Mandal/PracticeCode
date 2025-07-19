class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder array lexicographically
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        // The first folder can never be a sub-folder after sorting
        result.add(folder[0]);
        // Iterate through the sorted folders
        for (int i = 1; i < folder.length; i++) {
            String currFolder = folder[i];
            String prevFolder = result.get(result.size() - 1);
            prevFolder += "/"; // Add '/' to the last folder to check for sub-folder

            // If the current folder does not start with the last folder, it is not a sub-folder
            if (!currFolder.startsWith(prevFolder)) {
                result.add(folder[i]);
            }
        }
        return result;
    }
}