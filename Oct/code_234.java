package Oct;

import java.util.ArrayList;

public class code_234 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        ArrayList<Integer> copy = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            copy.add(p.val);
            p = p.next;
        }
        int i=0, j = copy.size()-1;
        while( j>=i ){
            if(copy.get(i) != copy.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
