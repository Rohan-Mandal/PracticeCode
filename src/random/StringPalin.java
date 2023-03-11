package random;

import java.util.Scanner;

public class StringPalin {

    static String[] solve(int n, int k){
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = ans + " ";
        }
        int temp = 0;
        int i = 0, j = n-1;
        while(i <= j){
            ans[i] = String.valueOf('a' + temp);
            ans[j] = String.valueOf('a' + temp);
            i++;
            j--;
            temp++;
            if(temp == k){
                temp = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] ans = (solve(n, k));
        System.out.println(ans);
    }
}
