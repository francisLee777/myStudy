package leetcode_by_category.linked_list;

/**
 * @author lihaoyu
 * @date 2022/11/16 16:00
 */
public class Main147 {

    // 4 2 1 3
    // -1111 4
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null) return head;
        ListNode dummy = new ListNode(-11111),temp,temp2,temp3;
        while(head != null){
            temp = head.next;
            // head 加入已排序的列表中
            temp2 = dummy;
            while(temp2.next != null && head.val > temp2.next.val){
                temp2 = temp2.next;
            }
            temp3 = temp2.next;
            temp2.next = head;
                head.next = temp3;
            head = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
            System.err.println("123");
    }
}
