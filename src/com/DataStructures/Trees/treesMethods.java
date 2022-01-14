package com.DataStructures.Trees;


import java.util.*;
public class treesMethods {


    ////https://leetcode.com/problems/increasing-order-search-tree/

    public static TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return null;
        root.right = increasingBST(root.right);
        if(root.left!=null) {
            TreeNode temp;
            temp = increasingBST(root.left);
            temp.right = increasingBST(temp.right);
            topRight(temp,root);
            root.left=null;
            root=temp;
        }
        return root;
    }
    private static void topRight(TreeNode temp, TreeNode right) {
        while(temp.right!=null)
            temp = temp.right;
        temp.right=right;
    }

    ////Another solution for the question above.
    static ArrayList<TreeNode> arr = new ArrayList<>();
    public static TreeNode increasingBST2(TreeNode root) {
        arr.clear();
        inOrder(root);
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1)
                arr.get(i).right = null;
            else
                arr.get(i).right = arr.get(i + 1);

            arr.get(i).left = null;
        }
        return arr.get(0);
    }
    private static void inOrder(TreeNode root) {//To add the elements of tree ascending.
        if(root==null)
            return ;
        inOrder(root.left);
        arr.add(root);
        inOrder(root.right);
    }


    ////https://leetcode.com/problems/binary-tree-pruning/

    public static TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;

        root.left=pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.data==0 && root.left==root.right && root.left==null)
            return null;

        return root;
    }


    ////https://leetcode.com/problems/balanced-binary-tree/

    public static boolean isBalanced(TreeNode root){
        if(root==null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (Math.abs(maxDepth(temp.left) - maxDepth(temp.right)) > 1)
                return false;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        return true;
    }


    ////To find the maximum depth for a specific node.

    private static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    ////https://practice.geeksforgeeks.org/problems/odd-even-level-difference/1/#

    public static int getLevelDiff(TreeNode root){
        return getLevelDiff(root,0);
    }
    private static int getLevelDiff(TreeNode root, int i) {
        if(root==null)
            return 0;
        if(i%2==1)
            return -1*root.data + getLevelDiff(root.left,i+1) + getLevelDiff(root.right,i+1);
        return root.data + getLevelDiff(root.left,i+1) + getLevelDiff(root.right,i+1);
    }


    ////https://leetcode.com/problems/sum-of-left-leaves/

    public static int sumOfLeftLeaves(TreeNode root){
        return sumOfLeftLeaves(root,false);
    }
    private static int sumOfLeftLeaves(TreeNode root, boolean left) {
        if(root==null)
            return 0;
        if(root.left==root.right && root.right==null && left){
            return root.data;
        }
        return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
    }


    ////https://leetcode.com/problems/path-sum/

    public static boolean hasPathSum(TreeNode root , int targetSum){
        if(root==null)
            return false;
        return hasPathSum(root,0,targetSum);
    }
    private static boolean hasPathSum(TreeNode root, int sum, int targetSum) {
        if(root==null)
            return false;
        if(root.left==root.right && root.left==null){
            sum+=root.data;
            return (sum==targetSum);
        }
        else{
            sum+= root.data;
            return hasPathSum(root.left,sum,targetSum) || hasPathSum(root.right,sum,targetSum);
        }
    }


    ////A method that returns the path of a specific element in tree from root to it.

    public static String path(TreeNode root, Integer value) {
        if (!contains(root,value))
            return "Not found";
        if (root.data.equals(value))
            return "" + value;
        if (value > root.data)
            return root.data + "->" + path(root.right, value);
        else
            return root.data + "->" + path(root.left, value);
    }
    private static  boolean contains(TreeNode root, int value) {
        if (root == null)
            return false;
        if (root.data == value)
            return true;
        else if (value > root.data)
            return contains(root.right, value);
        else
            return contains(root.left, value);
    }


    ////A method that counts the number of leaves in the BST.

    public int numOfLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return numOfLeaves(root.right) + numOfLeaves(root.left);
    }


    ////https://leetcode.com/problems/check-completeness-of-a-binary-tree/

    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean hasNull = false;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null){
                if(hasNull)
                    return false;
                q.add(temp.left);
            }
            else
                hasNull=true;
            if(temp.right!=null){
                if(hasNull)
                    return false;
                q.add(temp.right);
            }
            else
                hasNull=true;
        }
        return true;
    }


    ////https://leetcode.com/problems/subtree-of-another-tree/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.data==subRoot.data)
                if(equals(temp,subRoot))
                    return true;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        return false;
    }
    public boolean equals(TreeNode root,TreeNode subRoot){
        if(root==subRoot && root==null)
            return true;
        if(root!=null && subRoot!=null &&root.data==subRoot.data)
            return equals(root.left,subRoot.left)&&equals(root.right,subRoot.right);
        return false;
    }


    ////A method that finds the maximum sum from the root to leaves;

    public int maxSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.data + Math.max(maxSum(root.right), maxSum(root.left));
    }


}



