package recursion;


//write a function that take a number and prints it.
//print first five numbers : 1 2 3 4 5
public class NumberExampleRecursion {

    public static void main(String[] args) {
        print(1);
    }

    static void print(int num){
        // base case
        if(num == 5){
            System.out.println(5);
            return;
        }
        System.out.println(num);
        // recursive call
        print(num + 1);
    }
}
