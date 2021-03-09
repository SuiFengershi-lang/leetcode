/*
* 给定一个二叉树和一个目标和,判断该树中是否存在
* 根节点到叶子节点的路径,这条路径上所有节点值相加等于目标和
* */
package mianshizhinan.tree;

public class tr3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        int sum = 11;
        System.out.println(hasPathSum(root, sum));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {  // 该节点为根节点
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
