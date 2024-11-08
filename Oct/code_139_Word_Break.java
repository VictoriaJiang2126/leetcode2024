package Oct;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

// public class code_139_Word_Break {
//     boolean flag = false;
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String> set = new HashSet<>();
//         for(String word : wordDict){
//             set.add(word);
//         }   
//         boolean[][] memo = new boolean[s.length()+1][s.length()+1];
//         helper(0,s,memo,set);
//         return flag;
//     }
//     public void helper(int i, String s, boolean[][]memo, HashSet<String> set){
//         if(i >= s.length()){
//             return;
//         }
//         int start = i;
//         //（限制end 条件 [ )
//         for(int end = i + 1; end <= s.length(); end++){
//             String sub = s.substring(start, end);
//             if(memo[start][end] == true){
//                 helper(end, s, memo,set);
//             }
//             else if(set.contains(sub)){
//                 memo[start][end] = true;
//                 helper(end, s, memo,set);
//                 if(end == s.length()){
//                     flag = true;
//                     return;
//                 }
//             }
//             if(flag == true){
//                 return;
//             }
//         }
//         return;
//     }
// }

public class code_139_Word_Break {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}



