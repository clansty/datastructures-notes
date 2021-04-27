package com.clansty.dstest;

/**
 * 二叉查找树
 */
public class BinaryTree {
    TreeNode root = null;

    public void printPreorder() {
        printPreorder(root);
        System.out.println();
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
        System.out.println();
    }

    private void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.value + " ");
            printInorder(node.right);
        }
    }

    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(TreeNode node) {
        if (node != null) {
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print(node.value + " ");
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

    public void insert(int value) {
        if (root == null)
            root = new TreeNode(value);
        insert(value, root);
    }

    private void insert(int value, TreeNode node) {
        if (value < node.value) {
            if (node.left != null)
                insert(value, node.left);
            else
                node.left = new TreeNode(value);
        } else if (value > node.value) {
            if (node.right != null)
                insert(value, node.right);
            else
                node.right = new TreeNode(value);
        }
        //永远是插入到最底下，重复就不插入了
    }

    public void delete(int value) {
        //find the node
        var nodeParent = root;
        TreeNode node = null;
        while (true) {
            if (nodeParent == null)
                return;
            if (nodeParent.left!=null&&nodeParent.left.value == value) {
                node = nodeParent.left;
                break;
            }
            if (nodeParent.right!=null&&nodeParent.right.value == value) {
                node = nodeParent.right;
                break;
            }
            if (value < nodeParent.value)
                nodeParent = nodeParent.left;
            else //if (value > nodeParent.value)
                nodeParent = nodeParent.right;
        }
        if (node.left == null && node.right == null) {
            if (nodeParent.left == node) {
                nodeParent.left = null;
            } else if (nodeParent.right == node) {
                nodeParent.right = null;
            }
        } else if (node.left != null && node.right != null) {
            var nodeMin = node.right;
            var nodeMinParent = node;
            while (nodeMin.left != null) {
                nodeMinParent = nodeMin;
                nodeMin = nodeMin.left;
            }
            if (nodeMinParent.left == nodeMin)
                nodeMinParent.left = null;
            else if (nodeMinParent.right == nodeMin)
                nodeMinParent.right = null;
            node.value = nodeMin.value;
        } else {
            if (node.left != null) {
                if (nodeParent.left == node) {
                    nodeParent.left = node.left;
                } else if (nodeParent.right == node) {
                    nodeParent.right = node.left;
                }
            } else if (node.right != null) {
                if (nodeParent.left == node) {
                    nodeParent.left = node.right;
                } else if (nodeParent.right == node) {
                    nodeParent.right = node.right;
                }
            }
        }
    }
}
