package Oct;

public class code_236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static TreeNode pGlobal = null;
    static TreeNode qGlobal = null;
    static TreeNode res = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        qGlobal = q;
        pGlobal = p;
        dfs(root);
        return res;
    }

    public static boolean dfs(TreeNode root){
        if(root == null){
            return false;
        }
        
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        // 1) 
        if(left == true && right == true){
            res = root;
            return false;
        }
        // 2)
        if((left == true || right == true) && (root == qGlobal || root == pGlobal)){
            res = root;
            return false;
        }

        if(root == pGlobal || root == qGlobal){
            return true;
        }
        
        if(left == true || right == true){
            return true;
        }
        return false;
    }


    public static void main(String args[]){
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        lowestCommonAncestor(t, t, t.left);
    }

}
