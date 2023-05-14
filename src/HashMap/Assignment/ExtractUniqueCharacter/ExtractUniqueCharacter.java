package Assignment.ExtractUniqueCharacter;
//import java.util.*;
import java.io.*;
public class ExtractUniqueCharacter {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String takeInput() throws IOException {
        String str = br.readLine(); 
        return str;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String str = takeInput();
        System.out.print(Solution.uniqueChar(str));


    }
    
}
