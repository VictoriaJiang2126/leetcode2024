package Oct;

public class code_160 {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode dummyHeadA = new ListNode(-1);
        dummyHeadA.next = headA;
        ListNode dummyHeadB = new ListNode(-1);
        dummyHeadB.next = headB;
        ListNode p1 = dummyHeadA;
        ListNode p2 = dummyHeadB;
        while(p1 != null){
            lenA++;
        }
        while(p2 != null){
            lenB++;
        }
        if(lenA > lenB){
            return find(dummyHeadA,dummyHeadB,lenA-lenB);
        }else{
            return find(dummyHeadB, dummyHeadA, lenB-lenA);
        }
    }

    public static ListNode find(ListNode fastNode, ListNode slowNode, int diff){
        ListNode fast = fastNode;
        ListNode slow = slowNode;
        while(diff != 0){
            fast = fast.next;
        }
        while(fast != null){
            if(fast == slow){
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }

}
