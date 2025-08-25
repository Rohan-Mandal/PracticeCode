class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0;
        boolean up = true;

        for(int i = 0; i < result.length; i++){
            result[i] = mat[row][col];

            if(up){                 // moving up-right
                if(col == n - 1){   // hit last column
                    row++;
                    up = false;
                } else if(row == 0){    // hit first row
                    col++;
                    up = false;
                } else{
                    row--;
                    col++;
                }
            } else{                 // moving down-left
                if(row == m - 1){   // hit last row
                    col++;
                    up = true;
                } else if(col == 0){
                    row++;
                    up = true;
                } else{
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}