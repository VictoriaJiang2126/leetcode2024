package Oct;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class code_329_Longest_Increasing_Path_in_a_Matrix {
    // public int longestIncreasingPath(int[][] matrix) {
    // int rows = matrix.length;
    // int columns = matrix[0].length;
    // int nums = rows * columns;
    // int[] indegree = new int[rows * columns];
    // List<ArrayList<Integer>> outdegree = new ArrayList<>();
    // for(int i=0; i<rows*columns; i++){
    // outdegree.add(new ArrayList<>());
    // }
    // for(int i=0; i<rows; i++){
    // for(int j=0; j<columns; j++){
    // int curIndex = columns * i + j;
    // //计算出度
    // if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]){
    // //上
    // int nextIndex = columns * (i-1) + j;
    // indegree[nextIndex] ++;
    // outdegree.get(curIndex).add(nextIndex);

    // }
    // if(i+1 < rows && matrix[i+1][j] > matrix[i][j]){
    // //下
    // int nextIndex = columns * (i+1) + j;
    // indegree[nextIndex] ++;
    // outdegree.get(curIndex).add(nextIndex);
    // }
    // if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
    // //左
    // int nextIndex = columns * i + (j-1);
    // indegree[nextIndex] ++;
    // outdegree.get(curIndex).add(nextIndex);
    // }
    // if(j+1 < columns && matrix[i][j+1] > matrix[i][j]){
    // //右
    // int nextIndex = columns * i + (j+1);
    // indegree[nextIndex] ++;
    // outdegree.get(curIndex).add(nextIndex);
    // }
    // }
    // }

    // Deque<Integer> q = new LinkedList<>();
    // for(int i=0; i<nums; i++){
    // if(indegree[i] == 0){
    // q.addLast(i);
    // }
    // }

    // int level = 0;
    // while(!q.isEmpty()){
    // int thisLevelCount = q.size();
    // for(int i=0; i<thisLevelCount; i++){
    // int index = q.removeFirst();
    // indegree[index] = -1;
    // for(int next : outdegree.get(index)){
    // indegree[next] --;
    // }
    // }
    // for(int i=0; i<nums; i++){
    // if(indegree[i] == 0){
    // q.addLast(i);
    // }
    // }
    // level ++;
    // }

    // return level;

    // }

    public static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 从当前节点出发的 最长路径
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dfs(matrix, i, j, rows, columns, memo);
            }
        }
        int res = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res = Math.max(res, memo[i][j]);
            }
        }
        return res;

    }

    public static int dfs(int[][] matrix, int i, int j, int rows, int columns, int[][] memo) {

        int up = 0, down = 0, left = 0, right = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            // 上
            if (memo[i - 1][j] != -1) {
                up = memo[i - 1][j];
            } else {
                up = dfs(matrix, i - 1, j, rows, columns, memo);
            }

        }
        if (i + 1 < rows && matrix[i + 1][j] > matrix[i][j]) {
            // 下
            if (memo[i + 1][j] != -1) {
                down = memo[i + 1][j];
            } else {
                down = dfs(matrix, i + 1, j, rows, columns, memo);
            }
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            // 左
            if (memo[i][j - 1] != -1) {
                left = memo[i][j - 1];
            } else {
                left = dfs(matrix, i, j - 1, rows, columns, memo);
            }

        }
        if (j + 1 < columns && matrix[i][j + 1] > matrix[i][j]) {
            // 右
            if (memo[i][j + 1] != -1) {
                right = memo[i][j + 1];
            } else {
                right = dfs(matrix, i, j + 1, rows, columns, memo);
            }
        }

        if (up != 0 || down != 0 || left != 0 || right != 0) {
            int curPath = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
            if (memo[i][j] == -1) {
                memo[i][j] = curPath;
            }
            return curPath;
        }

        memo[i][j] = 1;
        return 1;
    }


    public static void main(String args[]){
        int[][] matrix = {{7,6,1,1}, {2,7,6,0}, {1,3,5,1}, {6,6,3,2}};
        longestIncreasingPath(matrix);

    }
}
