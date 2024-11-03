package Oct;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class code_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
       
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
    
        int i = 0;
        while(i < n){
            if(nums[i] > 0){
                break;
            }

            int j = i + 1;
            int p = n - 1;
            //给i去重
            while( p > j && j < n && p <n && j >= 0 && p >= 0){
                int sum = nums[i] + nums[j] + nums[p];
                //给j去重； 当i，j都去重后，p去不去重其实无所谓了
                if(sum > 0){
                    p--;

                }else if(sum < 0){
                    j++;
                }else{
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[j]);
                    triple.add(nums[p]);
                    res.add(triple);
                    while(j+1 < n && nums[j] == nums[j+1]){
                        j++;
                    }
                    j++;
                    p--;
                }
            }

            while(i+1 < n && nums[i] == nums[i+1]){
                i++;
            }
            i++;
            
        }

        return res;
        
    }
}
