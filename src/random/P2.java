package random;

import java.util.*;
public class P2 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        char a1=(char)sc.next().charAt(0);
        char a2=(char)sc.next().charAt(0);
        int x=Math.abs((int)a1-(int)a2);
        int y=Math.max((int)a1,(int)a2);
        char z=(y+x>122)?(char)(y+x-123+97):(char)(y+x);

        System.out.println(z);
    }
}