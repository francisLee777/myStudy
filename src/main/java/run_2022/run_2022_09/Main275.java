package run_2022.run_2022_09;

import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2022/9/24 21:54
 */
public class Main275 {

    public int hIndex(int[] citations) {
        int max = citations[citations.length -1];
        int min = 0;
        // 贰分
        while(max != min){
            int mid = (max + min) >> 1;
if (temp(mid,citations)) {
    if (!temp(mid+1,citations)) return mid;
    min = mid+1;
}else{
    max = mid-1;
}
        }
        return max;
    }

    boolean temp(int h,int[] citations){
     // 找第一个大于等于 h 的下标
        int start =0, end = citations.length - 1;
        if(h > citations[end]) return false;
int mid  =0;
        while(start <= end){
              mid = (start+end)>>1;
            if(citations[mid] >= h){
                if(mid == 0 || citations[mid-1] < h){
                    break;
                }
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return  citations.length - mid >= h;
    }


    public static void main(String[] args) {
        System.out.println(new Main275().hIndex(new int[]{11,15}));
    }
}
