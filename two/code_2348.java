package two;
import java.util.ArrayList;
import java.util.List;

public class code_2348 {
    public long zeroFilledSubarray(int[] nums){
        int i=0,  j=0;
        List<Integer> countSubarray = new ArrayList<>();
        int sumIndex = 0;
        for(i=0; i<nums.length; i++){
            while(j < nums.length && nums[j]!= 0){
                j++;
            }
            if(j<nums.length && nums[j] == 0){
                i = j;
                while(j<nums.length && nums[j]== 0){
                    j++;
                }
                countSubarray.add(sumIndex, j-i);
                sumIndex++;
            }
        }
        long res = 0;
        for(int x=0; x<countSubarray.size(); x++){
            long tmp = countSubarray.get(x);
            res =((tmp + 1) * tmp / 2) + res;
        }
        return res; 
    } 

    // public static void test(int[] nums, int target){
    //     int length = Integer.MAX_VALUE;
    //     int curSum = 0;
        
    //     for(int i=0; i<nums.length; i++){
    //         curSum = 0;
    //         for(int j=i; j<nums.length; j++){
    //             curSum += nums[j];
    //             if(curSum >= target){
    //                 length = Math.min(j - i + 1, length);
    //                 break;
    //             }
    //         }
    //     }
    //     System.out.println(length);
    // }
    public static int prefixSumSolution(int[] nums, int target){
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        getPrefixSum(prefixSum, nums);
        int minLength = Integer.MAX_VALUE;
        //nums:     {2,3,1,2,4,3} target:7 
        //prefixSum:{0,2,5,6,8,12,15} 前i项之和，不包括当前i
        //prefixSum[i] + target <= prefixSum[j+1]; i,j 为nums下标
        for(int i=0; i<n; i++){
            int find = prefixSum[i] + target;
            //二分法查找（最接近find的值的数）
            int l = i;
            int r = n; // r = j+1
            int mid; 
            
            while( r >= l){
                mid = (l + r) / 2;
                if(prefixSum[mid] < find){ //if(我们不想要的条件)
                    l = mid + 1; // 因为l会越界，所以最后return r, r 是最满足我们想要找的值
                }else{
                    r = mid;
                }
            }
            minLength = Math.min(minLength, r-i);

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void getPrefixSum(int[] prefixSum, int[] nums){
        int n = prefixSum.length;
        for(int i=0; i<n; i++){
            if(i == 0){
                prefixSum[i] = 0;
            }else{
                prefixSum[i] = prefixSum[i-1] + nums[i-1];
            }
        }
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4,7,1};
        
    }

}
