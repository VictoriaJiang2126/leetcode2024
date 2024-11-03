package slidingwindow;

public class code_1493 {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0; //窗口内0的个数
        int maxLength = -1; //replace一个元素后最长的连续1长度
        int left=0, right = 0;
        if(nums.length < 3){
            return nums.length - 1;
        }
        while(right < nums.length){
            //更新窗口内0的个数
            if(nums[right] == 0){
                zeroCount++;
            }
            //收缩左边界
            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
               left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right ++;
        }

        return maxLength - 1;
    }
}
