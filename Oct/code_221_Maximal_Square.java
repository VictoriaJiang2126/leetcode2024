package Oct;

public class code_221_Maximal_Square {
    // public static int maximalSquare(char[][] matrix) {
    //     int rows = matrix.length;
    //     int columns = matrix[0].length;
    //     int[][] dp = new int[rows+1][columns+1];
    //     for(int j=0; j<columns; j++){
    //         dp[0][j] = 0;
    //     }
    //     for(int i=0; i<rows; i++){
    //         dp[i][0] = 0;
    //     }
    //     int res = 0;
    //     for(int i=1; i<rows+1; i++){
    //         for(int j=1; j<columns+1; j++){
    //             int im = i-1;
    //             int jm = j-1;
    //             if(matrix[im][jm] == '0'){
    //                 dp[i][j] = 0;
    //             }else{
    //                 dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
    //                 res = Math.max(res, dp[i][j]);
    //             }
    //         }
    //     }
    //     return res;
        
    // }


    // public static int maximalSquare(char[][] matrix) {
    //     int maxSide = 0;

    //     int rows = matrix.length;
    //     int columns = matrix[0].length;

    //     for(int i=0; i<rows; i++){
    //         for(int j=0; j<columns; j++){
    //             if(matrix[i][j] == '0'){
    //                 continue;
    //             }
    //             maxSide = Math.max(1, maxSide);
    //             int curMaxSide = Math.min(rows - i, columns - j);
    //             int k = 1;//检查第 下 k 行 
    //             while(k < curMaxSide){
    //                 if(isValidSquare(matrix,k,i,j)){
    //                     maxSide = Math.max(k+1, maxSide);
    //                 }else{
    //                     break;
    //                 }
    //                 k++;
    //             }
    //         }
    //     }
    //     return maxSide * maxSide;
    // }
    // public static boolean isValidSquare(char[][] matrix, int k, int i, int j){
    //     //从当前坐标起，检查第下k行 和 第右k列
    //     int times = k + 1;
    //     int curJ = j;
    //     int curI = i;
    //     while(times > 0){
    //         if(matrix[i+k][curJ] == '1'){
    //             curJ ++;
    //         }else{
    //             return false;
    //         }

    //         if(matrix[curI][j+k] == '1'){
    //             curI ++;
    //         }else{
    //             return false;
    //         }
    //         times --;
    //     }

    //     return true;
    // }

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int maxSide = 0;

        int[][] dp = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                    maxSide = Math.max(maxSide, dp[i][j]);
                    continue;
                }
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide*maxSide;
    }

    public static void main(String args[]){
        char[][] x = {{'0','1'},{'1','0'}};
        maximalSquare(x);
    }
    

    
}
