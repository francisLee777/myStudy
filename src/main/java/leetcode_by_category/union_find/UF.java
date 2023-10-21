package leetcode_by_category.union_find;

/**
 * 并查集 终版  https://mp.weixin.qq.com/s/mFLCL_Dyz5-CtZMZJmOXKw
 * @author lihaoyu
 * @date 2022/12/12 13:27
 */
public class UF {

    // 每个节点的父节点
    int[] parent;
    // 连通分量个数
    int count;


    // 构造函数， n 为节点个数
    public UF(int n){
        count = n;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    // 返回某个节点的根节点， 路径压缩[递归]
    int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    // 把 p 和 q 连接
    void union(int p, int q){
        // 先找到两个节点的根节点
        int rootQ = find(q);
        int rootP = find(p);
        if(rootQ == rootP) return;
        // 正反都行
        parent[rootQ] = rootP;
        count--;
    }

    // 判断 p 和 q 是否连接
    boolean connected(int p,int q){
        // 两个节点的根节点是否相同
        return find(q) == find(q);
    }

    // 有多少连通分量
    int count(){
        return count;
    }

}
