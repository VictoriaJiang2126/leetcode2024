package slidingwindow;

public class code_424 {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxCount = -1; //当前窗口内 出现最多的字符的 个数
        if(s.length()<2){
            return s.length();
        }
        int res = 0;
        //窗口内字符串个数 = right-left+1
        while(right < s.length()){
            int curChar = s.charAt(right) - 'A';
            freq[curChar]+=1;
            maxCount = Math.max(freq[curChar],maxCount);
            
            if(maxCount + k < right - left + 1){
                freq[s.charAt(left)-'A']--;
                left++;
            }else{
                res = right - left + 1;
            }
            right++;
        }
        return res;
    }
}
