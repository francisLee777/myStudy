package run_2022.run_2022_07;


/**
 * @author lihaoyu
 * @date 2022/7/27 21:54
 */
public class Main211 {

    Node root = new Node();

    class Node{
        boolean flag;
        Node[] nodes = new Node[26];

    }

    // 前缀树
    public Main211() {

    }

    public void addWord(String word) {
        Node p = root;
        char []arr = word.toCharArray();
        for (char c : arr) {
            if(p.nodes[(c-'a')] == null) p.nodes[(c-'a')] = new Node();
            p = p.nodes[(c-'a')];
        }
        p.flag = true;
    }

    public boolean search2(Node p,String word,int index) {
        if(p == null  )return false;
        if(index == word.length()) return p.flag;
        char c = word.charAt(index);
        if(c != '.') return search2(p.nodes[c-'a'],word,index+1);
        for (Node node : p.nodes) {
            if(search2(node,word,index+1)) return true;
        }
        return false;
    }


    public boolean search(String word) {
return search2(root,word,0);
    }
}
