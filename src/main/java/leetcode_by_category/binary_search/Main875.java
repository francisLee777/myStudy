package leetcode_by_category.binary_search;

public class Main875 {

    public static void main(String[] args) {
        Main875 main875 = new Main875();
        System.out.println(main875.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        // 找一下最大值
        int max = 0;
        long sum = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
            sum += pile;
        }
        int right = max, left = sum % h == 0 ? (int) (sum / h) : (int) (sum / h + 1), mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (fun(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int fun(int[] piles, int mid) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile % mid == 0 ? pile / mid : pile / mid + 1;
        }
        return sum;
    }

}
