package March;

public class code_236 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    boolean findP = false;
    boolean findQ = false;
    TreeNode res = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        int a = 1;

        return res;
    }



    public void dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return;
        }
        
        if(root == p){
            findP = true;
        }else if(root == q){
            findQ = true;
        }
        dfs(root.left, p, q);
        dfs(root.right, p, q);

        if(findP && findQ){
            res = root;
            findP = false;
            findQ = false;
            return;
        }
        return;
    }
}
