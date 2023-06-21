package leetcode_by_category.tree.tire;


// 前缀树


import java.util.ArrayList;
import java.util.List;

public class Main648 {

    static Node root = new Node(' ');

    public static void main(String[] args) {
        List<String> temp = new ArrayList<>();
        temp.add("a");
        temp.add("aa");
        temp.add("aaa");
        temp.add("aaaa");
        System.out.println(replaceWords(temp, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }

    // 一个字符串和树匹配的最短子串, 如果没有返回原字符串
    static String isInTree(String str) {
        Node temp = root;
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // 不存在了直接停
            if (temp.children[str.charAt(i) - 'a'] == null) {
                break;
            }
            sb.append(temp.children[str.charAt(i) - 'a'].c);
            if (temp.children[str.charAt(i) - 'a'].isEnd) {
                return sb.toString();
            }
            temp = temp.children[str.charAt(i) - 'a'];
        }
        return str;
    }

    // 插入字符串，构建一个树
    static void build(String str) {
        Node temp = root;
        for (int i = 0; i < str.length(); i++) {
            if (temp.children[str.charAt(i) - 'a'] == null) {
                // 需要加入节点
                temp.children[str.charAt(i) - 'a'] = new Node(str.charAt(i));
            }
            // 末尾需要置结束符
            if (i == str.length() - 1) {
                temp.children[str.charAt(i) - 'a'].isEnd = true;
            }
            temp = temp.children[str.charAt(i) - 'a'];
        }
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        root = new Node(' ');
        String[] split = sentence.split(" ");
        dictionary.forEach(s -> build(s));
        for (int i = 0; i < split.length; i++) {
            split[i] = isInTree(split[i]);
        }
        return String.join(" ", split);
    }

    static class Node {
        char c;
        boolean isEnd; // 是否是结束符
        Node[] children = new Node[26]; // 子节点

        public Node(char s) {
            c = s;
        }
    }
}
