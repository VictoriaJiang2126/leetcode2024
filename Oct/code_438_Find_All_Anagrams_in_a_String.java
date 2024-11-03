package Oct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class code_438_Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0) + 1);
        }
        char[] sArr = s.toCharArray();
        int l = 0;
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new LinkedList<>();
        //找到起始点
        for(int i=0; i<sLen; i++){
            if(map.containsKey(sArr[i])){
                l = i;
                map.put(sArr[i], map.get(sArr[i]) - 1);
                count ++;
                break;
            }
        }
        int r = l + 1;
        while(r < sLen){
            if(count == pLen){
                res.add(l);
            }
            //合理
            char cur = sArr[r];
            if(map.containsKey(cur) && map.get(cur)!= 0){
                count ++;
                map.put(cur, map.get(cur) - 1);
                r++;
            }else{
            //不合理: 收缩l直到窗口内元素合理
                //当前元素不存在
               if(!map.containsKey(cur)){
                //收缩l到r处
                while(l<r){
                    map.put(sArr[l], map.get(sArr[l]) + 1);
                    count --;
                    l++;
                }
                r++;
                l = r;
               }else{
                //当前元素存在，但是数量超了
                //收缩l至第一个当前元素后一位，r位置不变
                if(sArr[l] == cur){
                    map.put(sArr[l], map.get(sArr[l]) + 1);
                    count --;
                    l++;
                }else{
                    while(sArr[l] != cur){
                        map.put(sArr[l], map.get(sArr[l]) + 1);
                        count --;
                        l++;
                    }
                }
                
               }
            }
            
        }
        return res;

        
    }
    public static void main(String args[]){
        findAnagrams("cbaebabacd","abc");
    }
}
