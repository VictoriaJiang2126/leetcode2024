package Oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//"barfoofoobarthefoobarman"
public class code_30_Substring_with_Concatenation_of_All_Words {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int l = 0;
        int r = 0;
        int len = words[0].length();
        int count = 0;
        int wordsNum = words.length; //共有多少个单词
        while(r < s.length()){
            String subS = s.substring(r, r+len);
            
            while(r < s.length() && map.get(subS)!= null && map.get(subS) != 0){
                if(r == 13){
   
                    System.out.println("here");
                    
                }
                count ++;
                r = r+len;
                map.put(subS, map.get(subS)-1);
                if(r+len <= s.length()){
                    subS = s.substring(r, r+len);
                }
                
            }
            
            //此时的subS 是 r 所指的位置
            if(map.get(subS) == null){
                while(l < r){
                    if(count == wordsNum){
                        res.add(l);
                    }
                    String subL = s.substring(l, l+len);
                    count--;
                    map.put(subL, map.get(subL) + 1);
                    l = l + len;
                }
                r = r + len;
                l = r;
                continue;
            }
            while(map.get(subS) == 0){
                if(count == wordsNum){
                    res.add(l);
                }
                String subL = s.substring(l, l+len);
                count--;
                map.put(subL, map.get(subL) + 1);
                l = l + len;
            } 
        }
        return res;
    }
    public static void main(String args[]){
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        findSubstring(s, words);
    }
}
