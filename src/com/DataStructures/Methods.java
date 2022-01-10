package com.DataStructures;
import com.DataStructures.Stacks.MyArrayListStack;
import com.DataStructures.Stacks.MyStack;


import java.util.*;
import java.lang.*;

public class Methods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

//    public static TNode increasingBST(TNode root) {
//        if(root==null)
//            return null;
//        TNode temp;
//        if(root.left!=null) {
//            temp = increasingBST(root.left);
//            temp.right = increasingBST(temp.right);
//            topRight(temp,root);
//            root=temp;
//        }
//        root.right = increasingBST(root.right);
//        return root;
//    }
//
//    private static void topRight(TNode temp, TNode right) {
//        while(temp.right!=null)
//            temp = temp.right;
//        temp.right=right;
//    }


    ////https://leetcode.com/problems/increasing-order-search-tree/
    static ArrayList<TNode> arr = new ArrayList<>();
    public static TNode increasingBST(TNode root) {
        arr.clear();
        inOrder(root);
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                arr.get(i).right = null;
                arr.get(i).left = null;
            } else {
                arr.get(i).right = arr.get(i + 1);
                arr.get(i).left = null;
            }
        }
        return arr.get(0);
    }
    private static void inOrder(TNode root) {
        if(root==null)
            return ;
        inOrder(root.left);
        arr.add(root);
        inOrder(root.right);
    }


    ////https://leetcode.com/problems/binary-tree-pruning/
    public static TNode pruneTree(TNode root) {
        if(root==null)
            return null;

        root.left=pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.data==0 && root.left==root.right && root.left==null) {

            return null;
        }
        return root;

    }

    public static boolean isBalanced(TNode root){
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TNode temp = q.poll();
            if (Math.abs(maxD(temp.left) - maxD(temp.right)) > 1)
                return false;
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        return true;
    }


    public static void removeMidOfStack(Stack<Integer> s){
        removeMidOfStack(s,s.size());
    }

    private static void removeMidOfStack(Stack<Integer> s, int size) {
        if(size%2!=0)
            size++;
        if(s.size()==size/2) {
            s.pop();
            return;
        }
        int temp = s.pop();
        removeMidOfStack(s,size);
        s.push(temp);
    }


    public static void revLL(LinkedList<Integer> l){
        if(l.isEmpty())
            return ;
        int temp = l.remove(0);
        revLL(l);
        l.add(temp);
    }

    public static void targetIndices(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++)
            map.put(nums[i],i);
        for(Integer key: map.keySet()){
            if(map.containsKey(target-key)){
                System.out.println(map.get(key)+","+map.get(target-key));
                break;
            }
        }
    }

    public static int getLevelDiff(TNode root){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int z= maxD(root);
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

    private static int maxD(TNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(maxD(root.left),maxD(root.right));
    }

    private static void getLevelDiff(TNode root, int i, ArrayList<ArrayList<Integer>> arr) {
        if(root==null)
            return;
        arr.get(i).add(root.data);
        getLevelDiff(root.right,i+1,arr);
        getLevelDiff(root.left,i+1,arr);

    }

    public static int sumOfLeftLeaves(TNode root){
        return sumOfLeftLeaves(root,false);
    }

    private static int sumOfLeftLeaves(TNode root, boolean left) {
        if(root==null)
            return 0;
        if(root.left==root.right && root.right==null && left){
            return root.data;
        }
        return sumOfLeftLeaves(root.left,true)+sumOfLeftLeaves(root.right,false);
    }


    public static boolean hasPathSum(TNode root , int target){
        return hasPathSum(root,0,target);
    }

    private static boolean hasPathSum(TNode root, int sum, int target) {
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


    /////A method to find the occurrence of a specific character in a string
    public static int occ(String str , char c){
        if(str.length()==0)
            return 0;
        if(str.charAt(0)==c)
            return 1 + occ(str.substring(1),c);
        return occ(str.substring(1),c);
    }


/////
    public static void revArray(int[] arr){
        revArray(arr,0);
    }
    public static void revArray(int[] arr,int i){
        if(i>=arr.length-1-i)
            return;
        int temp = arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;
        revArray(arr,i+1);
    }


    ///////A recursive binary search method.
    public static boolean binarySearch(int[] arr,int target){
        return binarySearch(arr,target,0,arr[arr.length-1]);
    }

    private static boolean binarySearch(int[] arr,int target , int l, int r) {
        if(l>r)
            return false;
        int mid = (r-l)/2;
        if(arr[mid]>target)
            return binarySearch(arr,target,l,mid-1);
        if(arr[mid]<target)
            return binarySearch(arr,target,mid+1,r);
        return true;
    }

    ////A method to compute xn for a positive integer n.
    public static int power(int x , int n){
        if(n==0)
            return 1;
        return x*power(x,n-1);
    }

    ////A method to reverse a string.
    public static String revString(String str){
        if(str.length()<=1)
            return str;
        return revString(str.substring(1))+str.charAt(0);
    }

    ////A method to compute the GCD (greatest common divisor).
    public static int GCD(int x , int y){
        if(y==0)
            return x;
        return GCD(y,x%y);
    }

    ////A method checks if a string is palindrome.
    public static boolean isPalindrome(String str){
        if(str.length()<=1){
            return true;
        }
        if(str.charAt(0)==str.charAt(str.length()-1))
            return isPalindrome(str.substring(1,str.length()-1));
        return false;
    }


    ////A method finds if the array has duplicates.
    public boolean hasDuplicates(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size()!=nums.length)
            return true;
        else
            return false;
    }


    ////A method takes a linked list and finds if it has a cycle.
    public boolean hasCycle(MyLinkedList ll){
        HashSet<Node> set = new HashSet<>();
        Node curr = ll.getHead();
        while(curr!=null){
            if(set.contains(curr))
                return true;
            set.add(curr);
            curr=curr.getNext();
        }
        return false;
    }

    ////A method prints the first unique number(has just one occurrence).
    public void firstUnique(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), 1);
            else
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
        }

        for(Map.Entry i: map.entrySet()){
            if(i.getValue().equals(1)) {
                System.out.println(i.getKey());
                return;
            }
        }
        System.out.println(-1);
    }

    ////given two Array Lists, return an Array List that contains the intersection of the two lists. Note: (the intersection may contain duplicates).
    public static ArrayList<Integer> Dup(ArrayList<Integer> l1,ArrayList<Integer> l2){
        HashMap<Integer,Integer> m1 = new HashMap<>();
        HashMap<Integer,Integer> m2 = new HashMap<>();

        for (int i = 0; i < l1.size(); i++) {
            m1.put(l1.get(i),m1.getOrDefault(l1.get(i),0)+1);
        }
        for (int i = 0; i < l2.size(); i++) {
            m2.put(l2.get(i),m2.getOrDefault(l2.get(i),0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();

        for(Integer key : m1.keySet()){
            if(m2.containsKey(key)){
                for(int i=0 ; i< Math.min(m1.get(key),m2.get(key)) ; i++)
                    list.add(key);
            }
        }
        return list;
    }

    public static boolean twoSum(int[] arr , int target){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for(Integer i : set){
            if(set.contains(target-i) &&  (target-i)!=i)
                return true;
        }

        return false;

    }

    public static boolean uniqueOccurrences(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i],0);
            hm.put(nums[i],hm.get(nums[i])+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer v : hm.values())
            set.add(v);
        return (set.size()==hm.size());
    }

    public static int numOfUnique(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> ent: hm.entrySet()){
            if(ent.getValue()==1)
                count+=ent.getKey();
        }
        return count;
    }

    private static int numOfJewels(String[] stones, String[] jewels) {
        HashSet<String> set = new HashSet<>();
        int count = 0;
        for(int i=0 ; i<jewels.length ; i++){
            set.add(jewels[i]);
        }
        for (int i = 0; i < stones.length; i++) {
            if(set.contains(stones[i]))
                count++;
        }
        return count;
    }

    public static boolean pangram(String str){
        HashSet<Character> set = new HashSet<>();
        for(int i=0 ; i<str.length() ; i++){
            set.add(str.charAt(i));
        }
        return (set.size()==26);
    }

    public static int missingNumber(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            set.add(nums[i]);
        }
        int c=-1;
        for(int i=0 ; i<=nums.length ; i++){
            if(!set.contains(i))
                c=i;
        }
        return c;
    }

    public static boolean isomorphic(String s1 , String s2){
        if(s1.length()!=s2.length())
            return false;
        HashMap<Character,Character> hm1 = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();

        for(int i=0 ; i<s1.length() ; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if((hm1.containsKey(c1) && hm1.get(c1)!=c2)||(hm2.containsKey(c2) && hm2.get(c2)!=c1))
                return false;
            hm1.put(c1,c2);
            hm2.put(c2,c1);
        }
        return true;
    }

    public static boolean containsNearbyDuplicates(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(hm.containsKey(nums[i])){
                int z = hm.get(nums[i]);
                if(i-z<=k)
                    return true;
                else
                    hm.put(nums[i],i);
            }
            else
                hm.put(nums[i],i);
        }
        return false;
    }


    public static int allowed(String allowed, String[] words){
        HashSet<Character> h1 = new HashSet<>();
        int c=0;
        for(int i=0 ; i<allowed.length() ; i++)
            h1.add(allowed.charAt(i));

        for(int i=0 ; i<words.length ; i++) {
            boolean isA = true;
            for (int j = 0; j < words[i].length(); j++)
                if (!h1.contains(words[i].charAt(j))) {
                    isA = false;
                    break;
                }
            if (isA)
                c++;
        }

        return c;
    }
    public static boolean good(String str){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0 ; i<str.length() ; i++)
            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);

        int y = hm.get(str.charAt(0));

        for(Integer x : hm.values())
            if(x!=y)
                return false;
        return true;

    }
    public static String CapSma(String str){
        String str2 = "";
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<str.length() ; i++){
            if(s.isEmpty())
                s.push(str.charAt(i));
            else{
                if(Math.abs(s.peek()-str.charAt(i))==32)
                    s.pop();
                else
                    s.push(str.charAt(i));
            }
        }
        Stack<Character> s3 = new Stack<>();
        while (!s.isEmpty())
            s3.push(s.pop());
        s=s3;
        while(!s.isEmpty())
            str2+=s.pop();
        return str2;
    }

    public static ArrayList<Integer> intersection(ArrayList<Integer> a1 , ArrayList<Integer> a2){
        HashMap<Integer,Integer> m1 = new HashMap<>();
        HashMap<Integer,Integer> m2 = new HashMap<>();
        for(int i=0 ; i<a1.size() ; i++){
            m1.put(a1.get(i),m1.getOrDefault(a1.get(i),0)+1);
        }
        for(int i=0 ; i<a2.size() ; i++){
            m2.put(a2.get(i),m2.getOrDefault(a2.get(i),0)+1);
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(Integer x:m1.keySet()){
            if(m2.containsKey(x)){
                for(int i=0 ; i<Math.min(m1.get(x),m2.get(x)) ; i++)
                    a.add(x);
            }
        }
        return a;

    }
    public static void NGE(int[] arr){
        Stack<Integer> s = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            if(s.isEmpty())
                s.push(arr[i]);
            else{
                if(arr[i]<=s.peek())
                    s.push(arr[i]);
                else{
                    while(!s.isEmpty()&&s.peek()<arr[i]){
                        System.out.println(s.pop()+"---->" + arr[i]);
                    }
                    s.push(arr[i]);
                }
            }
        }
        while(!s.isEmpty())
            System.out.println(s.pop()+"---->" + -1);
    }

    public static Stack<Integer> mergeStacks(Stack<Integer> s1 , Stack<Integer> s2){
        Stack<Integer> s = new Stack<>();
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek()<s2.peek())
                s.push(s1.pop());
            else
                s.push(s2.pop());
        }
        while(!s1.isEmpty())
            s.push(s1.pop());
        while(!s2.isEmpty())
            s.push(s2.pop());
        Stack<Integer> s3 = new Stack<>();
        while (!s.isEmpty())
            s3.push(s.pop());
        s=s3;
        return s;

    }

    public static void revStack(Stack<Integer> s){
        if(!s.isEmpty()) {
            int temp = s.pop();
            revStack(s);
            putBottom(s,temp);
        }
        return;
    }

    private static void putBottom(Stack<Integer> s, int x) {
        if(s.isEmpty())
            s.push(x);
        else{
            int temp = s.pop();
            putBottom(s,x);
            s.push(temp);
        }
    }


    private static int numOfRotations(ArrayList<Integer> a) {
        int max = 0;
        int count = 0, c = 0;

        for (int i = 0; i < a.size(); i++) {
            c=0;
            for (int j = 0; j < a.size(); j++) {
                if (c > max) {
                    max = c;
                    count = i;
                }
                if(a.get(j)%2==0)
                    c=0;
                else
                    c++;
            }
            a.add(0,a.remove(a.size()-1));
        }
        return count;
    }
    private static Stack movePrimes(Stack s){
        Stack<Integer> s2 = new Stack<>();
        while(!s.isEmpty()){
            int x = (int)s.pop();
            if(s2.isEmpty() || !isPrime(x))
                s2.push(x);
            else{
                while(!isPrime(s2.peek()))
                    s.push(s2.pop());
                s2.push(x);
            }
        }
        return s2;
    }

    private static boolean isPrime(int x) {
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=2 ; i<=Math.sqrt(x) ; i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    public static void swapDuplicate(MyLinkedList m2){
        HashMap<Integer,Integer> hm = new HashMap<>();
        Node curr = m2.getHead();
        Integer rep = null ;
        while(curr!=null){
            hm.put((Integer) curr.getData(),hm.getOrDefault(curr.getData(),0)+1);
            if(hm.get(curr.getData())==2)
                rep=(Integer) curr.getData();
            curr=curr.getNext();
        }
        ///////
        Node pre = m2.getHead();
        curr=pre.getNext();
        if(m2.getHead().getData()!=rep){
            while(curr.getData()!=rep) {
                pre = pre.getNext();
                curr = curr.getNext();
            }
            pre.setNext(curr.getNext());
            curr.setNext(m2.getHead());
            m2.setHead(curr);
        }

        //////

        pre=m2.getHead();
        curr=pre.getNext();
        while(curr.getData()!=rep) {
            pre = pre.getNext();
            curr = curr.getNext();
        }
        if(curr!=m2.getTail()){
            pre.setNext(curr.getNext());
            m2.getTail().setNext(curr);
            m2.setTail(curr);
            m2.getTail().setNext(null);
        }

    }

    private static boolean fun(ArrayList<Integer> arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0 ; i<arr.size() ; i++){
            //hm.put(arr.get(i),hm.getOrDefault(arr.get(i),0)+1);
            if(hm.get(arr.get(i))==null)
                hm.put(arr.get(i),0);
            hm.put(arr.get(i),hm.get(arr.get(i))+1);
        }
        for(Integer i : hm.values()){
            if(i%2!=0)
                return false;
        }
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            if(e.getValue()%2!=0)
                return false;
        }

        return true;
    }

    public static String convert(int n,int base){
        MyArrayListStack<Integer> s = new MyArrayListStack<>();
        while(n>0){
            s.push(n%base);
            n/=base;
        }
        String str = "";
        while(!s.isEmpty()){
            str+=s.pop();
        }
        return str;
    }

    public static String rev(String str){
        String str2 = "";
        MyArrayListStack<Character> s = new MyArrayListStack<>();
        for(int i=0 ; i<str.length() ; i++)
            s.push(str.charAt(i));
        for(int i=0 ; i<str.length() ; i++)
            str2+=s.pop();
        return str2;
    }
    public static <E>E removeBottom(Stack<E> st){
         if(st.isEmpty())
             throw new EmptyStackException();
         if(st.size()==1)
             return st.pop();
         E temp = st.pop();
         E removed = removeBottom(st);
         st.push(temp);
         return removed;
     }

     public static MyLinkedList<Integer> mergeSorted(MyLinkedList<Integer> l1 , MyLinkedList<Integer> l2) {
         MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();
         Node curr1 = l1.getHead();
         Node curr2 = l2.getHead();
         while (curr1 != null && curr2 != null) {
             if ((Integer) curr1.getData() < (Integer) curr2.getData()) {
                 l3.addLast((Integer) curr1.getData());
                 curr1 = curr1.getNext();
             } else{
                 l3.addLast((Integer) curr2.getData());
                 curr2 = curr2.getNext();
             }
         }
         while(curr1!=null){
             l3.addLast((Integer) curr1.getData());
             curr1 = curr1.getNext();
         }

         while(curr2!=null){
             l3.addLast((Integer) curr2.getData());
             curr2 = curr2.getNext();
         }

         return l3;
     }



    public static boolean check(String s){
        MyStack<Character> stack = new MyStack<Character>();
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }

            else{
                if (!stack.isEmpty()) {
                    if (c == ')' && stack.peek() != '(')
                        return false;
                    if (c == ']' && stack.peek() != '[')
                        return false;
                    if (c == '}' && stack.peek() != '{')
                        return false;
                    stack.pop();
                }
                else
                    return false;
            }

        }
        return (stack.isEmpty());
    }

    public static int toInt(MyLinkedList<Boolean> x){
        int z=0,y=0,i=0;
        Node curr = x.getHead();
        while(curr!=null){
            z*=10;
            boolean e = (Boolean)curr.getData();
            if(e)
                z+=1;
            curr = curr.getNext();
        }
        while(z>0){
            if(z%10==1)
                y+=Math.pow(2,i);
            z/=10;
            i++;
        }
        return y;
    }
}
class TNode {
    Integer data;
    TNode left;
    TNode right;

    public TNode(Integer data) {
        this.data = data;
    }
}