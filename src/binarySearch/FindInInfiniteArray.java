package binarySearch;

public class FindInInfiniteArray {
    public static void main(String[] args) {
        int[] arr ={3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println("Element found at index " + findRange(arr, target));
    }

    static int findRange(int[] arr, int target){
        // find the range first
        //  start with a box of size 2
        int start = 0;
         int end = 1;

         //condition for the target to lie in the range
        while (target > arr[end]){
            int newStart = end+1;
            //double the size of the box
            //end = previous end + sizeof-box * 2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(arr, target, start, end);

    }


    //binary search code
    static int binarySearch(int[] arr1, int target, int start, int end) {


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
        return -1;
    }
}
