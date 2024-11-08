package Oct;

public class code_76_Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        int[] target = new int[60];
        int[] window = new int[60];
        int tLen = t.length();
        int sLen = s.length();
        for(int i=0; i<tLen; i++){
            char c = t.charAt(i);
            target[c-'A'] += 1;
        }
        
       int count = 0;
        //当count = tLen 的时候，说明窗口已经到达满足题意的最低要求； 此时我们收缩l窗口，去找最优解
        //必须要有一个window变量，记录当前窗口内合理的 元素 
        int res = Integer.MAX_VALUE;
        int startIndex = 0, endIndex = 0;
        int l = 0, r = 0;
        while(r < sLen){
            int curIndex = s.charAt(r) - 'A';

            if(target[curIndex] == 0){
                r++;
                continue;
            }else{
                if(window[curIndex] < target[curIndex]){
                    count ++;
                }
                window[curIndex] += 1;
                
                while(count == tLen){
                    int curLIndex = s.charAt(l) - 'A';
                    if(target[curLIndex] == 0){
                        l++;
                    }else{
                        if(window[curLIndex] > target[curLIndex]){
                            window[curLIndex]--;
                            l++;
                        }else{
                            window[curLIndex]--;
                            if (r - l + 1 < res) {
                                res = r - l + 1;
                                startIndex = l;
                                endIndex = r;
                            }
                            count--;
                            l++;
                        }
                    }
                }
                r++;
            }
        }

        return res == Integer.MAX_VALUE ? "" : s.substring(startIndex, endIndex + 1);
    }
    public static void main(String args[]){
        minWindow("ADOBECODEBANC", "ABC");
    }

}
