package two;

import java.util.HashMap;

public class lintcode_1375 {
    public static long kDistinctCharacters(String s, int k) {
        int n = s.length();
        long substringCount = 0;
        HashMap<Character, Integer> char2num = new HashMap<>();
        for(int i=0; i<n; i++){
            //1. the shortest substring contains at least k different characters
            //char2num.computeIfAbsent(s.charAt(i), 0:char2num.get(s.charAt(i)+1));
            char2num.clear();
            int charCount;
            for(int j=i; j<n; j++){
                char2num.put(s.charAt(j),char2num.getOrDefault(s.charAt(i), 0)+1);
                charCount = char2num.size();
                if(charCount == k ){
                    //2. sum the n-j
                    substringCount = substringCount + (n - j);
                    break;
                }
            }
            
        }
        System.out.println(substringCount); 
        return substringCount;
    }

    public static void main(String args[]){
        String s = "abcabcabcabc";
        kDistinctCharacters(s,3);
    }
}
