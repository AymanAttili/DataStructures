package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree_NotFinishedYet {
    TreeNode root = null;

    public AVLTree_NotFinishedYet() {
    }

    public TreeNode add(Integer value) {
        this.root = this.add(this.root, value);
        return this.root;
    }

    private TreeNode add(TreeNode root, Integer value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        } else {
            if (value > root.data) {
                root.right = this.add(root.right, value);
            } else if (value < root.data) {
                root.left = this.add(root.left, value);
            }

            return root;
        }
    }

    private void lRotation(TreeNode curr) {
    }

    private void rRotation(TreeNode curr) {
    }

    private void lrRotation(TreeNode curr) {
    }

    private void rlRotation(TreeNode curr) {
    }

    public int maxDepth() {
        return this.maxDepth(this.root);
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }

    public boolean remove(int x) {
        if (!this.contains(x)) {
            return false;
        } else {
            boolean left = true;
            TreeNode pre = this.root;
            TreeNode curr = this.root;

            while(!curr.data.equals(x)) {
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

            int temp;
            if (curr != pre) {
                if (curr.right == null && left) {
                    pre.left = curr.left;
                } else if (curr.left == null && left) {
                    pre.left = curr.right;
                } else if (curr.right == null) {
                    pre.right = curr.left;
                } else if (curr.left == null) {
                    pre.right = curr.right;
                } else {
                    temp = this.maxLeft(curr.right);
                    this.remove(temp);
                    curr.data = temp;
                }
            } else if (curr.left == curr.right && curr.left == null) {
                this.root = null;
            } else if (curr.left != null) {
                temp = this.maxRight(curr.left);
                this.remove(temp);
                curr.data = temp;
            } else if (curr.right != null) {
                temp = this.maxLeft(curr.right);
                this.remove(temp);
                curr.data = temp;
            }

            return true;
        }
    }

    private int maxRight(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    private int maxLeft(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }

        return root.data;
    }

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

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            this.preOrder(root.left);
            this.preOrder(root.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            this.inOrder(root.left);
            System.out.println(root.data);
            this.inOrder(root.right);
        }
    }

    public void postOrder() {
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

