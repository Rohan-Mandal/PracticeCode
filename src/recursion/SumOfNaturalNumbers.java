package recursion;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {

        int ans = sum(4);
        System.out.println(ans);

    }

    static int sum(int num){
        if(num == 0){
            return 0;
        }
        return num + sum(num -1);
    }
}
