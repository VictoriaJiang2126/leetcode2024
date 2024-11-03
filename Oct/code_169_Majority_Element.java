package Oct;

import java.util.Arrays;

public class code_169_Majority_Element {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length / 2;
        return nums[i];
    }
}
