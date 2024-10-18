class Solution {

    private List<List<Integer>> generateSubsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int num : nums){
            int size = subsets.size();
            for(int i = 0; i < size; i++){
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }
        return subsets;
    }

    private int calculateBitwiseOr(List<Integer> subset){
        int orValue = 0;
        for(int num : subset){
            orValue |= num;
        }
        return orValue;
    }

    private int findMaxOrValue(int[] nums){
        List<List<Integer>> subsets = generateSubsets(nums);
        int maxOrValue = 0;
        for(List<Integer> subset : subsets){
            if(!subset.isEmpty()){
                int currentValue = calculateBitwiseOr(subset);
                maxOrValue = Math.max(maxOrValue, currentValue);
            }
        }
        return maxOrValue;
    }
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> subsets = generateSubsets(nums);
        int maxOrValue = findMaxOrValue(nums);
        int count = 0;
        for(List<Integer> subset : subsets){
            if(!subset.isEmpty() && calculateBitwiseOr(subset) == maxOrValue){
                count++;
            }
        }
        return count;
    }
}