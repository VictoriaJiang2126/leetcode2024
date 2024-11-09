package Oct;

public class code_55_Jump_Game {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] memo = new boolean[len];
        memo[0] = true;
        for (int i = 0; i < len; i++) {
            if (memo[i] == true) {
                int maxStep = nums[i];
                for (int j = 1; j <= maxStep && i + j < len; j++) {
                    memo[i + j] = true;
                }
            }else{
                continue;
            }

        }

        return memo[len - 1];
    }
}
