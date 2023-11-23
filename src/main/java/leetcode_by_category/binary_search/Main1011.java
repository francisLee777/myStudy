package leetcode_by_category.binary_search;

public class Main1011 {


    public static void main(String[] args) {
        Main1011 main1011 = new Main1011();
        System.out.println(main1011.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
//        System.out.println(main1011.great(new int[]{1, 2, 3, 1, 2}, 3, 3));
    }

    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0, left = 0, right = 0, mid = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            max = Math.max(max, weight);
        }
        left = min;
        right = max * (weights.length / days + 1);
        while (left != right) {
            mid = left + (right - left) / 2;
            if (great(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // target 大了还是小了, 等于的话返回大了
    boolean great(int[] weights, int target, int count) {
        int tempCount = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > target) return false;
            tempCount += weights[i];
            if (i != weights.length - 1 && tempCount + weights[i + 1] > target) {
                count--;
                tempCount = 0;
                continue;
            }
            if (i == weights.length - 1) {
                count--;
            }

        }
        return count >= 0;
    }
}
