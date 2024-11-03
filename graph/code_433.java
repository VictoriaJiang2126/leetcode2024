package graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class code_433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Deque<String> queue = new LinkedList<>();
        int res = 0;
        Set<String> visited = new HashSet<>();

        if(!bankContains(endGene, bank) || startGene.equals(endGene) ){
            return -1;
        }

        queue.addLast(startGene);
        visited.add(startGene);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                String s = queue.poll();
                if(s.equals(endGene)){
                    return res;
                }
                for(int j= 0; j<bank.length; j++){
                    if(canMutate(s, bank[j]) && !visited.contains(bank[j])){
                        queue.addLast(bank[j]);
                        visited.add(bank[j]);
                    }
                 }
            }
            res++;   
        }

        return -1;
    }

    private boolean canMutate(String s1, String s2){
        int counter = 0;
        for(int i=0; i< s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                counter++;
            }
        }
        return counter==1;
    }

    private boolean bankContains(String endGene, String[] bank){
        for(String s: bank){
            if(s.equals(endGene)){
                return true;
            }
        }
        return false;
    }

}
