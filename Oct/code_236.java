package Oct;



public class code_236 {
    public static class TreeNode{
        int root;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.root = val;
        }
    }
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;

    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        
        TreeNode left = dfs(root.left,p,q);
        TreeNode right = dfs(root.right,p,q);
        if(root == p){
            if(left == q || right == q){
                res = root;
            }
        }
        else if(root == q){
            if(left == p || right == p){
                res = root;
            }
        }

       if(left != null && right != null){
            res = root;
        } 
        else if(left != null && right == null){
            return left;
        }
        else if(right != null && left == null){
            return right;
        }else if(root == p || root == q){
            return root;
        }

        

        return null;
    }
}





