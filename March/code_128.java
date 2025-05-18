package March;

import java.util.Arrays;
import java.util.HashSet;

public class code_128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        Arrays.sort(nums);

        int i = 1;
        int maxLen = -1;
        int curLen = 1;
        
        while(i < nums.length){
            while(i < nums.length && (nums[i] - nums[i-1] == 1 || nums[i] == nums[i-1]) ){
                if( nums[i] == nums[i-1]){
                    continue;
                }
                curLen++;
                i++;
            }
            maxLen = Math.max(maxLen, curLen);
            curLen = 1;
            i++;
        }
        return maxLen;
    }
}
