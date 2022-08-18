package algorithm.contest.review;

import java.util.Scanner;

/**
 *  逆序对个数 归排
 * @author lihaoyu
 * @date 2019/11/30 15:41
 */
public class Main1 {

    private static int count = 0;

    private static void fun(int[] a, int start, int end){
        if(start >= end) return;
        int mid = (start + end) / 2;
        fun(a,start,mid);
        fun(a,mid+1,end);
        int[] temp = new int[end - start + 1];
        int index = 0,leftStart = start, rightStart = mid + 1;
        while(leftStart <= mid && rightStart <= end){
            if(a[leftStart] <= a[rightStart]) temp[index++] = a[leftStart++];
            else {
                temp[index++] = a[rightStart++];
                count += (mid - leftStart + 1);
            }
        }
        while(leftStart <= mid) temp[index++] = a[leftStart++];
        while(rightStart <= end) temp[index++] = a[rightStart++];
        System.arraycopy(temp,0,a,start,end-start+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            count = 0;
            int N = scanner.nextInt();
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt();
            }
            fun(numbers,0,N-1);
            System.out.println(count);
        }
        }

    }

