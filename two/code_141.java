package two;



public class code_141 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = head;
        while(fast != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next;
            if(fast!= null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        hasCycle(n1);
    }
}
