package Oct;

import java.util.Arrays;

public class code_72_Edit_Distance {

    public static int minDistance(String word1, String word2) {

        int[][] memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        dfs(0, 0, word1, word2, 0, memo);
        return memo[word1.length() - 1][word2.length() - 1];

    }

    public static void dfs(int w, int t, String word1, String word2, int step, int[][] memo) {
        if (t == word2.length()) {
            // minStep = Math.min(minStep, step + (word1.length() - w));
            memo[word1.length() - 1][word2.length() - 1] = Math.min(memo[word1.length() - 1][word2.length() - 1],
                    step + (word1.length() - w));
            return;

        }
        if (w == word1.length()) {
            // minStep = Math.min(minStep, step + (word2.length() - t));
            memo[word1.length() - 1][word2.length() - 1] = Math.min(memo[word1.length() - 1][word2.length() - 1],
                    step + (word2.length() - t));
            return;

        }

        int curW = word1.charAt(w);
        int curT = word2.charAt(t);
        if(step >= memo[w][t]){
            return;
        }else{
            memo[w][t] = step;
            if (curW == curT) {
                w++;
                t++;
                dfs(w, t, word1, word2, step, memo);
                memo[w][t] = Math.min(step, memo[w][t]);
            } else {
                memo[w][t] = Math.min(step + 1, memo[w][t]);
                // delete
                w++;
                dfs(w, t, word1, word2, step + 1, memo);
                w--;
    
                // insert
                t++;
                dfs(w, t, word1, word2, step + 1, memo);
                t--;
    
                // replace
                w++;
                t++;
                dfs(w, t, word1, word2, step + 1, memo);
                w--;
                t--;
            }
        }

    }

    // static int[][] memo;
    // public static int minDistance(String word1, String word2) {
    // int l1 = word1.length();
    // int l2 = word2.length();
    // if(l1 == 0 || l2 == 0){
    // return Math.max(l1,l2);
    // }
    // memo = new int[l1+1][l2+1];
    // tranverse(word1, word2);
    // return memo[l1][l2];
    // }

    // public static int tranverse(String word1, String word2){
    // if(word1.length() == 0 || word2.length() == 0){
    // return Math.max(word1.length(),word2.length());
    // }
    // int s1,s2,s3,s4;
    // int l1 = word1.length();
    // int l2 = word2.length();
    // //if 第一个字符相同相同, 除去最后第一个字符的substring
    // if(word1.charAt(0) == word2.charAt(0)){
    // if(memo[l1-1][l2-1] != 0){
    // return memo[l1-1][l2-1];
    // }else{
    // s1 = tranverse(word1.substring(1), word2.substring(1));
    // if(memo[l1][l2] == 0){
    // memo[l1][l2] = s1;
    // }else{
    // memo[l1][l2] = Math.min(s1,memo[l1][l2]);
    // }
    // return memo[l1][l2];
    // }

    // }
    // //添加
    // if(memo[l1][l2-1] != 0){
    // s2 = memo[l1][l2-1];
    // }else{
    // s2 = tranverse(word1,word2.substring(1));
    // }
    // //删除
    // if(memo[l1-1][l2] != 0){
    // s3 = memo[l1-1][l2];
    // }else{
    // s3 = tranverse(word1.substring(1),word2);
    // }
    // //替换
    // if(memo[l1-1][l2-1] != 0){
    // s4 = memo[l1-1][l2-1];
    // }else{
    // s4 = tranverse(word1.substring(1), word2.substring(1));
    // }

    // memo[l1][l2] = Math.min(Math.min(s2,s3),s4) + 1;

    // return memo[l1][l2];

    // }

    public static void main(String args[]) {
        minDistance("se", "so");
    }

}
