package leetcode_by_category.double_pointer_and_slice_window;

/**
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * @author lihaoyu
 * @date 2022/11/2 21:17
 */
public class Main86 {

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), big = new ListNode(0);
        ListNode smallCur = small, bigCur = big;
        while(head != null){
            if (head.val >= x){
                bigCur.next = head;
                bigCur = bigCur.next;
            }else{
                smallCur.next = head;
                smallCur = smallCur.next;
            }
            // 断链
            ListNode temp  = head.next;
            head.next = null;
            head = temp;
        }
        // 首尾连起来
        smallCur.next = big.next;
        return small.next;
        }



    public static void main(String[] args) {

    }
}
