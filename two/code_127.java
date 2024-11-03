package two;


public class code_127{
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0;
        int r = n - 1;
        int[] res = new int[2];
        //res[0] = -1;

        while(r > l){
            int curSum = numbers[l] + numbers[r];
            if(curSum > target){
                r--;
            }else if(curSum < target){
                l++;
            }else{
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
        }
        return res;
    }
}