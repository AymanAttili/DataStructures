package com.DataStructures.Trees.AVL;

import java.util.LinkedList;
import java.util.Queue;

class AVLNode{
    Integer val;
    AVLNode left;
    AVLNode right;

    public AVLNode(Integer val) {
        this.val = val;
    }
}

public class AVLTree {
    AVLNode root = null;

    public AVLTree() {
    }

    public AVLNode add(Integer value) {
        this.root = this.add(this.root, value);
        return this.root;
    }
    private AVLNode add(AVLNode root, Integer value) {
        if (root == null)
            root = new AVLNode(value);
        else {
            if (value > root.val) {
                root.right = add(root.right, value);
            } else if (value < root.val) {
                root.left = add(root.left, value);
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
    private AVLNode remove(AVLNode root, int x) {
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
        root = makeBalance(root);
        return root;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    ////Helper Methods:////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    private AVLNode lRotation(AVLNode root) {//Left rotation method (helper method).
        AVLNode temp = root.right;
        root.right=temp.left;
        temp.left =root;
        return temp;
    }


    private AVLNode rRotation(AVLNode root) {//Right rotation method (helper method).
        AVLNode temp = root.left;
        root.left=temp.right;
        temp.right =root;
        return temp;
    }


    private int balanceFactor(AVLNode root){//Calculates the balance factor for the given node.
        return maxDepth(root.left)-maxDepth(root.right);
    }


    private AVLNode makeBalance(AVLNode root){//A method to make sure that the tree is balanced.

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


    private AVLNode maxRight(AVLNode root) {//To find the maximum right node in the given subtree.
        while(root.right != null) {
            root = root.right;
        }
        return root;
    }


    private AVLNode maxLeft(AVLNode root) {//To find the maximum left node in the given subtree.
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }


    public int maxDepth() {
        return this.maxDepth(this.root);
    }
    private int maxDepth(AVLNode root) {
        if(root==null)
            return 0;
        return 1+ Math.max(maxDepth(root.right),maxDepth(root.left));
    }


    private Integer maxValue(AVLNode root) {//To find the maximum value of a given subtree.
        while (true) {
            if (root.right == null)
                break;
            root = root.right;
        }
        return root.val;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    public boolean contains(int value) {
        return this.contains(this.root, value);
    }
    private boolean contains(AVLNode root, int value) {
        if (root == null) {
            return false;
        } else if (root.val == value) {
            return true;
        } else {
            return value > root.val ? this.contains(root.right, value) : this.contains(root.left, value);
        }
    }


    public boolean isEmpty() {
        return this.root == null;
    }


    public void preOrder() {//prints the tree pre-order traversal.
        this.preOrder(this.root);
    }
    public void preOrder(AVLNode root) {
        if (root != null) {
            System.out.println(root.val);
            this.preOrder(root.left);
            this.preOrder(root.right);
        }
    }


    public void inOrder() {//prints the tree in-order traversal.
        this.inOrder(this.root);
    }
    public void inOrder(AVLNode root) {
        if (root != null) {
            this.inOrder(root.left);
            System.out.println(root.val);
            this.inOrder(root.right);
        }
    }


    public void postOrder() {//prints the tree post-order traversal.
        this.postOrder(this.root);
    }
    public void postOrder(AVLNode root) {
        if (root != null) {
            this.postOrder(root.left);
            this.postOrder(root.right);
            System.out.println(root.val);
        }
    }

    public void BFS() {
        this.BFS(this.root);
    }
    public void BFS(AVLNode root) {
        Queue<AVLNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()) {
            AVLNode f = (AVLNode)q.poll();
            System.out.print(f.val + " ");
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

