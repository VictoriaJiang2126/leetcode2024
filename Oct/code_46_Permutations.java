package Oct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class code_46_Permutations {
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    // boolean[] isVisited;
    // public List<List<Integer>> permute(int[] nums) {
    // isVisited= new boolean[nums.length];

    // backtrack(nums);
    // return res;
    // }
    boolean[] isVisited;
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        res = new LinkedList<>();
        path = new LinkedList<>();

        backtrack(nums);

        return res;
        
    }

    public void backtrack(int[] nums) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(isVisited[i] == false){
                isVisited[i] = true;
                path.add(nums[i]); 

                backtrack(nums);

                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }   
    }

}
