package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//https://www.bilibili.com/video/BV1H34y1E7Ao/?spm_id_from=333.337.search-card.all.click&vd_source=3b5289b64f49a8c9842175c409fbaa53
//133. 克隆图
public class code_133 {
    //深拷贝类题目都可以用HashMap新旧（表格）之间映射关系来解决
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,map);
        return map.get(node);
        
    }
    public static void dfs(Node node, HashMap<Node,Node> map){ 
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        for(Node nextNode : node.neighbors){
            //避免陷入嵌套！
            if(!map.containsKey(nextNode)){
                dfs(nextNode,map);
            }   
            //Node n = map.get(node);
            Node nnext = map.get(nextNode);
            newNode.neighbors.add(nnext);
        }
    }

    public static void main(String args[]){
        Node node1 = new Node(1,new ArrayList<Node>());
        Node node2 = new Node(2,new ArrayList<Node>());
        Node node3 = new Node(3,new ArrayList<Node>());
        Node node4 = new Node(4,new ArrayList<Node>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);        
        node2.neighbors.add(node1);        
        node2.neighbors.add(node3);       
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);        
        node4.neighbors.add(node1);        
        node4.neighbors.add(node3);    

        cloneGraph(node1);
    }
}
