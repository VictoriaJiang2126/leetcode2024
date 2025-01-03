package Oct;

import java.util.HashMap;

public class code_3_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        //aaaa -> 1:a
        //xxabcdaxx -> 5:xabcd
        //空 -> 0

        int n = s.length();
        int maxLen = 0;//最长字串的长度
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0; 
        int r = 0;
        while( r < n){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);

            if(map.get(c) > 1){
                maxLen = Math.max(maxLen, r-l);
                while(map.get(c) > 1){
                    char lChar = s.charAt(l);
                    map.put(lChar, map.get(lChar) - 1);
                    l++;
                }
            }
            r++;
        }

        return maxLen;  
    }

    public static void main(String args[]){
        lengthOfLongestSubstring("abxdex");
    }
}
