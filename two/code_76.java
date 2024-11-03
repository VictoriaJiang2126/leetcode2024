package two;

public class code_76 {
    public static String minWindow(String s, String t) {
        int[] sArray = new int[58];
        int[] target = new int[58];
        int m = s.length();
        int n = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            target[t.charAt(i) - 'A'] += 1;
        }
        int l = 0, r = 0;
        // sArray :A[], B[], C[], D[]..., a[],b[]...
        // target :A[1], B[1], C[1], D[0]..., a[0],b[0]...
        while (r != m) {
            // 1. move the r to find the valid substring
            int rChar = s.charAt(r) - 'A';
            if (target[rChar] == 0) {
                r++;
                continue;
            } else {
                sArray[rChar] += 1;
                // 2. move the l to find the best substring
                while (checkCharCount(sArray, target)) {
                    // Update the result
                    if (r - l + 1 < minLength) {
                        minLength = r - l + 1;
                        startIndex = l;
                        endIndex = r;
                    }
                    int lChar = s.charAt(l) - 'A';
                    sArray[lChar] -= 1;
                    l++;
                }
                r++;
            }     
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, endIndex+1);
    }

    public static boolean checkCharCount(int[] sArray, int[] target) {
        for (int i = 0; i < sArray.length; i++) {
            if (target[i] > 0) {
                if (target[i] > sArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        // A-Z -> a-z
        int a = 'Z';//A:65,Z:90,  a: 97, z:122; 
        
        System.out.println(a);
    }
}
