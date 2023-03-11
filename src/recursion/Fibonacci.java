package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int ans = fibonacci(4);
        System.out.println(ans);
    }

    static int fibonacci(int num) {

        //base condition
        if (num < 2) {
            return num;
        }
        // recursive call
        return fibonacci(num - 1) + fibonacci(num - 2);

    }
}
