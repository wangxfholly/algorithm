package org.learn.tree;

/**
 * 判断二叉树是否是对称树
 */
public class SymmetricTree {

    synchronized
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    public static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean compareOutSide = compare(left.left, right.right);
        boolean compareInSide = compare(left.right, right.left);
        return compareOutSide && compareInSide;

    }
}
