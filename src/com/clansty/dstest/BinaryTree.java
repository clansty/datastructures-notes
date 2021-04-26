package com.clansty.dstest;

/**
 * 二叉查找树
 */
public class BinaryTree {
    TreeNode root = null;

    public void printPreorder() {
        printPreorder(root);
    }

    public void printPreorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }

    public void printInorder() {
        printInorder(root);
    }

    public void printInorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printInorder(node.left);
            printInorder(node.right);
        }
    }

    public void printPostorder() {
        printPostorder(root);
    }

    public void printPostorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPostorder(node.left);
            printPostorder(node.right);
        }
    }

}
