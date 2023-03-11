package recursion;

public class ReplaceCharacter {

    public static void main(String[] args) {

        String result = replace("abcxdxex",'x', 'y');
        System.out.println(result);

    }

    public  static String replace(String input, char c1, char c2){
        if(input.length() == 0){
            return input;
        }
        String smallOutput = replace(input.substring(1),c1,c2);
        if(input.charAt(0) == c1){
            return c2 + smallOutput;
        }
        else {
            return input.charAt(0) + smallOutput;
        }
    }
}

