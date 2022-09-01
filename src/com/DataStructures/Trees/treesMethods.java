package com.DataStructures.Trees;


import java.util.*;
public class treesMethods {

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
            return -1*root.val + getLevelDiff(root.left,i+1) + getLevelDiff(root.right,i+1);
        return root.val + getLevelDiff(root.left,i+1) + getLevelDiff(root.right,i+1);
    }


    //// to find the k-th largest element in BST.

    int ind=0,x;
    public boolean kthElement(TreeNode root,int k){
        if(root == null)
            return false;

        if(root.right == null)
        {
            ind++;
            if(ind==k)
            {
                x=root.val;
                return false;
            }
            return kthElement(root.left,k);
        }
        if(kthElement(root.right,k)==false) {
            ind++;
            if (ind == k) {
                x = root.val;
                return false;
            }
            return kthElement(root.left, k);
        }
        return true;
    }


    ///OR:
    int y;
    public int kth(TreeNode root,int k){
        if(root==null)
            return Integer.MIN_VALUE;

        int r = kth(root.right,k);
        if(r==Integer.MIN_VALUE) {
            y++;
            if (y == k)
                return root.val;
            return kth(root.left,k);
        }

        return r;
    }

    ////A method that returns the path of a specific element in tree from root to it.

    public static String path(TreeNode root, Integer value) {
        if (!contains(root,value))
            return "Not found";
        if (root.val.equals(value))
            return "" + value;
        if (value > root.val)
            return root.val + "->" + path(root.right, value);
        else
            return root.val + "->" + path(root.left, value);
    }
    private static  boolean contains(TreeNode root, int value) {
        if (root == null)
            return false;
        if (root.val == value)
            return true;
        else if (value > root.val)
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


    ////A method that finds the maximum sum from the root to leaves;

    public int maxSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + Math.max(maxSum(root.right), maxSum(root.left));
    }



    ////LEETCODE PROBLEMS:////////////////////////////////////////////////////////////////

    ////https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);

        else if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left, p, q);

        else
            return root;
    }


    ////https://leetcode.com/problems/subtree-of-another-tree/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        if (isSame(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        if (root.val != subRoot.val)
            return false;

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
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
            sum+=root.val;
            return (sum==targetSum);
        }
        else{
            sum+= root.val;
            return hasPathSum(root.left,sum,targetSum) || hasPathSum(root.right,sum,targetSum);
        }
    }


    ////https://leetcode.com/problems/sum-of-left-leaves/

    public static int sumOfLeftLeaves(TreeNode root){
        return sumOfLeftLeaves(root,false);
    }
    private static int sumOfLeftLeaves(TreeNode root, boolean left) {
        if(root==null)
            return 0;
        if(root.left==root.right && root.right==null && left){
            return root.val;
        }
        return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
    }


    ////https://leetcode.com/problems/binary-tree-pruning/

    public static TreeNode pruneTree(TreeNode root) {
        if(root==null)
            return null;

        root.left=pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val ==0 && root.left==root.right && root.left==null)
            return null;

        return root;
    }


    ////https://leetcode.com/problems/balanced-binary-tree/

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        int L=maxDepth(root.left);
        int R=maxDepth(root.right);

        if(Math.abs(L-R)>1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    /*private static int maxDepth(TreeNode root) {
            if(root==null)
                return 0;
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
      }*/

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


    ////https://leetcode.com/problems/sum-root-to-leaf-numbers/

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return sumNumbers(root,0);

    }
    private int sumNumbers(TreeNode root , int sum) {
        if(root==null)
            return 0;
        if(root.left == root.right && root.left==null){
            sum*=10;
            sum+=root.val;
            return sum;
        }
        sum*=10;
        sum+=root.val;
        return sumNumbers(root.left,sum)+sumNumbers(root.right,sum);
    }


    ////https://leetcode.com/problems/validate-binary-search-tree/

    public boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return isValid(root, min, max);
    }

    public static boolean isValid(TreeNode root, int min, int max) {
        if(root == null)
            return true;

        if(root.val <= min || root.val >= max)
            return false;

        return isValid(root.left,  min, root.val) && isValid(root.right, root.val, max);
    }


}



