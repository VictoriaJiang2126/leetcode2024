package Oct;

import java.util.HashSet;

public class code_208_Implement_Trie {
    public class Trie{
        HashSet<String> strings;
        public Trie(){
            this.strings = new HashSet<>();
        }
        public Trie(String word){
            this.strings = new HashSet<>();
            this.strings.add(word);
        }
        public void insert(String word){
            this.strings.add(word);
        }
        public boolean search(String word){
            return this.strings.contains(word);
        }
        public boolean startsWith(String prefix){
            for(String s : strings){
                boolean flag = true;
                int i = 0;
                for(int j=0; j<s.length() && i < prefix.length(); j++,i++){
                    if(s.charAt(j) != prefix.charAt(i)){
                        flag = false;
                    }
                }  
                if(flag == true && i == prefix.length()){
                    return true;
                }

            }
            return false;
        }
    }


    public static void main(String args[]){
        code_208_Implement_Trie x = new code_208_Implement_Trie();
        Trie t = x.new Trie("apple");
        t.startsWith("app");


    }

}
