package random;

import java.io.*;
import java.util.*;
public class Anagram {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        String result = solve(s1, s2, s3);

        System.out.println(result);

        wr.close();
        br.close();
    }

    static String solve(String s1, String s2, String s3) {

        String result = " ";
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        String sortedArray1 = new String(arr1);
        String sortedArray2 = new String(arr2);
        String sortedArray3 = new String(arr3);

        
        if (sortedArray1.equals(sortedArray2) && sortedArray2.equals(sortedArray3)) {
            result = "YES";
        } else {
            result = "NO";
        }

        return result;
    }
}

