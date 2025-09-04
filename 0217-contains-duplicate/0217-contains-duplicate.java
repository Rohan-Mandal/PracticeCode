class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) { // add returns false if already exists
                return true;
            }
        }
        return false;
    }
}
