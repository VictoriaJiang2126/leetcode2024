package Oct;

public class code_206_Reverse_Linked_List {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode dummuyHead = null;
        ListNode p1 = dummuyHead;
        ListNode p2 = head;
        while(p2 != null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp; 
        }
        
        return p1;
    }

    public static void main(String args[]){
        ListNode p = new ListNode(1);
        
        ListNode p2 = new ListNode(2);
        p.next = p2;
        reverseList(p);
    }
}
