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
        solve(nums, index + 1, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

}