class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char ch : stack){
            result.append(ch);
        }
        return result.reverse().toString();
    }
}