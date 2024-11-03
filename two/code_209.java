package two;
//双指针 
//209. Minimum Size Subarray Sum
public class code_209 {
    //nums:     >0; Integer
    //target:   >0; Integer
    //min subarray: continous subarray; sum >= target
    //not found : return 0
    public static int minSubArrayLen(int target, int[] nums) {
        
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        int curSum = 0;
        int j = 0;
        for(i=0; i<nums.length; i++){
            while(j<nums.length && curSum < target){
                curSum += nums[j];
                j++;
            }
            if(curSum >= target){
                minLength = Math.min(minLength, j-i);
            }
            curSum -= nums[i];
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength ;
        
    }
    public static void main(String args[]){
        int[] nums = {2,3,1,3,4,3};
        minSubArrayLen(7,nums);
    }

}
