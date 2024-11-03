package two;

import java.util.HashSet;

public class code_345 {
    public static String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        char[] charArr = s.toCharArray();
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while(r >= l){
            
            while(l < n && !set.contains(charArr[l])){
                l++;
            }
            while(r > 0 && !set.contains(charArr[r])){
                r--;
            }
            if(r >= l){
                char tmp = charArr[l];
                charArr[l] = charArr[r];
                charArr[r] = tmp;
                l++;
                r--;
            } 
        }
        return new String(charArr);
    }
    public static void main(String args[]){
        reverseVowels(" ");
    
    }
}
