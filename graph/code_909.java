package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_909 {
    // https://bilibili.com/video/BV1yq4y1L7Dv/?spm_id_from=333.337.search-card.all.click&vd_source=3b5289b64f49a8c9842175c409fbaa53
    public static int snakesAndLadders(int[][] board) {
        HashMap<Integer, int[]> graph = new HashMap<>();
        int n = board.length;
        HashSet<Integer> visited = new HashSet<>();
        // create the graph
        boolean toRight = (n % 2 == 0) ? true : false;
        int num = n * n;
        for (int i = 0; i < n; i++) {
            if (toRight) {
                for (int j = 0; j < n; j++) {
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    graph.put(num, pos);
                    num--;
                }
                toRight = !toRight;
            } else {
                for (int j = n - 1; j > -1; j--) {
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    graph.put(num, pos);
                    num--;
                }
                toRight = !toRight;
            }
        }
        // bfs graph
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        visited.add(1);
        while (!queue.isEmpty()) {
            int[] curQueue = queue.poll();
            int curNum = curQueue[0];
            int nowStep = curQueue[1];
            visited.add(curNum);
            if (curNum == n * n) {
                return nowStep;
            }
            for (int i = 1; i <= 6; i++) {
                int nextNum = curNum + i;
                if(nextNum <= n*n){
                    int nextRow = graph.get(nextNum)[0];
                    int nextColumn = graph.get(nextNum)[1];
                    int nextIndex = board[nextRow][nextColumn] != -1 ? board[nextRow][nextColumn] : nextNum;
                    if(!visited.contains(nextIndex)){
                        visited.add(nextIndex);
                        queue.add(new int[]{nextIndex,nowStep+1});
                    }
                }
                
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x[][] = { { -1, -1 }, { -1, 3 } };
        System.out.println(snakesAndLadders(x));
    }

}
