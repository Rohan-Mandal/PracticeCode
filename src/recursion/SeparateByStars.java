package recursion;

public class SeparateByStars {
    public static void main(String[] args) {
        String result = addStars("hello");
        System.out.println(result);

    }

    public static String addStars(String s) {
        if(s.length() <= 1){
            return s;
        }

        // String smallOutput = addStars(s.substring(1));
        if(s.charAt(0) == s.charAt(1)){
            return s.charAt(0) + "*" +addStars(s.substring(1));
        }
        else{
            return s.charAt(0) + addStars(s.substring(1));
        }
    }
}
