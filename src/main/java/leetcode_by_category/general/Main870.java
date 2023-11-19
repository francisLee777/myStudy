package leetcode_by_category.general;

import java.util.*;

/*
优势洗牌
给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
示例 1：
输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
输出：[2,11,7,15]
示例 2：
输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
输出：[24,32,8,12]
 */
public class Main870 {

    public static void main(String[] args) {
        Main870 main870 = new Main870();
        main870.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            list.add(new Node(i, nums2[i]));
        }
        Collections.sort(list);
        Node[] nodes = new Node[nums2.length];
        list.toArray(nodes);
        List<Node> res = new ArrayList<>();
        int i = nums1.length - 1, j = i;
        while (i >= 0) {
            while (j >= 0 && nums1[i] <= nodes[j].value) j--;
            if (j < 0) break;
            res.add(new Node(nodes[j].index, nums1[i]));
            i--;
            j--;
        }
        // i 是剩余的上限
        res.sort(Comparator.comparingInt(o -> o.index));
        int[] result = new int[nums1.length];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (Node re : res) {
            result[re.index] = re.value;
        }
        for (int k = 0; k < result.length; k++) {
            if (result[k] == Integer.MIN_VALUE) {
                result[k] = nums1[i--];
            }
        }
        return result;
    }

    class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
