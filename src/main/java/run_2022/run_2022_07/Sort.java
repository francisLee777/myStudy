package run_2022.run_2022_07;

/**
 * @author lihaoyu
 * @date 2022/7/7 13:56
 */
public class Sort {

    public static void quickSort(int[] array, int start, int end){
        if(array == null || array.length < end) return;
        if (start >= end) return;
        int left = start, right = end , pivot = array[start];
        while(left < right){
            while(left < right && array[right] >= pivot) right--;
            array[left] = array[right];
            while(left < right && array[left] <= pivot) left++;
            array[left] = array[right];
        }
        array[left]=pivot;
        quickSort(array,start,left-1);
        quickSort(array,left+1,end);
    }


    public static void main(String[] args) {
      int[] aaa =   new int[]{3,5,1,5,0,8,7,9};
Sort.quickSort(aaa,0,7);
        for (int i : aaa) {
            System.out.print(i+" ");
        }
    }
}
