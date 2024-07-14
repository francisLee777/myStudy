package algorithm.leetcode;


// 60. 排列序列
/*
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
 */
public class Main60 {

    int target = 0;
    int k = 0;

    public static void main(String[] args) {
        Main60 main60 = new Main60();
        System.out.println(main60.getPermutation(5, 2));
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    String fun(int[] a, int i, String res) {
        if (i >= a.length) {
            if (target == k) {
                return res;
            }
            return "";
        }
        for (int j = i; j < a.length; j++) {
            swap(a, i, j);
            target++;
            String temp = fun(a, i + 1, res + a[i]);
            if (!temp.equals("")) {
                return temp;
            }
            swap(a, i, j);
        }
        return "";
    }

    public String getPermutation(int n, int k) {
        this.k = k;
        int[] a = new int[n];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = i;
        }
        return fun(a, 0, "");
    }
}
