package Oct;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class code_239_Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //PriorityQueue<Integer> pQueue = new PriorityQueue<>(k, (n1, n2)->(n2 - n1));
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(k, (n1, n2)->(n2[1] - n1[1]));
        int l=0;
        int r=0;
        int n = nums.length;
        int[] res = new int[n - (k-1)];
        int resIndex = 0;

        while(r < n){
            int[] cur = new int[2];
            cur[0] = r;
            cur[1] = nums[r];
            pQueue.add(cur);
            if(r - l == (k-1)){
                while(!pQueue.isEmpty() && (r - pQueue.peek()[0]) > (k-1)  ){
                    pQueue.remove();
                }
                res[resIndex++] = pQueue.peek()[1];
                l++;
            }
            r++;
        }

        return res;

    }
    public static void main(String agrs[]){
        int[] x = {1,-1};
        maxSlidingWindow(x,1);
    }
}
