package March;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class code_102 {
        public class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            public TreeNode(int val){
                this.val = val;
            }
        }
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            Deque<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> list = new LinkedList<>();
                for(int i=0; i<size; i++){
                    TreeNode cur = q.removeFirst();
                    list.add(cur.val);
                    if(cur.left!= null) q.addLast(cur.left);
                    if(cur.right!= null) q.addLast(cur.right);
                }
                res.add(list);
            }
            return res;
        }
        
    
}
