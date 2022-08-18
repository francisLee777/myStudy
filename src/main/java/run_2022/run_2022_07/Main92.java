package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/10 22:02
 */
public class Main92 {
    static class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,   ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        // 归并排序
        if (head == null || head.next == null) return head;
        // 找中间节点，快慢指针
        ListNode fast = head.next.next, slow = head, temp;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        temp = slow.next;
        slow.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(temp);
        ListNode newHead = new ListNode(0),temp2 = newHead;
        while(head1 != null && head2 != null){
            if (head1.val < head2.val){
                temp2.next = head1;
                head1 = head1.next;
            }else{
                temp2.next = head2;
                head2 = head2.next;
            }
            temp2 = temp2.next;
        }
        if(head1 != null ) temp2.next = head1;
        if (head2 != null ) temp2.next = head2;
        return newHead.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPar = dummy;
        int tempLeft = left;
        while(tempLeft > 1){
            leftPar = leftPar.next;
            tempLeft--;
        }
        int count = right-left;
        if(count == 0) return dummy.next;
        ListNode tempPar = leftPar.next;
        ListNode cur = leftPar.next.next;
        ListNode temp;
        while(cur != null && count != 0){
            temp = cur.next;
            cur.next = tempPar;
            tempPar = cur;
            cur = temp;
            count--;
        }
            leftPar.next.next = cur;
        leftPar.next = tempPar;
        return dummy.next;
    }


    public static void main(String[] args) {

    }
}
