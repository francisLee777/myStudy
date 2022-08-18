package run_2022.run_2022_08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2022/8/14 22:46
 */
public class Main89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            int size = list.size();
            for (int j = size-1; j >=0 ; j--) {
                int temp = list.get(j);
                list.add(temp + (1 << (i-1)));
            }
        }

    return list;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
}
