import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for(int val : temp){
            if(!rankMap.containsKey(val)){
                rankMap.put(val, rank++);
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}