package Oct;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class code_103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        boolean isLeftToRight = true; //true: 顺序打印； false:逆序打印

        queue.add(root);

        while(!queue.isEmpty()){
            int qSize = queue.size();
            ArrayList<Integer> thisLevel = new ArrayList<>();
            for(int i=0; i<qSize; i++){
                if(isLeftToRight == true){
                    TreeNode cur = queue.removeFirst();
                    thisLevel.add(cur.val);
                    if(cur.left != null) queue.addLast(cur.left);
                    if(cur.right != null) queue.addLast(cur.right); 
                }else{
                    TreeNode cur = queue.removeFirst();
                    
                    if(cur.right != null) queue.add(cur.right);
                    if(cur.left != null) queue.add(cur.left);  
                }
            }
            isLeftToRight = !isLeftToRight;
            res.add(thisLevel);
        }

        return res;
    }
}
