package temp;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @author lihaoyu
 * @date 2022/7/8 00:04
 */
public class Main1333 {

    private static boolean fun(int[] num, int start, int end){
        if (start >= end ) return true;
        // end 是根节点, 找第一个大于它的
        int index = end;
        for(int i = start; i < end ; i++){
            if(num[i] > num[end]) {index = i;break;};
        }
        // 两边要划分清
        for(int i = start; i < index; i++){
            if(num[i] > num[end]) return false;
        }
        for(int i = index+1; i < end; i++){
            if(num[i] < num[end]) return false;
        }
        return fun(num,start, index-1) && fun(num,index,end-1);
    }

    public static boolean verifyPostorder(int[] postorder) {
        return fun(postorder,0, postorder.length-1);
    }

    public static void main(String[] args) {
        System.out.println(Main1333.verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }
}
