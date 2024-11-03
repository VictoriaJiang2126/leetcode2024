package two;

import java.util.LinkedList;
import java.util.List;

public class code_524 {
    static int longestL = -1;
    static String res = "";

    public static String findLongestWord(String s, List<String> dictionary) {
        for (String target : dictionary) {
            int curL = isSubString(target, s);

            if (curL != -1) {
                if(curL > longestL){
                    res = target;
                    longestL = curL;
                }else if(curL == longestL){
                    for(int i=0; i<longestL; i++){
                        //target : abb
                        // res: abc
                        if(target.charAt(i) - res.charAt(i) > 0){
                            break; 
                        }else if(target.charAt(i) - res.charAt(i) == 0){
                        }else{
                            res = target;
                            break;
                        }
                    }
                   
                }
                
            }
        }

        return longestL == -1 ? "": res; 
    }

    public static int isSubString(String target, String s) {
        int i=0, j=0;
        while(i<s.length() && j<target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        if(j == target.length()){
            return target.length();
        }else{
            return -1;
        }
    }

    public static void main(String args[]){
        String s = "wordgoodgoodgoodbestword";
        List<String> dic = new LinkedList<>();
        dic.add("word");
        dic.add("good");
        dic.add("best");
        dic.add("good");
        findLongestWord(s,dic);
    }
}
