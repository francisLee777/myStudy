package leetcode_by_category.double_pointer_and_slice_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList();
        // 先找第一个大于或者等于 x 的下标
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                right = mid;
                left = mid;
                break;
            } else if (arr[mid] > x)
                right = mid;
            else
                left = mid + 1;
        }
        left--; // 找到了，两边扩展

        while (k != 0) {
            if (left >= 0 && right < arr.length && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)
                    || right >= arr.length) {
                res.add(arr[left]);
                left--;
            } else if (left >= 0 && right < arr.length && Math.abs(arr[left] - x) > Math.abs(arr[right] - x)
                    || left < 0) {
                res.add(arr[right]);
                right++;
            }
            k--;
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }

    public static void main(String[] args) {
        Main658 main658 = new Main658();
        System.out.println(main658.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
    }

}
