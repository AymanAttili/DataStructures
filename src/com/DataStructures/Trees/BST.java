package com.DataStructures.Trees;

import java.util.*;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }


    ////Basic methods://///////////////////////////////////////////////

    public TreeNode add(Integer value) {//Add by recursion.
        root = add(root, value);
        return root;
    }
    private TreeNode add(TreeNode root, Integer value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value > root.val)
            root.right = add(root.right, value);

        else if (value < root.val)
            root.left = add(root.left, value);

        return root;
    }


    public boolean remove(int x){//Remove by recursion.
        return (remove(root,x)!=null);
    }
    private TreeNode remove(TreeNode root, int x) {
        if(root==null)
            return null;
        if(x>root.val)
            root.right = remove(root.right,x);
        else if(x<root.val)
            root.left = remove(root.left,x);
        else{
            if(root.right==null)
                return root.left;
            else if(root.left==null)
                return root.right;
            else{
                root.val =maxValue(root.left);
                root.left=remove(root.left,root.val);
            }
        }
        return root;
    }
    private Integer maxValue(TreeNode root) {//To find the maximum value of a given subtree (helper method).
        while (true) {
            if (root.right == null)
                break;
            root = root.right;
        }
        return root.val;
    }


    public void preOrder() {
        preOrder(root);
    }//prints the tree pre-order traversal.
    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return;
    }


    public void inOrder() {
        inOrder(root);
    }//prints the tree in-order traversal.
    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
        return;
    }


    public void postOrder() {
        postOrder(root);
    }//prints the tree post-order traversal.
    public void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
        return;
    }


    public void BFS() {
        BFS(root);
    }//prints the tree leve-order traversal.
    public void BFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode f = q.poll();
            System.out.print(f.val + " ");
            if (f.left != null)
                q.add(f.left);
            if (f.right != null)
                q.add(f.right);
        }
        System.out.println();
    }


    public boolean contains(int value) {
        return contains(this.root, value);
    }
    private boolean contains(TreeNode root, int value) {
        if (root == null)
            return false;
        if (root.val == value)
            return true;
        else if (value > root.val)
            return contains(root.right, value);
        else
            return contains(root.left, value);
    }


    public boolean isEmpty() {
        return (root == null);
    }


    public void clear() {
        root = null;
    }


    ////Extra Methods://////////////////////////////////////////////////////////

    public void add2(Integer value) {
        add2(root, value);
    }//Add by while loop.
    private void add2(TreeNode root, Integer value) {
        if (root == null) {
            this.root = new TreeNode(value);
            return;
        }
        TreeNode curr = root;
        while (true) {
            if (value > curr.val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(value);
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new TreeNode(value);
                    break;
                }
                curr = curr.left;
            }
        }
    }


    public boolean remove2(int x) {//////Remove using while loop.
        if (!contains(x))
            return false;
        boolean left = true;
        TreeNode pre = root;
        TreeNode curr = root;
        while (true) {
            if (curr.val.equals(x))
                break;
            if (curr.val > x) {
                pre = curr;
                curr = curr.left;
                left = true;
            }
            if (curr.val < x) {
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
                int temp = maxLeft(curr.right).val;
                remove2(temp);
                curr.val = temp;
            }
        } else {
            if (curr.left == curr.right && curr.left == null)
                root = null;
            else if (curr.left != null) {
                int temp = maxRight(curr.left).val;
                remove2(temp);
                curr.val = temp;
            } else if (curr.right != null) {
                int temp = maxLeft(curr.right).val;
                remove2(temp);
                curr.val = temp;
            }
        }
        return true;
    }
    private TreeNode maxRight(TreeNode root) {//to find the last right of the given node (helper method).
        while (true) {
            if (root.right == null)
                break;
            root = root.right;
        }
        return root;
    }
    private TreeNode maxLeft(TreeNode root) {//to find the last left of the given node (helper method).
        while (true) {
            if (root.left == null)
                break;
            root = root.left;
        }
        return root;
    }


    public int numNRec() {//To count the number of nodes in tree (using recursion).
        return numNRec(root);
    }
    private int numNRec(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + numNRec(root.left) + numNRec(root.right);
    }

}



