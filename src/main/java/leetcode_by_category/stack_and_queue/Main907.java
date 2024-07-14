package leetcode_by_category.stack_and_queue;

import java.util.Stack;

public class Main907 {

    public static void main(String[] args) {
        Main907 main907 = new Main907();
        System.out.println(main907.sumSubarrayMins(new int[]{1, 2, 1}));
    }

    public int sumSubarrayMins(int[] arr) {
        // 左边和右边第一个小于它的 位置下标， 单调栈
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        //
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 遇到小于的了
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.add(i);
        }
        // 结束的时候都赋值 len
        while (!stack.isEmpty()) {
            left[stack.pop()] = arr.length;
        }
        stack.clear();
        // 反过来
        for (int i = arr.length - 1; i >= 0; i--) {
            // 遇到小于的了
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.add(i);
        }
        // 结束的时候都赋值 len
        while (!stack.isEmpty()) {
            right[stack.pop()] = -1;
        }

        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (res + ((((long) (left[i] - i)) * ((long) (i - right[i])) % 100000007) * ((long) (arr[i]))) % 100000007) % 100000007;
        }
        return (int) res;
    }
}
