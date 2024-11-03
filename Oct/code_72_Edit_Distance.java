package Oct;

public class code_72_Edit_Distance {
    static int[][] memo;
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 == 0 || l2 == 0){
            return Math.max(l1,l2);
        }
        memo = new int[l1+1][l2+1];
        tranverse(word1, word2);
        return memo[l1][l2];
    }

    public static int tranverse(String word1, String word2){
        if(word1.length() == 0 || word2.length() == 0){
            return Math.max(word1.length(),word2.length()); 
        }
        int s1,s2,s3,s4;
        int l1 = word1.length();
        int l2 = word2.length();
        //if 第一个字符相同相同, 除去最后第一个字符的substring
        if(word1.charAt(0) == word2.charAt(0)){
            if(memo[l1-1][l2-1] != 0){
                return memo[l1-1][l2-1];
            }else{
                s1 = tranverse(word1.substring(1), word2.substring(1));
                if(memo[l1][l2] == 0){
                    memo[l1][l2] = s1;
                }else{
                    memo[l1][l2] = Math.min(s1,memo[l1][l2]);
                }
                return memo[l1][l2];
            }
            
        }
        //添加
        if(memo[l1][l2-1] != 0){
            s2 = memo[l1][l2-1];
        }else{
            s2 = tranverse(word1,word2.substring(1));
        }
        //删除
        if(memo[l1-1][l2] != 0){
            s3 = memo[l1-1][l2];
        }else{
            s3 = tranverse(word1.substring(1),word2);
        }
        //替换
        if(memo[l1-1][l2-1] != 0){
            s4 = memo[l1-1][l2-1];
        }else{
            s4 = tranverse(word1.substring(1), word2.substring(1));
        }

        memo[l1][l2] = Math.min(Math.min(s2,s3),s4) + 1;

        return memo[l1][l2];


    }

    public static void main(String args[]){
        minDistance("rss", "ros");
    }

}

