package run_2022.run_2022_07;



/**
 * @author lihaoyu
 * @date 2022/7/9 23:32
 */
public class Main25 {

   static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public ListNode reverseSingle(ListNode head){
       if (head == null || head.next == null) return head;
         ListNode newHead = reverseSingle(head.next);
         head.next.next = head;
         head.next = null;
         return newHead;
     }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int i = 1;
        ListNode p = head;
        while(p != null && i != k){
            p = p.next;
            i++;
        }
        if (p == null){
            return head;
        }
        ListNode temp = p.next;
        p.next = null;
        ListNode newHead = reverseSingle(head);
       head.next =  reverseKGroup(temp,k);
        return newHead;
    }


    public static void main(String[] args) {

    }
}
