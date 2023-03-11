package random;

import java.util.Arrays;

public class StringToNumber {
    public static void main(String[] args) {
        String str ="1256789";
        int length = str.length();
        int []arr = new int[length];
        for (int i = 0; i < length ; i++) {
            arr[i] =(int)str.charAt(i) - 48;
        }
        System.out.println(Arrays.toString(arr));
    }
}
