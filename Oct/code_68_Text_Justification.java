package Oct;

import java.util.ArrayList;
import java.util.List;

public class code_68_Text_Justification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resList = new ArrayList<>();
        int nums = words.length;
        int[] lenW = new int[words.length]; // 每个words的长度
        for (int i = 0; i < words.length; i++) {
            lenW[i] = words[i].length();
        }

        int i = 0;
        while (i < nums) {
            int firstWord = i;
            int curSum = lenW[i];

            while (i + 1 < nums && curSum + lenW[i + 1] + 1 <= 16) {
                curSum = curSum + lenW[i + 1] + 1;
                i++; // 最终i位于当前行的 最后一个单词
            }

            if (i != nums - 1) {
                int thisLineNums = i - firstWord + 1; // 这一行单词数量
                if(thisLineNums != 1){ //这一行有2个及以上的单词
                    int spaceSum = maxWidth - (curSum - (thisLineNums - 1));
                    int spaceEqual = spaceSum / (thisLineNums - 1);// 每个space都有的
                    int spaceLeft = spaceSum % (thisLineNums - 1);

                    String res = "";
                    String spaceEqualString = "";
                    for (int m = 0; m < spaceEqual; m++) {
                        spaceEqualString = spaceEqualString + " ";
                    }
                    for (int j = firstWord; j <= i; j++) {
                        String curString = words[j];
                        if(j != i){
                            res = res + curString + spaceEqualString;
                        }else{
                            res = res + curString;
                        }
                        
                        if (spaceLeft != 0) {
                            res = res + " ";
                            spaceLeft--;
                        }
                    }
                    resList.add(res);
                }else{ //这一行只有一个单词
                    int rightSpace = maxWidth - words[i].length();
                    String rightSpaceString = "";
                    for (int m = 0; m < rightSpace; m++) {
                        rightSpaceString = rightSpaceString + " ";
                    }
                    String res = words[i] + rightSpaceString;
                    resList.add(res);

                }   
            } else { //最后一行
                int rightSpace = maxWidth - curSum;
                String rightSpaceString = "";
                for(int m=0; m<rightSpace; m++){
                    rightSpaceString = rightSpaceString + " ";
                }
                String res = "";
                for (int j = firstWord; j <= i; j++) {
                    String curString = words[j];
                    if(j != i){
                        res = res + curString + " ";
                    }else{
                        res = res + curString;
                    }  
                }
                res = res + rightSpaceString;
                resList.add(res);
            }    


            i++;
        }

        return resList;
    }

    public static void main(String args[]){
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        fullJustify(words, 20);
    }

}
