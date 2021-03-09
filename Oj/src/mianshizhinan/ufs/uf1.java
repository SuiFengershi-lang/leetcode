/*
* 省份数量
* */
package mianshizhinan.ufs;

public class uf1 {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int res = findCircleNum(isConnected);
        System.out.println(res);
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.size;
    }

}

// 并查集
class UnionFind {
    int[] roots;
    int size;       // 集合数量

    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        size = n;
    }

    public int find(int i) {    // 查找父亲节点
        if (i == roots[i]) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    public void union(int a, int b) {   // 合并操作
        int faA = find(a);
        int faB = find(b);
        if (faA != faB) {
            roots[faA] = faB;
            size--;
        }
    }
}
