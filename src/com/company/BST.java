package com.company;

import java.util.ArrayList;

public class BST {
    TNode root;

    public BST() {
        root = null;
    }

    public TNode add(Integer value) {
        root=add(root, value);
        return root;
    }

    private TNode add(TNode root, Integer value) {
        if (root == null) {
            root = new TNode(value);
            return root;
        }
        if (value > root.data)
            root.right = add(root.right, value);

        else if (value < root.data)
            root.left = add(root.left, value);

        return root;
    }


    public void add2(Integer value) {
        add2(root, value);
    }

    private void add2(TNode root, Integer value) {
        if (root == null) {
            this.root = new TNode(value);
            return;
        }

        TNode curr = root;
        while (true) {
            if (value > curr.data) {
                if (curr.right == null) {
                    curr.right = new TNode(value);
                    break;
                }
                curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new TNode(value);
                    break;
                }
                curr = curr.left;
            }

        }
    }

    public void preTraversal(){
        preTraversal(root);
    }
    public void preTraversal(TNode root){
        if(root==null)
            return;
        System.out.println(root.data);
        preTraversal(root.left);
        preTraversal(root.right);
        return;
    }

    public void inTraversal(){
        inTraversal(root);
    }
    public void inTraversal(TNode root){
        if(root==null)
            return;

        inTraversal(root.left);
        System.out.println(root.data);
        inTraversal(root.right);
        return;
    }

    public void postTraversal(){
        postTraversal(root);
    }
    public void postTraversal(TNode root){
        if(root==null)
            return;

        postTraversal(root.left);
        postTraversal(root.right);
        System.out.println(root.data);
        return;
    }

    public void clear() {
        root=null;
    }


    public boolean contains(int value) {
        return contains(this.root,value);
    }

    private boolean contains(TNode root, int value) {
        if(root==null)
            return false;
        if(root.data==value)
            return true;
        else if(value>root.data)
            return contains(root.right,value);
        else
            return contains(root.left,value);
    }

    public boolean isEmpty(){
        return (root==null);
    }
    public void remove(int x) {
    }
}



