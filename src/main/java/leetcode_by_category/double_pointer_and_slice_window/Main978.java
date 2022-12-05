package leetcode_by_category.double_pointer_and_slice_window;

public class Main978 {

    int maxTurbulenceSize(int[] arr) {
        int left = 0, right = 1, res = 1, tempRes;
        while (right < arr.length) {
            tempRes = 1;
            right = left + 1;
            if (right >= arr.length)
                return res;
            if (arr[left] == arr[right]) {
                left++;
                continue;
            }
            boolean tempBool = arr[left] > arr[right];
            right++;
            while (right < arr.length) {
                if (arr[right - 1] == arr[right] || (arr[right - 1] > arr[right]) != !tempBool)
                    break;
                tempBool = !tempBool;
                tempRes++;
                right++;
            }
            res = Math.max(res, tempRes + 1);
            left = right - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Main978 main978 = new Main978();

    }
}
