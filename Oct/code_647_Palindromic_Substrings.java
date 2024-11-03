package Oct;

public class code_647_Palindromic_Substrings {

    public static int countSubstrings(String s) {
        char[] c = s.toCharArray();
        if (c.length <= 1) {
            return c.length;
        }
        int res = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            res += isPalindromic(i, -1, c);// 以一个字符为中心点
            if (i < n - 1) {
                res += isPalindromic(i, i + 1, c); // 以2个字符为中心点
            }
        }

        return res;

    }

    public static int isPalindromic(int c0, int c1, char[] c) {
        int n = c.length;
        int l;
        int r;
        int count = 0;
        if (c1 != -1) {  // 以一个字符为中心点
            l = c0;
            r = c0 + 1;
        } else { //以2个字符为中心点
            l = c0;
            r = c0;
        }

        while (l >= 0 && r < n ) {
            if (c[l] == c[r]) {
                l--;
                r++;
                count++;
            } else {
                return count;
            }
        }

        return count; 
    }

    public static void main(String args[]){
        countSubstrings("abc");
    }
}
