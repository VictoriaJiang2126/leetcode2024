// package dp;
// //（最优）状态转移
// //当前状态可以由之前哪几个状态得到
// public class code_62 {
//     public static int uniquePaths(int m, int n) {

//         int[][] dp = new int[m][n];
//         dp[0][0] = 0;
//         dp[0][1] = 1;
//         dp[1][0] = 1;
//         for(int i=1; i< m; i++){
//             for(int j=1; j<n; j++){
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }
//     }
//     // private static int dfs(int i, int j, int m, int n){
//     //     if(i >=m || j >=n){
//     //         return 0;
//     //     }
//     //     if( i == m-1 && j == n-1){
//     //         return 1;
//     //     }
        
//     //     int res1 = dfs(i+1,j,m,n);
//     //     int res2 = dfs(i,j+1,m,n);
//     //     return (res1+res2);
//     // }
//     public static void main(String ages[]){
//         uniquePaths(2,2);
//     }
    
// }
