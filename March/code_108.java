package March;

public class code_108 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = builder(0, mid-1, nums);
        root.right = builder(mid+1, nums.length-1, nums);
        return root;
    }
    public TreeNode builder(int l, int r, int[] nums){
        if(r >= nums.length || l < 0 || l > r){
            return null;
        }
        int mid = (l+r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = builder(l, mid-1, nums);
        root.right = builder(mid+1, r, nums);
        return root;
    }
}
