package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    TreeNode root;

    public AVLTree() {
        root=null;
    }

    public TreeNode add(Integer value) {
        root = add(root, value);
        //BalanceTree(root);
        return root;
    }

    private TreeNode add(TreeNode root, Integer value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value > root.data)
            root.right = add(root.right, value);

        else if (value < root.data)
            root.left = add(root.left, value);

        return root;
    }

//    private void BalanceTree(TreeNode root) {
//        if (root == null)
//            return;
//        BalanceTree(root.left);
//        BalanceTree(root.right);
//        مش عارف أكمله:)/////////////////////////////////////////////////////////////////////////
//    }



    private void lRotation(TreeNode curr){

    }
    private void rRotation(TreeNode curr){

    }
    private void lrRotation(TreeNode curr){

    }
    private void rlRotation(TreeNode curr){

    }


    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public boolean remove(int x) {
        if (!contains(x))
            return false;
        boolean left = true;
        TreeNode pre = root;
        TreeNode curr = root;
        while (true) {
            if (curr.data.equals(x))
                break;
            if (curr.data > x) {
                pre = curr;
                curr = curr.left;
                left = true;
            }
            if (curr.data < x) {
                pre = curr;
                curr = curr.right;
                left = false;
            }
        }
        if (curr != pre) {
            if (curr.right == null && left)
                pre.left = curr.left;
            else if (curr.left == null && left)
                pre.left = curr.right;
            else if (curr.right == null)
                pre.right = curr.left;
            else if (curr.left == null)
                pre.right = curr.right;

            else {
                int temp = maxLeft(curr.right);
                remove(temp);
                curr.data = temp;
            }
        } else {
            if (curr.left == curr.right && curr.left == null)
                root = null;
            else if (curr.left != null) {
                int temp = maxRight(curr.left);
                remove(temp);
                curr.data = temp;
            } else if (curr.right != null) {
                int temp = maxLeft(curr.right);
                remove(temp);
                curr.data = temp;
            }
        }
        return true;
    }

    private int maxRight(TreeNode root) {
        while (true) {
            if (root.right == null)
                break;
            root = root.right;
        }
        return root.data;
    }

    private int maxLeft(TreeNode root) {
        while (true) {
            if (root.left == null)
                break;
            root = root.left;
        }
        return root.data;
    }

    public boolean contains(int value) {
        return contains(this.root, value);
    }

    private boolean contains(TreeNode root, int value) {
        if (root == null)
            return false;
        if (root.data == value)
            return true;
        else if (value > root.data)
            return contains(root.right, value);
        else
            return contains(root.left, value);
    }

    public boolean isEmpty() {
        return (root == null);
    }


    public void preOrder() {
        preOrder(root);
    }
    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
        return;
    }


    public void inOrder() {
        inOrder(root);
    }
    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
        return;
    }



    public void postOrder() {
        postOrder(root);
    }
    public void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
        return;
    }



    public void BFS() {
        BFS(root);
    }
    public void BFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode f = q.poll();
            System.out.print(f.data + " ");
            if (f.left != null)
                q.add(f.left);
            if (f.right != null)
                q.add(f.right);
        }
        System.out.println();
    }
}
