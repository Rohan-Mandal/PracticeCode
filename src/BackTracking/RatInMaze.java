package BackTracking;

public interface RatInMaze {

    public static boolean ratInMaze(int[][] maze){
        int length = maze.length;
        int[][] path = new int[length][length];
        return solveMaze(maze, 0, 0, path);
    }

    public static boolean solveMaze(int[][] maze, int i, int j, int[][] path){
        //check if i, j cell is valid or not
        int length = maze.length;
        if(i < 0 || i >= length || j < 0 || j >= length || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }
        //include cell in current path
        path[i][j] = 1;
        //destination cell
        if(i == (length - 1) || j == (length - 1)){
            return true;
        }
        //check if there is a path to the exit and explore
        //top
        if(solveMaze(maze, i - 1, j, path)){
            return true;
        }
        //right
        if(solveMaze(maze, i, j + 1, path)){
            return true;
        }
        //bottom
        if(solveMaze(maze, i + 1, j, path)){
            return true;
        }
        //left
        if(solveMaze(maze, i, j - 1, path)){
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0}, {1, 1, 0},{1, 1, 1}};
        boolean possiblePath = ratInMaze(maze);
        System.out.println(possiblePath);
    }
}
