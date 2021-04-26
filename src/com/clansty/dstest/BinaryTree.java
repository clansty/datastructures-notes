package com.clansty.dstest;

/**
 * 二叉查找树
 */
public class BinaryTree {
    TreeNode root = null;

    public void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }

    public void printInorder() {
        printInorder(root);
    }

    private void printInorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printInorder(node.left);
            printInorder(node.right);
        }
    }

    public void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPostorder(node.left);
            printPostorder(node.right);
        }
    }

    public int findMax() {
        return findMax(root);
    }

    /**
     * 用递归来实现的找最大值
     *
     * @param node 递归要传入的当前处于的那个节点
     * @return 找到的最大值
     */
    private int findMax(TreeNode node) {
        if (node.right != null)
            return findMax(node.right);
        else
            return node.value;
    }

    /**
     * 用不递归的方法实现找最小值。根据调用栈来说这个方法会快点
     *
     * @return 找到的最小值
     */
    public int findMin() {
        var node = root;
        while (node.left != null)
            //只要当前位置有左子节点，就把当前的位置移到那个左子节点上
            node = node.left;
        return node.value;
    }

    public boolean contains(int value) {
        return contains(value, root);
    }

    /**
     * 这是递归查找是否存在某个数，最好的情况 O(log n)
     *
     * @param value 要找的数
     * @param node  递归要传入的当前处于的那个节点
     * @return 是否存在
     */
    private boolean contains(int value, TreeNode node) {
        if (node == null)
            return false;
        if (value < node.value)
            return contains(value, node.left);
        else if (value > node.value)
            return contains(value, node.right);
        else // (value == node.value)
            return true;
    }
}
