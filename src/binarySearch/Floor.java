package binarySearch;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        int ans = floor(arr, target);
        System.out.println(ans);
     }
    // return the index of the greatest no <= target
    static int floor(int[] arr1, int target) {
        int start = 0;
        int end = arr1.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr1[mid]) {
                end = mid - 1;
            } else if (target > arr1[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
