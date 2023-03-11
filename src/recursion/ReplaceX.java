package recursion;

public class ReplaceX {
    public static void main(String[] args) {
        String result = removeX("abxcx");
        System.out.println(result);

    }
    public static String removeX(String input){
        if(input.length() == 0){
            return input;
        }
        String smallOutput = removeX(input.substring(1));
        if(input.charAt(0) == 'x'){
            return smallOutput;
        }
        else{
            return input.charAt(0) + smallOutput;
        }
    }
}
