package leetcode_by_category.random;

import java.util.Random;

public class Main382 {

    static class Solution {

        ListNode root;
        Random random = new Random();

        Solution(ListNode head) {
            root = head;
        }

        public int getRandom() {
            ListNode cur = root;
            int res = root.val;
            int count = 1;
            while (cur != null) {
                if (random.nextInt(count++) == 0) {
                    res = cur.val;
                }
                cur = cur.next;
            }
            return res;
        }
    }


}
