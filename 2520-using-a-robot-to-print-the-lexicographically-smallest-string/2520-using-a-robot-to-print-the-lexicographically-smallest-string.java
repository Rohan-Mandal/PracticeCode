class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minChar = new char[n];
        minChar[n - 1] = s.charAt(n - 1);

        for(int i = n - 2; i >= 0; i--){
            minChar[i] = (char)(Math.min(s.charAt(i), minChar[i + 1]));
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++){
            stack.push(s.charAt(i));
            while(!stack.isEmpty() && (i == n - 1 || stack.peek() <= minChar[i + 1])){
                result.append(stack.pop());
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }
}