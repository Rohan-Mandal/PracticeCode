package binarySearch;

public class OrderAgnostic {
    public static void main(String[] args) {
        //int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45};

        int[] arr={20,18,16,14,12,10,8,6,4,2,0,-2,-4,-6};
        int target = -2;

        int ans= orderAgnosticBS(arr,target);
        System.out.println(ans);

    }

    static int orderAgnosticBS(int[] arr1, int target) {
        int start = 0;
        int end = arr1.length-1;

        //find whether ascending or descending

        boolean isASC = arr1[start] < arr1[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr1[mid] == target) {
                return mid;
            }
            if (isASC) {
                if (target < arr1[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr1[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
