class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort folders lexicographically
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        for(String fold : folder){
            // If the result list is empty or the current folder is not a sub-folder of the last added folder
            if(result.isEmpty() || !fold.startsWith(result.get(result.size() - 1) + "/")){
                result.add(fold);
            }
        }
        return result;
    }
}