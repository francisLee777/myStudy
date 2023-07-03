package leetcode_by_category.binary_search;


// 2023年06月21日22:48:36
public class Main852 {
    // 山脉数组，严格递增再严格递减。   如果有的话，那么肯定只有一个点符合条件。 且这个点大于旁边两个点。 直接二分就行

    public int peakIndexInMountainArray(int[] arr) {
        // 题目已经保证一定有正确返回值了
        int left = 1, right = arr.length - 2, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) right = mid - 1;
            else left = mid + 1;
        }
        return 0;
    }
}
