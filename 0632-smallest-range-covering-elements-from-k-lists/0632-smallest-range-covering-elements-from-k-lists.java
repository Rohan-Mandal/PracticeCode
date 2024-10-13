class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int size = nums.size();
        int[] arr = new int[size];

        int[] result = {-100000000, 100000000};
        while(true){
            int minElement1 = Integer.MAX_VALUE;
            int maxElement1 = Integer.MIN_VALUE;
            int minIndex = 0;
            for(int i = 0; i < size; i++){
                int listIdx = i;
                int elemIdx = arr[i];
                int element = nums.get(listIdx).get(elemIdx);
                if(element < minElement1){
                    minElement1 = element;
                    minIndex = listIdx;
                }
                maxElement1 = Math.max(maxElement1, element);
            }
            if(maxElement1 - minElement1 < result[1] - result[0]){
                result[0] = minElement1;
                result[1] = maxElement1;
            }
            int nextIdx = arr[minIndex] + 1;
            if (nextIdx >= nums.get(minIndex).size()) {
                break; 
            }
            arr[minIndex] = nextIdx;
        }
        return result;
    }
}