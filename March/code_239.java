package March;

import java.util.PriorityQueue;

public class code_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));//最大堆
        int[] res = new int[nums.length - k + 1];
        int resCount = 0;
        int l=0, r=0;
        while(r < nums.length){
            
            int[] cur = new int[2];
            cur[0] = r;
            cur[1] = nums[r];
            pq.add(cur);

            while(r - pq.peek()[0] > k-1){
                pq.poll();
            }
            if(r >= k-1){
                res[resCount] = pq.peek()[1];
                resCount++;
            }

            r++;
        }
        return res;



        
    }
}
