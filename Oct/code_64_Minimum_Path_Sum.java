package Oct;

public class code_64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                int leftSum = Integer.MAX_VALUE;
                int topSum = Integer.MAX_VALUE;
                if(j-1 >=0){
                    leftSum = grid[i][j-1];
                }
                if(i-1 >= 0){
                    topSum = grid[i-1][j];
                }
                int preSum = Math.min(leftSum, topSum);
                if(preSum != Integer.MAX_VALUE){
                    grid[i][j] = preSum + grid[i][j];
                }
            }
        }
        return grid[rows-1][columns-1];
    }
}
