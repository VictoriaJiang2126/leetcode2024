package two;

public class code_21 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode dummyHead1 = new ListNode(-1);
        dummyHead1.next = list1;
        ListNode pre = dummyHead1;
        ListNode p2 = list2;
        while(p1!=null || p2!=null){
            if(p1.val < p2.val){
                p1 = p1.next;
                pre = pre.next;
            }else{
                pre.next = p2;
                ListNode tmp = p2;
                p2 = p2.next;
                tmp.next = p1;
                pre = pre.next;
            }
        }
        if(p1 == null){
            p1.next = p2;
            return p1;
        }else{
            return p1;
        }
    }
}
