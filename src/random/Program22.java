package random;

import java.io.*;

class CodeWindow {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        int a[] = new int[str.length];
        for(int i=0;i<str.length;i++)
            a[i] = Integer.parseInt(str[i]);

        str = br.readLine().split(" ");
        int b[] = new int[str.length];
        for(int i=0;i<str.length;i++)
            b[i] = Integer.parseInt(str[i]);
        int sum = 0;
        for(int i=0;i<a.length;i++) {
            int flag = 1;
            for(int j=0;j<b.length;j++) {
                if(a[i] == b[j]) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
                sum+=a[i];
        }
        for(int i=0;i<b.length;i++) {
            int flag = 1;
            for(int j=0;j<a.length;j++) {
                if(b[i] == a[j]) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
                sum+=b[i];
        }
        System.out.println(sum);
    }
}