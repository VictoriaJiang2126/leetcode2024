package array;
//接雨水;)
public class code_42 {
    //方法一：官方题解 动态规划
    //https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/?envType=study-plan-v2&envId=top-interview-150
    public int trap(int[] height) {
        //height = [0,1,0,2,1,0,1,3,2,1,2,1]
        //求出当前节点，左右两边的最大值leftmax[i] rightmax[i];
        //当前点为一个单位平台，头顶能盛水的高度就是左右最大高度min与其的差
        int n = height.length;
        if(n < 3) return 0;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = height[0];
        for(int i=1; i<n; i++){
            if(height[i] > leftmax[i-1]){
                leftmax[i] = height[i];
            }else{
                leftmax[i] = leftmax[i-1];
            }
        }
        rightmax[n-1] = height[n-1];
        for(int i=n-2; i >0; i--){
            if(height[i] > rightmax[i+1]){
                rightmax[i] = height[i];
            }else{
                rightmax[i] = rightmax[i+1];
            }
        }
        int res = 0;
        for(int i=0; i<n; i++){
            if(Math.min(leftmax[i],rightmax[i]) > height[i]){
                res = res + Math.min(leftmax[i],rightmax[i]) - height[i];
            }
        }

        return res;
    }
}
