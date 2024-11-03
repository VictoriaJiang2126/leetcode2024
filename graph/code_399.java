package graph;
//https://www.bilibili.com/video/BV1XU4y1s7Lk/?spm_id_from=333.880.my_history.page.click
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
public class code_399{
    //有向图的dfs
    //1. 构建一个graph
    //2. 对于每个query<x,y>:尝试从x能不能走到y
    // 能？把算出来的值添加res
    // 不能？添加-1.0 （预先给所有答案填充-1.0）
   
    //Hash Map{key：}
    // 怎样判断x能走到y： graph traversal : DFS/BFS
    // 遍历graph 是否需要查重？ 是（有环） a/b, b/c, c/a
 
    //equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    //图 遍历考虑有环 查重 HashSet
    //递归 出口在哪/base case
 
    public static class Cell{
        String str;
        double div;

        public Cell(String str, double div){
            this.str = str;
            this.div = div;
        }
    }
 

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Cell>> graph = new HashMap<>();
        double[] res = new double[queries.size()];
        Arrays.fill(res,-1.0);
        for(int i=0; i<values.length; i++){
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double div = values[i];
            double divVerse = 1 / div;
            // if(!graph.containsKey(s1)){
            //     List<Cell> c = new LinkedList<Cell>();
            //     c.add(new Cell(s2,div));      
            //     graph.put(s2, c);
            // }else{
            //     List<Cell> c  = graph.get(s1);
            //     c.add(new Cell(s2,div));
            // }
            // if(!graph.containsKey(s2)){
            //     List<Cell> c = new LinkedList<Cell>();
            //     c.add(new Cell(s1,divVerse));      
            //     graph.put(s1, c);
            // }else{
            //     List<Cell> c  = graph.get(s2);
            //     c.add(new Cell(s1,divVerse));
            // }
            graph.computeIfAbsent(s1, k -> new LinkedList<Cell>()).add(new Cell(s2,div));
            graph.computeIfAbsent(s2, k -> new LinkedList<Cell>()).add(new Cell(s1,divVerse));
        }
        for(int i=0; i<queries.size(); i++){
            dfs(queries.get(i).get(0),queries.get(i).get(1),1.0,graph, res,i, new HashSet<String>());
        }
        return res;
    }
    public static void dfs(String src, String des, double cur, HashMap<String,List<Cell>> graph, double[] res, int index, HashSet<String> visited ){
        if(visited.contains(src)){
            return;
        }
        visited.add(src);
        if(src.equals(des) && graph.containsKey(src)){
            res[index] = cur;
        }
        for(Cell nei : graph.getOrDefault(src, new LinkedList<>())){
            dfs(nei.str, des, cur*nei.div, graph, res, index, visited);
        }

    }
    
    
 
    
 

    
}