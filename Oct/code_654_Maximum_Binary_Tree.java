package Oct;

public class code_654_Maximum_Binary_Tree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(0,nums.length-1,nums);
    }
    public static TreeNode dfs(int leftIndex, int rightIndex, int[] nums){
        if(rightIndex < leftIndex || leftIndex < 0 || rightIndex >= nums.length){
            return null;
        }
        int curMaxIndex = leftIndex;

        for(int i=leftIndex; i<rightIndex+1; i++){
            if(nums[i] > nums[curMaxIndex]){
                curMaxIndex = i;
            }
        }
        TreeNode curNode = new TreeNode(nums[curMaxIndex]);
        curNode.left = dfs(leftIndex,curMaxIndex-1, nums);
        curNode.right = dfs(curMaxIndex+1,rightIndex, nums);

        return curNode;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(6); // 根节点
        root.left = new TreeNode(3);     // 左子树
        root.right = new TreeNode(5);    // 右子树

        root.left.right = new TreeNode(2); // 3的右子树
        root.right.left = new TreeNode(0); // 5的左子树

        root.left.right.left = new TreeNode(1); // 2的左子树

        int[] nums = {3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);

    }

}
