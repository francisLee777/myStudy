package leetcode_by_category.double_pointer_and_slice_window;

import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/11/14 21:35
 */
public class Main475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        if (houses.length == 0 || heaters.length == 0) return 0;
        for (int house : houses) {
            // 找两边的加热器，取最小的那个
            int a = funMax(heaters,house),temp1 = Integer.MAX_VALUE,temp2 = temp1;
            if (a != -1){
                temp1 = heaters[a] - house;
            }
            a = funMin(heaters,house);
            if (a != -1){
                temp2 = house-heaters[a];
            }
            res = Math.max(res,Math.min(temp1,temp2));
        }
        return res;
    }


    // 最后一个小于等于的下标，如没有，返回-1   src 已经排序过了
    int funMin(int []src , int target){
        int start = 0, end = src.length-1, mid;
        while(start < end){
            mid = (start + 1+end) /2 ;
            if(src[mid] <= target){
               start = mid;
            }else{
                end = mid-1;
            }
        }
        return src[start] <= target ? start : -1;
    }

    // 第一个大于等于的下标，如没有，返回-1   src 已经排序过了
    int funMax(int []src , int target){
        int start = 0, end = src.length-1, mid;
        while(start < end){
            mid = (end+ start) /2 ;
            if(src[mid] >= target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return src[start] >= target ? start : -1;
    }

    public static void main(String[] args) {
 Main475 main475 = new Main475();
        System.out.println(main475.findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}));
        System.out.println(main475.funMin(new int[]{499,500,501}, 999));
    }
}

// [282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]
//[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]