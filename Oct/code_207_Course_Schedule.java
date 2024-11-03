package Oct;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class code_207_Course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int indergree[] = new int[numCourses]; //入度 个数
        ArrayList<ArrayList<Integer>> outdegree = new ArrayList<>(); //出去的边

        for(int i=0; i<numCourses; i++){
            outdegree.add(new ArrayList<>());
        }
        
        for(int i=0; i<prerequisites.length; i++){
            int curCourse = prerequisites[i][0];
            indergree[curCourse] += 1;
            int nextCourse = prerequisites[i][1];
            outdegree.get(nextCourse).add(curCourse);
        }

        Deque<ArrayList<Integer>> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indergree[i] == 0){
                queue.add(outdegree.get(i));
                indergree[i] --;
            }
        }
        while(!queue.isEmpty()){
            ArrayList<Integer> c = queue.pollFirst();
            for(int out : c){
                indergree[out] --;
            }
            for(int i=0; i<numCourses; i++){
                if(indergree[i] == 0){
                    queue.add(outdegree.get(i));
                    indergree[i] --;
                }
            }
        }
        for(int i=0; i<numCourses; i++){
            if(indergree[i] != -1){
                return false;
            }
        }
        return true;

    }

    public static void main(String args[]){
        int[][] prerequisites = {{1,0}};
        canFinish(2, prerequisites);
    }
}
