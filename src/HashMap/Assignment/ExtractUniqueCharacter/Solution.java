package Assignment.ExtractUniqueCharacter;

import java.util.*;
public class Solution {
    public static String uniqueChar(String str){
		if(str.length() == 0) {
		return " ";
	}

	String ans = " ";
	HashMap<Character, Boolean> map = new HashMap<>();
	for(int currentIndex = 0; currentIndex < str.length(); currentIndex++) {
		char currentChar = str.charAt(currentIndex);
		if(!map.containsKey(currentChar)) {
			map.put(currentChar, true);
			ans += currentChar;
		}
	}
	return ans;

	}
    
}
