package recursion;

import java.util.Scanner;
public class PrintUptoN {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       print(n);
    }
    static void print(int n){
        if(n == 0){
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }
}
