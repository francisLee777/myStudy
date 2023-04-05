package algorithm.datastructure.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public Node() {
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.valueOf(key);
    }

    //构建二叉查找树
    public static Node Array_to_Tree(int[] a) {
        if (a.length == 0)
            return null;
        else {
            Node root = new Node(a[0]);
            for (int i = 1; i < a.length; i++)
                insert_SortTree(new Node(a[i]), root);
            return root;
        }
    }

    //插入一个节点到树中，用于构建二叉查找树
    public static void insert_SortTree(Node temp, Node root) {
        if(temp == null || root == null) return;
        if (temp.key > root.key) {
            if (root.right == null)
                root.right = temp;
            else
                insert_SortTree(temp, root.right);
        } else if (temp.key < root.key) {
            if (root.left == null)
                root.left = temp;
            else
                insert_SortTree(temp, root.left);
        }
    }

    // 构建完全二叉树
    public static Node createCompletelyTree(int[] a, int i) {
        if (i >= a.length) return null;
        Node root = new Node(a[i]);
        root.left = createCompletelyTree(a, 2 * i + 1);
        root.right = createCompletelyTree(a, 2 * i + 2);
        return root;
    }

    // 反序列化构建二叉树   数组中为0的元素代表 null
    public static Node OverSerializeTree(int[] a, int i) {
        if (i >= a.length || a[i] == 0) return null;
        Node root = new Node(a[i]);
        root.left = OverSerializeTree(a, 2 * i + 1);
        root.right = OverSerializeTree(a, 2 * i + 2);
        return root;
    }


    //递归方式先序遍历
    public static void visit_PreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.key + " ");
        visit_PreOrder(root.left);
        visit_PreOrder(root.right);
    }

    //递归方式中序遍历
    public static void visit_InOrder(Node root) {
        if (root == null)
            return;
        visit_InOrder(root.left);
        System.out.print(root.key + " ");
        visit_InOrder(root.right);
    }

    //递归方式后序遍历
    public static void visit_PostOrder(Node root) {
        if (root == null)
            return;
        visit_PostOrder(root.left);
        visit_PostOrder(root.right);
        System.out.print(root.key + " ");
    }

    //非递归方式先序遍历
    public static void visit_PreOrder_NotRecursive(Node root) {
        LinkedList<Node> linkedList = new LinkedList<>();
        while (root != null || !linkedList.isEmpty()) {
            while (root != null) {
                System.out.print(root + " ");
                linkedList.addLast(root);
                root = root.left;
            }
            if (!linkedList.isEmpty()) {
                root = linkedList.pollLast().right;
            }
        }
    }

    //非递归方式中序遍历
    public static void visit_InOrder_NotRecursive(Node root) {
        LinkedList<Node> linkedList = new LinkedList<>();
        while (root != null || !linkedList.isEmpty()) {
            while (root != null) {
                linkedList.addLast(root);
                root = root.left;
            }
            if (!linkedList.isEmpty()) {
                Node temp = linkedList.pollLast();
                System.out.print(temp + " ");
                root = temp.right;
            }
        }
    }

    //非递归方式后序遍历    两个栈 + 层次遍历
    public static void visit_PostOrder_NotRecursive(Node root) {
        if (root == null)
            return;
        LinkedList<Node> linkedList = new LinkedList<>();
        LinkedList<Node> outputList = new LinkedList<>();
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            Node node = linkedList.pollLast();
            outputList.addLast(node);
            if (node.left != null)
                linkedList.addLast(node.left);
            if (node.right != null)
                linkedList.addLast(node.right);
        }
        while (!outputList.isEmpty())
            System.out.print(outputList.pollLast() + " ");

    }

    //层序遍历   带层节点数目
    public static void visit_Level(Node root) {
        if (root == null)
            return;
        List<List<Node>> res = new ArrayList<>();
        List<Node> tempRes = new ArrayList<>();
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                Node node = linkedList.pollFirst();
                tempRes.add(node);
                if (node.left != null) linkedList.addLast(node.left);
                if (node.right != null) linkedList.addLast(node.right);
            }
            res.add(new ArrayList<>(tempRes));
            tempRes.clear();
        }
        System.out.println(res);
    }

    // 递归进行层次遍历
    public static List<List<Node>> visitLevelRecursiveList = new ArrayList<>();

    public static void visitLevelRecursive(Node root, int depth) {
        if (root == null) return;
        if (visitLevelRecursiveList.size() <= depth) {
            visitLevelRecursiveList.add(depth, new ArrayList<>());
        }
        visitLevelRecursiveList.get(depth).add(root);
        visitLevelRecursive(root.left, depth + 1);
        visitLevelRecursive(root.right, depth + 1);
    }

    //统计叶节点个数
    public static int count_LeafNode(Node root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else
            return count_LeafNode(root.left) + count_LeafNode(root.right);
    }

    //统计非叶节点个数
    public static int count_NotLeafNode(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        else
            return count_NotLeafNode(root.left) + count_NotLeafNode(root.right) + 1;

    }

    //统计所有节点个数
    public static int count_AllNode(Node root) {
        if (root == null)
            return 0;
        else
            return count_AllNode(root.left) + count_AllNode(root.right) + 1;

    }

    private static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    private static int min(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }

    //计算最大深度
    public static int depth(Node root) {
        if (root == null)
            return 0;
        else
            return max(depth(root.left), depth(root.right)) + 1;

    }

    //树的最小枝长,到叶子节点的最短路径
    public static int MinLeaf(Node root) {
        if (root == null)
            return 0;
        if (root.left == null) {
            return MinLeaf(root.right) + 1;
        }
        if (root.right == null) {
            return MinLeaf(root.left) + 1;
        } else
            return min(MinLeaf(root.left), MinLeaf(root.right)) + 1;
    }

    //复制一颗树
    public static Node CopyTree(Node root) {
        if (root == null)
            return null;
        else {
            Node temp = new Node(root.key);
            temp.left = CopyTree(root.left);
            temp.right = CopyTree(root.right);
            return temp;
        }
    }

    //交换左右子树
    public static void Swap_Tree(Node root) {
        if (root == null)
            return;
        else {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            Swap_Tree(root.left);
            Swap_Tree(root.right);
        }
    }

    // 判断两颗树是否相似
    public static boolean Tree_Like(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 != null && root2 != null && root1.key == root2.key)
            return Tree_Like(root1.left, root2.left) && Tree_Like(root1.right, root2.right);
        return false;
    }

    // 判断是否是二叉排序树
    public static boolean validateBST(Node root) {
        if (root == null) return true;
        if (root.left != null && root.left.key > root.key) return false;
        if (root.right != null && root.right.key < root.key) return false;
        boolean left = validateBST(root.left);
        if (!left) return false;
        boolean right = validateBST(root.right);
        if (!right) return false;
        return true;
    }


    //根据先序序列和中序序列建立二叉树
    public static Node createTreeBy_PreOrder_and_InOrder(int[] pre, int[] in, int start_pre, int start_in, int len) {
        if (len <= 0) return null;
        Node root = new Node(pre[start_pre]);
        int index = 0;
        for (int i = start_in; i < start_in + len; i++) {
            if (in[i] == root.key) {
                index = i;
                break;
            }
        }
        int leftLen = index - start_in;
        int rightLen = len - leftLen - 1;
        root.left = createTreeBy_PreOrder_and_InOrder(pre, in, start_pre + 1, start_in, leftLen);
        root.right = createTreeBy_PreOrder_and_InOrder(pre, in, start_pre + leftLen + 1, index + 1, rightLen);
        return root;
    }

    //根据后序序列和中序序列建立二叉树
    public static Node createTreeBy_InOrder_and_PostOrder(int[] in, int[] post, int start_in, int end_post, int len) {
        if (len <= 0) return null;
        Node root = new Node(post[end_post]);
        int index = 0;
        for (int i = start_in; i < start_in + len; i++) {
            if (in[i] == root.key) {
                index = i;
                break;
            }
        }
        int leftLen = index - start_in;
        int rightLen = len - leftLen - 1;
        root.left = createTreeBy_InOrder_and_PostOrder(in, post, start_in, end_post - 1 - rightLen, leftLen);
        root.right = createTreeBy_InOrder_and_PostOrder(in, post, index + 1, end_post - 1, rightLen);
        return root;
    }

    //根据层序序列和中序序列建立二叉树
    public static Node createTreeBy_InOrder_and_LevelOrder(int[] levelOrder, int[] inOrder, int start_inOrder,
                                                           int end_inOrder) {
        if (start_inOrder >= end_inOrder)
            return null;
        Node root = null;
        boolean stop = false;
        int i = 0, j = start_inOrder;
        for (i = 0; i < levelOrder.length && !stop; i++) {
            for (j = start_inOrder; j < end_inOrder && !stop; j++) {
                if (inOrder[j] == levelOrder[i]) {
                    root = new Node(inOrder[j]);
                    stop = true;
                }
            }
        }
        root.left = createTreeBy_InOrder_and_LevelOrder(levelOrder, inOrder, start_inOrder, j - 1);
        root.right = createTreeBy_InOrder_and_LevelOrder(levelOrder, inOrder, j, end_inOrder);
        return root;
    }

    // 根据前序和后序遍历返回 任一符合的 二叉树
    public static Node createTreeBy_PreOrder_and_PostOrder(int[] pre, int[] post,
                                                           int start_pre, int end_pre, int start_post) {
        if (start_pre > end_pre) return null;
        Node root = new Node(pre[start_pre]);
        if (start_pre == end_pre) return root;
        int index = 0;
        for (int i = 0; i < post.length; i++) {
            if (post[i] == pre[start_pre + 1]) {
                index = i;
                break;
            }
        }
        int len = index - start_post + 1;
        root.left = createTreeBy_PreOrder_and_PostOrder(pre, post, start_pre + 1, start_pre + len, start_post);
        root.right = createTreeBy_PreOrder_and_PostOrder(pre, post, start_pre + 1 + len, end_pre, start_post + len);
        return root;
    }

     // 根据先序和 排序二叉树条件 ， 构造二叉树
     public Node createBinaryTreeByInOrder(int[] preorder, int start, int end) {
        if(start > end) return null;
        Node root = new Node(preorder[start]);
        // index 是左子树的最后一个 index
        int index = end;
         for (int i = start; i <= end; i++) {
             if(preorder[i] > preorder[start]){
                 index = i - 1;
                 break;
             }
         }
         root.left = createBinaryTreeByInOrder(preorder, start+1, index);
         root.right = createBinaryTreeByInOrder(preorder, index+1, end);
        return root;
     }

    //只访问叶子节点
    public static void visit_LeafNode(Node root) {
        if (root == null)
            return;
        if (root.right == null && root.left == null)
            System.out.print(root + " ");
        visit_LeafNode(root.left);
        visit_LeafNode(root.right);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + key;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (key != other.key)
            return false;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        return true;
    }

    //根据值获取一个节点的引用
    static Node findNode(Node root, int key) {
        if (root == null) return null;
        if (root.key == key) return root;
        Node res1 = findNode(root.left, key);
        if (res1 != null) return res1;
        Node res2 = findNode(root.right, key);
        if (res2 != null) return res2;
        return null;
    }

    /*
     * 寻找一个节点到根节点的路径
     * 为了偷懒使用了全局变量
     */
    static ArrayList<Node> arrayList_findPathNodeToRoot = new ArrayList<>();
    private static ArrayList<Node> temp_findPathNodeToRoot = new ArrayList<>();

    static void findPathNodeToRoot(Node root, Node node) {
        if (root == null) return;
        temp_findPathNodeToRoot.add(root);
        if (root == node) {
            //注意这里要复制一份temp保存起来，防止在回溯过程中其中的引用被改变
            arrayList_findPathNodeToRoot = new ArrayList<>(temp_findPathNodeToRoot);
            return;
        }
        findPathNodeToRoot(root.left, node);
        findPathNodeToRoot(root.right, node);
        temp_findPathNodeToRoot.remove(temp_findPathNodeToRoot.size() - 1);
    }

    /*
     * 寻找一个树中两个任意节点的公共父节点
     * 思想是用刚才的"寻找一个节点到根节点的路径"
     * 问题转化为求两条链表的第一个公共交点（这里是顺序表，但是差不多）
     */
    public static Node findParent(Node root, Node node1, Node node2) {
        //这里因为list是全局static变量，使用前要清空一下
        arrayList_findPathNodeToRoot.clear();
        temp_findPathNodeToRoot.clear();
        findPathNodeToRoot(root, node1);
        ArrayList<Node> list1 = new ArrayList<>(arrayList_findPathNodeToRoot);
        arrayList_findPathNodeToRoot.clear();
        temp_findPathNodeToRoot.clear();
        findPathNodeToRoot(root, node2);
        ArrayList<Node> list2 = new ArrayList<>(arrayList_findPathNodeToRoot);
        //下面开始
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (i == list1.size() - 1 || i == list2.size() - 1) return list1.get(i);
            if (list1.get(i + 1) != list2.get(i + 1)) return list1.get(i);
        }

        return list1.get(list1.size() - 1);
    }

    /*
     * 寻找节点和为target的路径
     * 为了偷懒使用了全局变量
     */
    public static ArrayList<ArrayList<Node>> arrayList_findSumPath = new ArrayList<>();
    public static ArrayList<Node> temp_findSumPath = new ArrayList<>();

    public static void findSumPath(Node root, int target) {
        if (root == null)
            return;
        temp_findSumPath.add(root);
        target = target - root.key;
        if (target == 0) {
            arrayList_findSumPath.add(new ArrayList<>(temp_findSumPath));
        }
        findSumPath(root.left, target);
        findSumPath(root.right, target);
        temp_findSumPath.remove(temp_findSumPath.size() - 1);
    }

    //获取节点深度，用于判断该二叉树是否是平衡二叉树的函数
    //注意及时return 剪枝手法
    private static int getDepth(Node root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    //判断该二叉树是否是平衡二叉树
    public static boolean isBalanced(Node root) {
        return getDepth(root) != -1;
    }

    // 求公共父节点  刺激三连
    private static Node findParent2(Node root, Node node1, Node node2) {
        if (root == null || root == node1 || root == node2) return root;
        Node left = findParent2(root.left, node1, node2);
        Node right = findParent2(root.right, node1, node2);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    // 求最大通路的长度 hard
    static int maxRoute = 0;

    static int maxRoute(Node root) {
        if (root == null) return 0;
        int left = maxRoute(root.left);
        int right = maxRoute(root.right);
        maxRoute = Math.max(left + right + 1, maxRoute);
        return Math.max(left, right) + 1;
    }

    // 求最大路径和  非常刺激
    // LeetCode 困难级别
    private static int maxPathSum = Integer.MIN_VALUE;

    private static int maxPathSumFun(Node node) {
        if (node == null) return 0;
        int left = Math.max(maxPathSumFun(node.left), 0);
        int right = Math.max(maxPathSumFun(node.right), 0);
        maxPathSum = Math.max(maxPathSum, node.key + left + right);
        return node.key + Math.max(left, right);
    }

    // 左视图, 先序遍历
    static ArrayList<Node> leftSee = new ArrayList<>();
    static void leftSee(Node node, int depth) {
        if (node == null) return;
        if (leftSee.size() <= depth) {
            leftSee.add(node);
        }
        leftSee(node.left, depth + 1);
        leftSee(node.right, depth + 1);
    }

    // 二叉排序树中第 k 小数
    private static int kMinFindIndex = 0;

    public static void kMinFind(Node root, int target) {
        if (root == null) return;
        kMinFind(root.left, target);
        if (kMinFindIndex++ == target) {
            System.out.println(root);
            return;
        }
        kMinFind(root.right, target);
    }

    public static class Res{
        // 以根节点开始  最长递增和递减路径长
        int incLen;
        int decLen;

        public Res(int incLen, int decLen) {
            this.incLen = incLen;
            this.decLen = decLen;
        }
    }
    public static int maxResLen = 1;
    // 返回的是单边的最长递增和递减路径的长度
    public static Res singleEdgeIncreaseOrDecrease(Node root){
        if(root == null) return new Res(0,0);
        if(root.right == null && root.left == null) return new Res(1,1);
        Res left = singleEdgeIncreaseOrDecrease(root.left);
        Res right = singleEdgeIncreaseOrDecrease(root.right);
        if(root.key == 5){
            System.out.println();
        }
        Res res;
        // 左右子树有空的
        if(root.left == null){
            if(root.key <= root.right.key){
                res =  new Res(right.incLen+1,1);
            }else {
                res =  new Res(1, right.decLen + 1);
            }
            maxResLen = Math.max(maxResLen, Math.max(res.decLen, res.incLen));
            return res;
        }
        if(root.right == null){
            if(root.key <= root.left.key){
                res = new Res(left.incLen+1,1);
            }else {
                res =  new Res(1, left.decLen + 1);
            }
            maxResLen = Math.max(maxResLen, Math.max(res.decLen, res.incLen));
            return res;
        }
        // 左右子树都不为空
        int max = Math.max(root.left.key, root.right.key);
        int min = Math.min(root.left.key, root.right.key);
        // 比左右子树都小
        if(root.key < min){
            res =  new Res(left.incLen > right.incLen ? left.incLen + 1: right.incLen + 1, 1);
            maxResLen = Math.max(maxResLen, Math.max(left.incLen, right.incLen) + 1);
            return res;
        }else if(root.key > max){
            res =  new Res(1, left.decLen > right.decLen ? left.decLen + 1 : right.decLen + 1);
            maxResLen = Math.max(maxResLen, Math.max(left.decLen, right.decLen) + 1);
            return res;
        }
        // 在中间
        if(root.key >= root.left.key && root.key <= root.right.key){
            res = new Res(left.decLen+1, right.incLen+1);
            maxResLen = Math.max(maxResLen, left.incLen + right.decLen + 1);
        }else {
            res = new Res(left.incLen+1, right.decLen+1);
            maxResLen = Math.max(maxResLen, left.decLen + right.incLen + 1);
        }
        return res;
    }



    // 2022.10.4  Morris 莫里斯遍历   非递归遍历 空间复杂度 O(1) 时间复杂度 O(n)
    // https://zhuanlan.zhihu.com/p/530701788
    public static void MorrisPreVisit(Node root){
        Node cur = root, mostRight = null;
        while (cur != null) {
            // 找左子树的最右子节点
            if (cur.left != null){
                mostRight = cur.left;
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                // 第一次经过 cur
                if(mostRight.right == null){
                    mostRight.right = cur;
                    // 遍历输出
                    System.out.println(cur.key);
                    // 移动 cur 节点
                    cur = cur.left;
                }else{
                    // 第二次经过 cur,  把之前叶节点增加的right指针还原为null
                    mostRight.right = null;
                    cur = cur.right;
                }
            }else{
                // 到达最左的叶子节点了
                System.out.println(cur.key);
                cur = cur.right;
            }
        }
    }

}

public class TreeTest {

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 7, 2, 4, 6, 10};
        int[] serializable = {1, 2, 3, 0, 0, 4, 0};
        Node root;
        root = Node.createCompletelyTree(a, 0);
        Node.singleEdgeIncreaseOrDecrease(root);
        System.out.println("最长递增的长度是："+ Node.maxResLen);
        root = Node.OverSerializeTree(serializable, 0);
        root = Node.Array_to_Tree(a);
        Node.kMinFind(root, 4);

        System.out.print("左视图为 : ");
        Node.leftSee(root, 0);
        Node.leftSee.forEach(s -> System.out.print(s.key + " "));
        System.out.println();
        System.out.print("中序遍历结果为:");
        Node.visit_InOrder_NotRecursive(root);
        System.out.println();
        System.out.print("后序遍历结果为:");
        Node.visit_PostOrder_NotRecursive(root);
        System.out.println();
        System.out.print("递归进行层次遍历结果为 : ");
        Node.visitLevelRecursive(root, 0);
        System.out.println(Node.visitLevelRecursiveList);
        System.out.print("层次遍历结果为:");
        Node.visit_Level(root);
        System.out.print("从左到右遍历叶子节点结果为:");
        Node.visit_LeafNode(root);
        System.out.println();
        System.out.print("所有节点总数为:" + Node.count_AllNode(root));
        System.out.println("  叶子节点总数为:" + Node.count_LeafNode(root));
        System.out.print("非叶子节点总数为:" + Node.count_NotLeafNode(root));
        System.out.print("最小枝长为:" + Node.MinLeaf(root));
        System.out.println("  数的高度为:" + Node.depth(root));
        Node root2 = Node.CopyTree(root);
        System.out.print("交换左右子树后层次遍历结果为:");
        Node.Swap_Tree(root2);
        Node.visit_Level(root2);

        System.out.print("两个树是否相等:" + Node.Tree_Like(root, root2));

        System.out.print("由前序和中序确定的二叉树的后序遍历为 : ");
        Node r1 = Node.createTreeBy_PreOrder_and_InOrder(new int[]{2, 3, 4, 5, 6}, new int[]{4, 3, 5, 2, 6}, 0, 0,
                5);
        Node.visit_PostOrder(r1);
        System.out.println();
        System.out.print("由中序和后序确定的二叉树的前序遍历为 : ");
        Node r2 = Node.createTreeBy_InOrder_and_PostOrder(new int[]{4, 3, 5, 2, 6}, new int[]{4, 5, 3, 6, 2}, 0,
                4, 5);
        Node.visit_PreOrder(r2);
        System.out.println();
        System.out.print("由层序和中序确定的二叉树的后序遍历为 : ");
        Node r3 = Node.createTreeBy_InOrder_and_LevelOrder(new int[]{1, 2, 3, 4, 5}, new int[]{2, 4, 1, 5, 3}, 0,
                5);
        Node.visit_PostOrder(r3);
        System.out.println();
        System.out.print("由 先序 和 后序 构造的 任一 二叉树的中序遍历为：");
        Node r4 = Node.createTreeBy_PreOrder_and_PostOrder(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}
                , 0, 6, 0);
        Node.visit_InOrder(r4);
        System.out.println();
        System.out.print("路径和为12的路径有：");
        Node.findSumPath(root, 12);
        for (ArrayList<Node> temp : Node.arrayList_findSumPath) {
            for (Node i : temp)
                System.out.print(i.key + "  ");
            System.out.print(" # ");
        }
        System.out.println();
        System.out.println("获取值为1的节点：" + Node.findNode(root, 1));
        System.out.print("从根节点到节点2的路径为：");
        Node.findPathNodeToRoot(root, Node.findNode(root, 2));
        for (Node i : Node.arrayList_findPathNodeToRoot) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("节点2和节点6的公共父节点为：" + Node.findParent(root, Node.findNode(root, 2), Node.findNode(root, 10)));

        Node.maxRoute(root);
        System.out.println("最大通路为：" + Node.maxRoute);
    }

}
