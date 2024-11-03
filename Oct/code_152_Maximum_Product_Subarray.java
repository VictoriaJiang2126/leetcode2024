package Oct;
import java.util.ArrayList;
import java.util.Arrays;
public class code_152_Maximum_Product_Subarray {
    public static int maxProduct(int[] nums) {
        int last0 = -1; //记录上一个0的index
        int res = 0;
        boolean has0 = false;//nums中是否有0

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                has0 = true;
                if(last0 == -1){
                    res = Math.max(help(0,i-1,nums), res);
                    last0 = i;
                }else{
                    res = Math.max(help(last0+1,i-1,nums), res);
                    last0 = i;
                }
            }
        }
        //这里要多做一次，测试例子：[0,2]
        res = Math.max(help(last0+1,nums.length-1,nums), res);



        if(has0 == false){
            return help(0,nums.length -1, nums);
        }else{
            return res;
        }

    }
    public static int help(int l, int r, int[] nums){
        if(r < l){
            return 0;
        }
        if(r == l){
            return nums[l];
        }
        int[] memo = new int[r-l+2];
        int i = l;
        ArrayList<Integer> indexN = new ArrayList<>(); //记录负数所在的下标

        
        while(i <= r){
            memo[i-l+1] = memo[i-l] * nums[i];//比原先nums中元素的下标 大一个
            Arrays.fill(memo, 1);
            if(nums[i] < 0){
                indexN.add(i);
            }
            i++;
        }

        if(memo[r-l+1] > 0){
            return memo[r-l+1];
        }else{
            if(indexN.size() == 1){ //只有一个负数
                return Math.max( memo[r-l+1]/memo[indexN.get(0)-l+1], memo[indexN.get(0) - l]);
            }else{
                int firstN = indexN.get(0) - l; //负数的个数 >=3且为奇数
                int lastN = indexN.get(indexN.size()-1) - l;
                return Math.max( memo[r-l+1]/memo[firstN+1], memo[lastN]);
            }
        }


    }

    public static void main(String args[]){
        int[] x = {-2,0,-1};
        maxProduct(x);
    }
}
