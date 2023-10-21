package leetcode_by_category.linked_list;

/**
 * @author lihaoyu
 * @date 2022/12/7 13:54
 */
public class Main234 {

    ListNode cur;
    boolean flag = true;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        cur = head;
        // 找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fun(slow);
        return flag;
    }

    public void fun(ListNode root) {
        if (!flag || cur == root || root == null) return;
        fun(root.next);
        if (cur.val != root.val) {
            flag = false;
        } else {
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        ListNode node4 = new ListNode(1,null);
        ListNode node3 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        Main234 main234 = new Main234();
        System.out.println(main234.isPalindrome(node1));
    }
}
