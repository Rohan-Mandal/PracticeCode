package Stack;
import java.util.*;
public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if (ch=='[' || ch=='{' || ch=='('){
                stack.push(ch);
            }
            else if (ch == ']' || ch == '}' || ch == ')') {
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    if(ch == ']'){
                        if(stack.peek() != '['){
                            return false;
                        }
                        else{
                            stack.pop();
                        }
                    }

                    else if(ch == '}'){
                        if(stack.peek() != '}'){
                            return false;
                        }
                        else{
                            stack.pop();
                        }
                    }
                    else if(ch == ')'){
                        if(stack.peek() != '('){
                            return false;
                        }
                        else{
                            stack.pop();
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "()(({}))";
        boolean ans = isBalanced(expression);
        System.out.println(ans);
    }
}
