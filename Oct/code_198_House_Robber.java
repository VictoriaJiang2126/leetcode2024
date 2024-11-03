package Oct;

import java.util.Arrays;

public class code_198_House_Robber {
    static int[] memo;
    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return traverse(0, nums);
    }
    public static int traverse(int i, int[] nums){
        if(i >=  nums.length){
            return 0;
        }
        //打劫
        int yes;
        if(i+2 < nums.length && memo[i+2] != -1 ){
            yes = nums[i] + memo[i+2];
        }else{
            yes = nums[i] + traverse(i+2, nums);
        }

        //不打劫
        int no;
        if(i+1 < nums.length && memo[i+1] != -1 ){
            no = nums[i] + memo[i+1];
        }else{
            no = nums[i] + traverse(i+1, nums);
        }

        memo[i] = Math.max(yes,no);

        return memo[i];
    }
    public static void main(String args[]){
        int[] x = {1,2,3};
        rob(x);
    }
}
