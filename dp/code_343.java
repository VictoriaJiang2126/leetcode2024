package dp;

class code_343 {
    //https://www.programmercarl.com/0343.%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
    //从dp[3]开始j计算(更新)到dp[n]
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){
            for(int j=1; j<=i-1; j++){
                int curValue = Math.max(j*dp[i-j],j*(i-j));
                dp[i] = Math.max(curValue, dp[i]);
            }
        }
        return dp[n];
     }
     public static void main(String args[]){
        integerBreak(8);
     }
}