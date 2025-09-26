class Solution {
    public int triangleNumber(int[] nums) {

        // Approach 1: Sort + Binary Search
        // T.C :- O(n ^2 * log n)
        //     int n = nums.length;

        //     Arrays.sort(nums);

        //     int count = 0;

        //     for(int i = 0; i < n; i++){
        //         if(nums[i] == 0){
        //             continue;
        //         }

        //         for(int j = i + 1; j < n; j++){
        //             int sum = nums[i] + nums[j];
        //             int k = binarySearch(nums, j + 1, n - 1, sum);

        //             if(k != -1){
        //                 count += (k - j);
        //             }
        //         }
        //     }
        //     return count;
        // }

        // private int binarySearch(int[] nums, int l, int r, int target){
        //     int k = -1;

        //     while(l <= r){
        //         int mid = l + (r - l) / 2;

        //         if(nums[mid] < target){
        //             k = mid;
        //             l = mid + 1;
        //         } else{
        //             r = mid - 1;
        //         }
        //     }
        //     return k;
        // }

        // Approach 2 :- Two-Pointer/
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i); // all pairs (i..j-1, j) are valid
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}