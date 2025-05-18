package Jan25;

public class code_684_Redundant_Connection {
    //题目暗暗要求了，给的输入edges最多只有一个环；当输入为[[1,2],[2,3],[1,3],[3,4],[1,4]]，系统就会报错
    //无向无环图
    public int[] findRedundantConnection(int[][] edges) {
        /*
         * 分析题意，本题目是要找到图中形成环的最后一条边，换句话，我的结构初始无重叠节点，当一个节点，刚次连接有N - 1 条边
         * 一旦连接有了第二条边，N 个点形成 N 条边。显然这边加入的边不属于树。即欲去掉这边。
         * 经典解法有并查集 和 dfs 算法。
         */
        // 图示中节点数量是edges的个数
        int nodesCount = edges.length;
        // 初始化节点间的关系表格，但是这个表格是从0开始的。N个对象是N - 1的下标位置。为了保证一致性，数组1
        int[] parent = new int[nodesCount + 1];
        // 在parent数组中初始化每一个节点
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        // 逐项判断edges二维数组中的每一对节点是否之间可能已经有一个连接分支上，不是最短连通线，这样
        // 肯恩出现的可以描述到了（冗余）
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                // 如果两个节点不在同一个连通分量上，证明没有连接通。将他们进行连接即可。
                union(parent, node1, node2);
            } else {
                // 已经说明这两个已经连接了，已经在一个连通分量了，说明这条边就是我们需要找的冗余的一个边。直接返回
                return edge;
            }
        }
        // 如果不存在冗余的连接，返回空数组指示边界中没有多余的边界
        return new int[] {0, 0};
    }

    // 查找当前节点的根节点
    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    // 合并两个节点到同一个集合，我们只让index2节点的根节点指向index1节点的根节点（即将index2的根节点放在index1的根节点下面）
    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = parent[find(parent, index2)];
    }
    public static void main(String args[]){
        code_684_Redundant_Connection x = new code_684_Redundant_Connection();
        int[][] egde = {{1,2},{2,3},{1,3}};
        int[] res = x.findRedundantConnection(egde);
        for(int i : res){
            System.out.println(i+",");
        }
        
    }
}
