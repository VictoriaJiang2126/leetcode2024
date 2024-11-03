package Oct;

public class code_124_Binary_Tree_Maximum_Path_Sum {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    static int res = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int singleSideMax = Math.max(Math.max(left + root.val, right + root.val), root.val);
        res = Math.max(Math.max(res, singleSideMax), left+right+root.val);
        return singleSideMax;

    }
    public static void main(String args[]){
        TreeNode x1 = new TreeNode(1);
        TreeNode x2 = new TreeNode(2);
        TreeNode x3 = new TreeNode(3);
        x1.left = x2;
        x1.right = x3;

        maxPathSum(x1);
    }
}
