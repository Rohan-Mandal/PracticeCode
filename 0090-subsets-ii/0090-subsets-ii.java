import java.util.*;
class Solution {

    List<List<Integer>> result = new ArrayList<>();


    private void solve(int[] nums, int index, List<Integer> temp){

        if(index >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        // with element
        temp.add(nums[index]);
        solve(nums, index + 1, temp);
        //without element
        temp.remove(temp.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        solve(nums, index + 1, temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        Comparator<List<Integer>> listComparator = (list1, list2) -> {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return list1.get(i) - list2.get(i);
                }
            }
            return 0; // If all elements are equal, return 0
        };

        Collections.sort(result, listComparator);
        return result;
    }

}