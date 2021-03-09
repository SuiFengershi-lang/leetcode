/*
* 给定两个二叉树,编写一个函数来检验它们是否相同
* */
package mianshizhinan.tree;

public class tr1 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        System.out.println(isSameTree(p, q));
    }

    public static class TreeNode {  // 树节点
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {   // 两个都为空节点
            return true;
        }
        if (p == null || q == null) {   // 两个节点有一个为空
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);  // 递归进行判断
    }
}
