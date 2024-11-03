package two;

public class code_540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length;

        while(r >= l){
            int mid = l + (r - l) / 2;
            
            if(mid > 0 && mid < nums.length && nums[mid - 1] == nums[mid] && nums[mid+1] != nums[mid]){
                
            }else if(mid > 0 && mid < nums.length &&nums[mid+1] == nums[mid] && nums[mid-1] != nums[mid]){

            }else{
                return nums[mid];
            }
            
            if((r - mid + 1) / 2 == 0){
                r = mid -1;
            }else if((mid - l + 1) / 2 == 0){
                l = mid + 1;
            }else{
                return nums[mid];
            }
        }
        return nums[r];
    }
}
