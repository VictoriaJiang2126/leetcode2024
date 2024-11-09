package Oct;

public class code_25_Reverse_Nodes_in_k_Group {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }
    static ListNode resHead = null;

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        
        ListNode h = null;
        ListNode t = null;
        ListNode lastTail = null;
        boolean flag = true;
        while( p!= null && flag == true){ //之后考虑要不要加一个break
            //1. 总长度 < k
            // 2. 总长度 > k (最后一组不翻转)
            // 3. 总长度 = k

            //2.3
            h = p;
            int i;
            for(i=0; i< k-1 && p.next!=null; i++){ // 考虑 p= null
                p = p.next;
            }
            if(i != k-1){ //当前阶段节点不足 k个， 不用反转了
                if(lastTail != null){
                    lastTail.next = h;
                }
                flag = false;
                
            }else{
                t = p;
                p = p.next; //p 位于下一阶段的头节点
                reverseLink(h, t);
                if(lastTail != null){
                    lastTail.next = t; // 反转后，t变成h；h变成t
                }
                lastTail = h;
                

            }
        }


        //1. 
        if(resHead != null){
            return resHead;
        }else{
            return head;
        }
    }

    //
    public static void reverseLink(ListNode head, ListNode tail){
        int count = 1;
        ListNode p1 = head; 
        ListNode p2 = head.next;

        while(p1!= tail){
            ListNode temp = p2.next;
            p2.next = p1;
            if(count == 1){
                p1.next = null;
                count--;
            }
            p1 = p2;
            p2 = temp;
        }

        if(resHead == null){
            resHead = tail;
            //更新resHead， 第一个反转过后的头节点
        }

        return;
    }

    public static void main(String args[]){
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(3);
        p1.next.next.next = new ListNode(4);

        reverseKGroup(p1, 3);
    }
}
