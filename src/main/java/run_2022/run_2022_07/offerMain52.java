package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/10 21:53
 */
public class offerMain52 {
    static class ListNode {
        int val;
      ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,  ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0 , lenB = 0;
        ListNode pA = headA, pB = headB;
        while(pA != null){
            pA = pA.next;
            lenA++;
        }
        while(pB != null){
            pB = pB.next;
            lenB++;
        }
        ListNode p1, p2;
        if (lenA >= lenB){
            p1 = headA;
            p2 = headB;
        }else{
            p2 = headA;
            p1 = headB;
        }
        for(int i = 0 ;i < Math.abs(lenA-lenB); i++){
            p1 = p1.next;
        }
        while(p1 != null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
