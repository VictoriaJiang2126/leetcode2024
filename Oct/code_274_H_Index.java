package Oct;

import java.util.Arrays;

public class code_274_H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i=citations.length -1;
        int count = 1;
        int curC = 0;
        while(i >=0){
            curC = citations[i];
            if(curC >= count){
                i--;
                count ++;
            }else{
                break;
            }
        }
        return count -1;


    }
}
