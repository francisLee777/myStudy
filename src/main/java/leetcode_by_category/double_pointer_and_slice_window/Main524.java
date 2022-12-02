package leetcode_by_category.double_pointer_and_slice_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main524 {

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length())
                return o1.length() - o2.length();
            return -o1.compareTo(o2);
        });
        for (int i = dictionary.size() - 1; i >= 0; i--) {
            String target = dictionary.get(i);
            if (target.length() > s.length())
                continue;
            // 双指针
            int ti = 0, s1 = 0;
            while (s1 < s.length()) {
                if (s.charAt(s1) == target.charAt(ti)) {
                    ti++;
                }
                s1++;
                if (ti == target.length())
                    return target;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Main524 main524 = new Main524();
        String[] list = new String[] { "ale", "apple", "monkey", "plea" };
        System.out.println(main524.findLongestWord("abpcplea", Arrays.asList(list)));
    }

}
