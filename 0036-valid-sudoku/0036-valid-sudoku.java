class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate rows
        for(int row = 0; row < 9; row ++){
            Set<Character> set = new HashSet<>();
            for(int col = 0; col < 9; col++){
                char ch = board[row][col];
                if(ch == '.'){
                    continue;
                }
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }

        // Validate col
        for(int col = 0; col < 9; col++){
            Set<Character> set = new HashSet<>();
            for(int row = 0; row < 9; row++){
                char ch = board[row][col];
                if(ch == '.'){
                    continue;
                }
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }

        // Validate 3*3 boxes
        for(int sr = 0; sr < 9; sr += 3){
            int er = sr + 2;
            for(int sc = 0; sc < 9; sc += 3){
                int ec = sc + 2;
                if(!validBox(board, sr, er, sc, ec)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validBox(char[][] board, int sr, int er, int sc, int ec){
        Set<Character> set = new HashSet<>();
        for(int row = sr; row <= er; row++){
            for(int col = sc; col <= ec; col++){
                char ch = board[row][col];
                if(ch == '.'){
                    continue;
                }
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }
        return true;
    }
}