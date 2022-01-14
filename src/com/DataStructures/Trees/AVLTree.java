package com.DataStructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    TreeNode root = null;

    public AVLTree() {
    }

    public TreeNode add(Integer value) {
        this.root = this.add(this.root, value);
        return this.root;
    }
    private TreeNode add(TreeNode root, Integer value) {
        if (root == null)
            root = new TreeNode(value);
        else {
            if (value > root.data) {
                root.right = this.add(root.right, value);
            } else if (value < root.data) {
                root.left = this.add(root.left, value);
            }
            root = makeBalance(root);
        }

        return root;
    }


    public boolean remove(int x){//Remove by recursion.
        if(!contains(x))
            return false;
        root=remove(root,x);
        return true;
    }
    private TreeNode remove(TreeNode root, int x) {
        if(root==null)
            return null;
        if(x>root.data)
            root.right = remove(root.right,x);
        else if(x<root.data)
            root.left = remove(root.left,x);
        else{
            if(root.right==null)
                return root.left;
            else if(root.left==null)
                return root.right;
            else{
                root.data=maxValue(root.left);
                root.left=remove(root.left,root.data);
            }
        }
        root = makeBalance(root);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    ////Helper Methods:////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    private TreeNode lRotation(TreeNode root) {//Left rotation method (helper method).
        TreeNode temp = root.right;
        root.right=temp.left;
        temp.left =root;
        return temp;
    }


    private TreeNode rRotation(TreeNode root) {//Right rotation method (helper method).
        TreeNode temp = root.left;
        root.left=temp.right;
        temp.right =root;
        return temp;
    }


    private int balanceFactor(TreeNode root){//Calculates the balance factor for the given node.
        return maxDepth(root.left)-maxDepth(root.right);
    }


    private TreeNode makeBalance(TreeNode root){//A method to make sure that the tree is balanced.

        // Finding the balance factor for the root.
        int BF = balanceFactor(root);

        if (BF > 1) {//if left is longer than right.

            // Finding the balance factor for the left node.
            int BFL = balanceFactor(root.left);

            if (BFL < 0)//Left-Right rotation.
                root.left = lRotation(root.left);//Left rotation.

            root = rRotation(root);//Right rotation.
        }


        if (BF < -1) {//if right is longer than left.

            // Finding the balance factor for the right node.
            int BFR = balanceFactor(root.right);

            if (BFR > 0)//Right-Left rotation.
                root.right = rRotation(root.right);//Right rotation.

            root = lRotation(root);//Left rotation.
        }
        return root;
    }


    private TreeNode maxRight(TreeNode root) {//To find the maximum right node in the given subtree.
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }


    private TreeNode maxLeft(TreeNode root) {//To find the maximum left node in the given subtree.
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }


    public int maxDepth() {
        return this.maxDepth(this.root);
    }
    private int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+ Math.max(maxDepth(root.right),maxDepth(root.left));
    }


    private Integer maxValue(TreeNode root) {//To find the maximum value of a given subtree.
        while (true) {
            if (root.right == null)
                break;
            root = root.right;
        }
        return root.data;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean contains(int value) {
        return this.contains(this.root, value);
    }
    private boolean contains(TreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        } else {
            return value > root.data ? this.contains(root.right, value) : this.contains(root.left, value);
        }
    }


    public boolean isEmpty() {
        return this.root == null;
    }


    public void preOrder() {//prints the tree pre-order traversal.
        this.preOrder(this.root);
    }
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            this.preOrder(root.left);
            this.preOrder(root.right);
        }
    }


    public void inOrder() {//prints the tree in-order traversal.
        this.inOrder(this.root);
    }
    public void inOrder(TreeNode root) {
        if (root != null) {
            this.inOrder(root.left);
            System.out.println(root.data);
            this.inOrder(root.right);
        }
    }


    public void postOrder() {//prints the tree post-order traversal.
        this.postOrder(this.root);
    }
    public void postOrder(TreeNode root) {
        if (root != null) {
            this.postOrder(root.left);
            this.postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public void BFS() {
        this.BFS(this.root);
    }
    public void BFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode f = (TreeNode)q.poll();
            System.out.print(f.data + " ");
            if (f.left != null) {
                q.add(f.left);
            }

            if (f.right != null) {
                q.add(f.right);
            }
        }
        System.out.println();
    }
}

