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
    private static void inOrder(TreeNode root) {//To add the elements of tree ascending
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

        if(root.data==0 && root.left==root.right && root.left==null) {

            return null;
        }
        return root;

    }

    ////////////
    public static boolean isBalanced(TreeNode root){
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

    ////////////
    public static int getLevelDiff(TreeNode root){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int z= maxDepth(root);
        for(int i=0 ; i<z ; i++)
            arr.add(new ArrayList<>());
        int c=0;
        for (int i = 0; i < z; i++) {
            if(i%2==0)
                for(int j=0 ; j<arr.get(i).size() ; j++)
                    c+=arr.get(i).get(j);
            else
                for(int j=0 ; j<arr.get(i).size() ; j++)
                    c-=arr.get(i).get(j);

        }
        return c;
    }

    ////////////
    private static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    ////////////
    private static void getLevelDiff(TreeNode root, int i, ArrayList<ArrayList<Integer>> arr) {
        if(root==null)
            return;
        arr.get(i).add(root.data);
        getLevelDiff(root.right,i+1,arr);
        getLevelDiff(root.left,i+1,arr);

    }

    ////////////
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

    ////////////
    public static boolean hasPathSum(TreeNode root , int target){
        return hasPathSum(root,0,target);
    }
    private static boolean hasPathSum(TreeNode root, int sum, int target) {
        if(root==null)
            return (sum==target);
        if(root.left==root.right && root.left==null){
            sum+=root.data;
            return (sum==target);
        }

        else{
            if(sum>target)
                return false;
            sum+= root.data;
            return hasPathSum(root.left,sum,target) || hasPathSum(root.right,sum,target);
        }
    }

    ////////////
    public String path(TreeNode root, Integer value) {
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

    ////////////
    public int numOfLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return numOfLeaves(root.right) + numOfLeaves(root.left);
    }
}



