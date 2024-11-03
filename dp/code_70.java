package dp;

public class code_70 {
    public int climbStairs(int n) {
        //方法一：暴力递归
        // if(n == 1){
        //     return 1;
        // }
        // if(n == 2){
        //     return 2;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);

        // //方法二：
        // //初始化备忘录
        // int memo[] = new int[n+1];
        // //带备忘录进行递归
        // return dp(memo,n);
        
        //方法3:
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];




    }

    // public int dp(int[] memo, int n){
    //     //base case
    //     if(n == 1){
    //         return 1;
    //     }
    //     if(n == 2){
    //         return 2;
    //     }
    //     if(memo[n] != 0){
    //         return memo[n];
    //     }
    //     memo[n] = dp(memo, n-1) + dp(memo, n-2);
    //     return memo[n];
    // }


}
