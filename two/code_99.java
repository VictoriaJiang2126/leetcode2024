package two;

public class code_99 {
    public static int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int l = 0;
        int r = x;
        while(r >= l){
            int mid = l + (r-l)/2;
            if(mid > x / mid){
                r = mid - 1;
            }else if(mid < x / mid ){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return r;
    }
    public static void main(String args[]){
        mySqrt(2147395599);
    }
}
