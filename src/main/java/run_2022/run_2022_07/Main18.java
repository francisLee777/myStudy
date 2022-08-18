package run_2022.run_2022_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/7/9 20:07
 */
public class Main18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            long newTarget = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;
                long newTarget2 = newTarget - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (left != j+1 && nums[left] == nums[left-1]) {
                        left++;
                        continue;
                    }
                    if (nums[left] + nums[right] == newTarget2) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > newTarget2) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
