package Oct;

public class code_200_Number_of_Islands {
    int rows;
    int columns;
    boolean[][] isVisited; 
    public int numIslands(char[][] grid) {
        rows = grid.length;// >=1
        columns = grid[0].length;// <=300 ??
        isVisited = new boolean[rows][columns];
        int res = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(isVisited[i][j] == false && grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j){
        if(j >= columns || i >= rows || j < 0 || i < 0 || isVisited[i][j] == true){
            return;
        }
        if(grid[i][j] == '0'){
            isVisited[i][j] = true;
            return;
        }
        isVisited[i][j] = true;
        
        dfs(grid,i,j+1);//右
        dfs(grid,i+1,j);//下
        dfs(grid,i,j-1);//左
        dfs(grid,i-1,j);
        return;
    }
    public static void main(String args[]){
        // boolean[][] b = new boolean[1][1];
        // System.out.println(b[0][0]);
    }
}
