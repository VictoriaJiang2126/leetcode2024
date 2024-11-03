package Oct;

import java.util.Deque;
import java.util.LinkedList;

public class code_155_Min_Stack {
    public static  class MinStack {
        Deque<Integer> stack;
        int size;
        Deque<Integer> minStack;

        public MinStack() {
            this.stack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            this.size = 0;
        }
        
        public void push(int val) {
            this.size += 1;
            this.stack.addLast(val);

            if(size == 1){
                this.minStack.addLast(val);
            }else{
                if(val >= this.minStack.getLast()){
                    this.minStack.addLast(this.minStack.getLast());
                }else{
                    this.minStack.addLast(val);
                }
            }
        }
        
        public void pop() {
            this.size -= 1;
            this.stack.removeLast();
            this.minStack.removeLast();
        }
        
        public int top() {
            return this.stack.getLast();
            
        }
        
        public int getMin() {
            return this.minStack.getLast();
        }
    }

    public static void main(String args[]){
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        s.getMin();
    }
}
