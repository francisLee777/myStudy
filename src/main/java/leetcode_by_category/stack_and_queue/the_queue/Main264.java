package leetcode_by_category.stack_and_queue.the_queue;

// 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//丑数 就是质因子只包含 2、3 和 5 的正整数。
public class Main264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1));
        System.out.println(nthUglyNumber(2));
        System.out.println(nthUglyNumber(3));
        System.out.println(nthUglyNumber(4));
        System.out.println(nthUglyNumber(5));
    }

    static int pow(int a, int b) {
        double c = Math.pow(a, b);
        return (int) c;
    }

    static int nthUglyNumber(int n) {
        // 三路归并
        int[] indexList = new int[3];
        int res = 1;
        while (n > 0) {
            // 找三路中最小的
            int two = pow(2, (indexList[0] + 1)) * pow(3, indexList[1]) * pow(5, indexList[2]);
            int three = pow(2, indexList[0]) * pow(3, (indexList[1] + 1)) * pow(5, indexList[2]);
            int five = pow(2, indexList[0]) * pow(3, indexList[1]) * pow(5, (indexList[2] + 1));
            int temp = Math.min(two, Math.min(three, five));
            if (temp == two) {
                indexList[0]++;
            } else if (temp == three) {
                indexList[1]++;
            } else {
                indexList[2]++;
            }
            n--;
        }
        return pow(2, (indexList[0])) * pow(3, indexList[1]) * pow(5, indexList[2]);
    }
}
