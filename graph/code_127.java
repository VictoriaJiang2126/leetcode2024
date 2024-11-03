package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int res = 1;
        HashMap<String, Boolean> graph = new HashMap<>();
        for (String s : wordList) {
            graph.put(s, false);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                String s = queue.poll();
                char[] charArr = s.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char oriChar = charArr[i];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == oriChar) {
                            continue;
                        }
                        charArr[i] = k;
                        String nextWord = String.valueOf(charArr);
                        // 存在当前key 且 没有被visisted过
                        if (graph.containsKey(nextWord) && !graph.get(nextWord)) {
                            if(nextWord.equals(endWord)){
                                return res+1;
                            }
                            graph.put(nextWord, true);
                            queue.add(nextWord);

                        }
                    }
                    charArr[i] = oriChar;
                }
            }
            res++;
        }

        return 0;
    }

}
