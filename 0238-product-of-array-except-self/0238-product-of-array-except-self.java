class Solution {
    public int[] productExceptSelf(int[] nums) {
    //    int n = nums.length;;
    //     int[] left_products = new int[n];
    //     int[] right_products = new int[n];
    //     int[] output_array  = new int[n];


    //     left_products[0] = 1;
    //     right_products[n - 1] = 1;

    //     for (int i = 1; i < n; i++) {
    //         left_products[i] = nums[i - 1] * left_products[i - 1] ;
    //     }
    //     for (int i = n - 2; i >= 0; i--) {
    //         right_products[i] = nums[i + 1] * right_products[i + 1] ;
    //     }

    //     for (int i = 0; i < n; i++) {
    //         output_array[i] = left_products[i] * right_products[i];
    //     }
    //     return output_array;

    int n = nums.length;
        int[] output_array  = new int[n];

        output_array[0] = 1;
        for (int i = 1; i < n; i++) {
            output_array[i] = nums[i - 1] * output_array[i - 1];
        }

        int right_product = 1;
        for (int i = n - 1; i >= 0; i--) {
            output_array[i] *= right_product;
            right_product *= nums[i];
        }
        return output_array;
    }
}