package run_2022.run_2022_08;

/**
 * @author lihaoyu
 * @date 2022/8/14 16:54
 */
public class Main318 {
    public static int maxProduct(String[] words) {
    int[] nums = new int[words.length];
        for (int j = 0; j < words.length; j++) {
            for (int i = 0; i < words[j].length(); i++) {
                int temp = 1 << (words[j].charAt(i)-'a');
                if((nums[j] & temp) == 0){
                    nums[j] += temp;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if((nums[i] & nums[j] ) == 0 ){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"ab", "cdf"}));
    }

}
