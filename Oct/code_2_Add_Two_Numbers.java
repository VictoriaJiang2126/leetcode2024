package Oct;

public class code_2_Add_Two_Numbers {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = null;
        ListNode resP = res;

        int curSum, resSum;
        int plus = -1;

        while(p1 != null && p2 != null){
            if(plus == -1 ){
                curSum = p1.val + p2.val;
            }else{
                curSum = p1.val + p2.val + plus;
            }
            resSum = curSum % 10; //本层
            if(res == null){
                res = new ListNode(resSum);
                resP = res;
            }else{
                resP.next = new ListNode(resSum);
                resP = resP.next;
            }
            plus = curSum / 10; //给下一层
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode left;
        if(p1 == null){
            left = p2;
        }else{
            left = p1;
        }

        
        while(left != null){
            curSum = left.val + plus;
            resSum = curSum % 10; //本层
            resP.next = new ListNode(resSum);
            resP = resP.next;
            left = left.next;

            plus = curSum / 10;

        }

        if(plus != 0){
            resP.next = new ListNode(plus);
        }

    
        return res;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        addTwoNumbers(l1,l2);
    }


}
