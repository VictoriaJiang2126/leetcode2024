package slidingwindow;

import java.util.HashMap;

public class code_3{
    //无重复最长子串
    // public static int lengthOfLongestSubstring(String s) {
    //     if (s.length()==0) return 0;
    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    //     int max = 0;
    //     int l = 0;
    //     for(int r = 0; r < s.length(); r++){
    //         if(map.containsKey(s.charAt(r))){
    //             //l = Math.max(l,map.get(s.charAt(r)) + 1);
    //             l = map.get(s.charAt(r)) + 1;
    //         }
    //         map.put(s.charAt(r),r);
    //         max = Math.max(max,r-l+1);
    //     }
    //     return max;
        
    // }

    public static int lengthOfLongestSubstring(String s){
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0, r=0;

        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r))+1,l);
            }
            map.put(s.charAt(r),r);
            max = Math.max(max,r-l+1);
            r++;
        }

        return max;
    }

    public static void main(String args[]){
        //String s = "pwabw";
        //String s = "abcabcbb";

        String s = "abba";//这个用例解释了为什么
        System.out.println(lengthOfLongestSubstring(s));

    }




}