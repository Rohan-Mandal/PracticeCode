import java.util.*;

class Solution {

    private void solve(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            // Convert array to a List of integers and add to result
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            solve(index + 1, nums, result);
            swap(nums, i, index);  // backtrack
        }
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, result);
        return result;
    }
}
