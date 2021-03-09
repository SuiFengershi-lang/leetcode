/*
* 给定一个二叉树,检查它是否是镜像对称的
* */
package mianshizhinan.tree;

public class tr2 {

    public static void main(String[] args) {    // 递归
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        System.out.println(isSymmetric(root));
    }

    public static class TreeNode {  // 树节点
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {    // 左右节点都为空
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
