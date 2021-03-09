/*
* 给定一个二叉树和一个目标和,找到所有
* 从根节点到叶子节点路径总和等于给定目标和的路径
* */
package mianshizhinan.tree;

import java.util.ArrayList;
import java.util.List;

public class tr4 {

    public static List<List<Integer>> ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        int sum = 12;
        List<List<Integer>> res = pathSum(root, sum);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        dfs(root, sum, new ArrayList<>());
        return ans;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> temp) {
        if (root == null) {
            return;
        }
        temp.add(root.val);     // 选择当前节点
        if (root.left == null && root.right == null && sum == root.val) {   // 找到满足题意的叶子节点
            ans.add(new ArrayList<>(temp));
        }
        dfs(root.left, sum - root.val, temp);   // 对左子树进行递归遍历
        dfs(root.right, sum - root.val, temp);  // 对右子树进行递归遍历
        temp.remove(temp.size() - 1);   // 撤销当前的选择
    }
}
