package two;

import java.util.Arrays;

public class code_88 {
    //Input:
    //[1,2,6,0,0,0]
    //[2,3,5]
    //Output:
    //[1,2,2,3,5,6]
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m, j = 0; i<nums1.length; i++, j++){
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
        


    }
}
