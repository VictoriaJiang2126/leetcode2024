package Oct;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class code_207_Course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> outdegree = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            outdegree.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int first = prerequisites[i][1];
            int next = prerequisites[i][0];
            outdegree.get(first).add(next);
            indegree[next]++;
        }

        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.addLast(i);
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.pollFirst();
                indegree[cur] = -1;
                for(int next : outdegree.get(cur)){
                    indegree[next] --;
                    if(indegree[next] == 0){
                        queue.addLast(next);
                    }
                }
            }   
        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i] != -1){
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
