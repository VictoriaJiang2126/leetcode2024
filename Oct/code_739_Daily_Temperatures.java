package Oct;

import java.util.Deque;
import java.util.LinkedList;

public class code_739_Daily_Temperatures {
    // public int[] dailyTemperatures(int[] temperatures) {
    //     int i = temperatures.length - 1;
    //     int[] res = new int[temperatures.length];
    //     res[i] = 0;
    //     int maxT = temperatures[i];
    //     int maxIndex = i;
    //     //min max; 坐标
    //     i--;
    //     while(i >= 0){
    //         int curT = temperatures[i];
    //         if(curT >= maxT){
    //             res[i] = 0;
    //         }else{
    //             for(int j= i+1; j<temperatures.length; j++){
    //                 if(temperatures[j] > curT){
    //                     res[i] = j - i;
    //                     break;
    //                 }
    //             }
    //         }
    //         if(curT > maxT){
    //             maxT = curT;
    //             maxIndex = i;
    //         }
    //         i--;
    //     }
    //     return res;
    // }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();

        for(int i=0; i<temperatures.length; i++){
            int t = temperatures[i];
            //statck 中存储每个温度的 下标
            //维护了一个单调递减栈，只有当前t <= 栈顶元素时，才执行s.push(i)
            while(!stack.isEmpty() && t > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(temperatures[i]);
        }

        return res;
        
    }


}