package March;

public class code_160 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p1 = headA;
        int len1 = 0;
        ListNode p2 = headB;
        int len2 = 0;

        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 != null){
            len2++;
            p2 = p2.next;
        }
        int diff = 0;
        p1 = headA;
        p2 = headB;
        if(len1 > len2){
            //1先走 diff步
            diff = len1 - len2;
            while(diff > 0){
                p1 = p1.next;
                diff--;
            }
        }else{
            //2先走 diff 步
            diff = len2 - len1;
            while(diff > 0){
                p2 = p2.next;
                diff--;
            }
        }
        while(p1 != p2){
            if(p1 == null || p2 == null){
                return null;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1; 
    }
}
