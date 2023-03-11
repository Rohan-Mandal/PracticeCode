package recursion;

public class ReplaceConsecutive {

    public static void main(String[] args) {
        String result = removeConsecutiveDuplicates("aabccba");
        System.out.println(result);

    }

    public static String removeConsecutiveDuplicates(String s) {
        if(s.length() <= 1){
            return s;
        }

       // String smallOutput = removeConsecutiveDuplicates(s.substring(1));
        if(s.charAt(0) == s.charAt(1)){
            return removeConsecutiveDuplicates(s.substring(1));
        }
        else{
            return s.charAt(0)+ removeConsecutiveDuplicates(s.substring(1));
        }
    }
}
