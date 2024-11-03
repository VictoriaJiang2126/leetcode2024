package two;

public class code_633 {
    public static boolean judgeSquareSum(int c) {
        int l = 0;
        int curSS = 0;
        double cDouble = (double)c;
        int r = (int)Math.sqrt(cDouble) + 1;
        //7060
        //45800
        
        while( r >= l){
            if(Math.abs(l - 7060) == 1){
                int i = 1;
            }
            if(Math.abs(r - 45800) == 1){
                int i = 1;
            }
            curSS = l*l + r*r;
            if(curSS > c){
                r--;
            }else if(curSS < c){
                l++;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        System.out.println(Math.sqrt(2147483600.0));
        judgeSquareSum(2147483600);
    }
}
