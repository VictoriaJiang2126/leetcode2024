package slidingwindow;

import java.util.PriorityQueue;

public class code_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int count=0;
        //维护长度为k的最大堆
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        for(int i=0; i<k; i++){
            maxHeap.add(new int[]{nums[i],i});
        }
        res[count++] = maxHeap.peek()[0];
        
        for(int i=k; i<nums.length; i++){
            maxHeap.add(new int[]{nums[i],i});

            //把不在window内的max值移除
            while(i - maxHeap.peek()[1] > k-1){
                maxHeap.poll();
            }

            res[count++] = maxHeap.peek()[0];
        }

        return res;
    }
}
