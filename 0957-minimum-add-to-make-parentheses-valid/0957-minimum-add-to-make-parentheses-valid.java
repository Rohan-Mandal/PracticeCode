class Solution {
    public int minAddToMakeValid(String s) {
        int size = 0, remaining = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                size++;
            } else if(size > 0){
                size--;
            } else{
                remaining++;
            }
        }
        return size + remaining;
    }
}