package Oct;

public class code_450_Delete_Node_in_a_BST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root,key);
    }


    public TreeNode dfs(TreeNode root, int key){
        if(root == null){
            return null;
        }
        if(key > root.val){
            root.right = dfs(root.right, key);
        }else if(key < root.val){
            root.left = dfs(root.left, key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //遍历找到二叉树左子树的最右节点
            TreeNode maxInLeft = root;
            while(maxInLeft.right != null){
                maxInLeft = maxInLeft.right;
            }
            maxInLeft.right = root.right;
            return root.left;
        }
        return root;
    }

  
}
