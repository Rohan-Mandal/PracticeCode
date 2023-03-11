package binarySearch;

public class MountainArray {
    public static void main(String[] args) {

    }
        public int peakIndexInMountainArray(int[] arr) {
            int start = 0;
            int end = arr.length-1;

            while(start < end){
                int mid = start + (end - start) / 2;
                if(arr[mid] > arr[mid+1]){
                    //you are in the decreasing part of the array
                    //this may be the ans, but look at left
                    // this is why end != mid-1;
                    end = mid;
                } else{
                    //you are in ascending part of the array
                    // because we know that mid+1 element is > mid-element
                    start = mid + 1;
                }
            }
            // in the end start == end and pointing to the largest element because of the two checks above
            //start and end are always trying to find max element in the above 2 checks
            // hence when they are pointing to just one element, that is the max one
            return start;

        }
}
