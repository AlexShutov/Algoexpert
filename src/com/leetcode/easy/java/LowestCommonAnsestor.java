package com.leetcode.easy.java;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor a = new LowestCommonAncestor();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // p and q is in a diffeerent branches of root, root is a lowest common ancestor
        return root;
    }

     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
