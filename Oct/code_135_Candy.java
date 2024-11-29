package Oct;

import java.util.Arrays;

public class code_135_Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=0; i<n; i++){
            if(i+1 < n){
                if(ratings[i+1]>ratings[i]){
                    res[i+1] = res[i] + 1;
                }else{
                        res[i+1] = 1;
                }
            }
            if(i-1>=0 && ratings[i-1] > ratings[i] && res[i-1] <= res[i]){
                res[i-1] = res[i] + 1;
            }
        }

        for(int i=n-1; i>=0; i--){
            if(i-1 >= 0){
                if(ratings[i-1] > ratings[i] && res[i-1] <= res[i]){
                    res[i-1] = res[i] + 1;
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            count = count + res[i];
        }
        return count;
    }

    public static void main(String args[]){
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }
}
