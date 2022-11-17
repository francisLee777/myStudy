package leetcode_by_category.double_pointer_and_slice_window;

/**
 * 接雨水     双指针写法
 * @author lihaoyu
 * @date 2019/12/25 12:22
 */
public class Main42 {

    public static int trap2(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0,left = 0 ,right = height.length-1,leftMax = 0, rightMax = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                res += Math.max(0,leftMax - height[left]);
                leftMax = Math.max(leftMax,height[left]);
                left++;
            }else{
                res += Math.max(0,rightMax - height[right]);
                rightMax = Math.max(rightMax,height[right]);
                right--;
            }
        }
        return res;
    }


    public static int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0, len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int tempLeftMax = Integer.MIN_VALUE;
        int tempRightMax = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            tempLeftMax = Math.max(tempLeftMax,height[i]);
            leftMax[i] = tempLeftMax;
        }
        for(int i = len - 1; i >= 0; i--){
            tempRightMax = Math.max(tempRightMax,height[i]);
            rightMax[i] = tempRightMax;
        }
        for(int i = 1; i < len - 1; i++){
            if(leftMax[i] >= height[i] && rightMax[i] >= height[i]){
                res += Math.min(leftMax[i],rightMax[i]) - height[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
