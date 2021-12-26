package com.company;

import sun.misc.Queue;

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

//    public static boolean isomorphic(String s1 , String s2){
//        if(s1.length()!=s2.length())
//            return false;
//        HashMap<Character,Character> hm1 = new HashMap<>();
//        HashMap<Character,Character> hm2 = new HashMap<>();
//
//        for(int i=0 ; i<s1.length() ; i++){
//            char c1 = s1.charAt(i);
//            char c2 = s2.charAt(i);
//            if((hm1.containsKey(c1) && hm1.get(c1)!=c2)||(hm2.containsKey(c2) && hm2.get(c2)!=c1))
//                return false;
//            hm1.put(c1,c2);
//            hm2.put(c2,c1);
//
//        }
//        return true;
//    }

//    public static boolean containsNearbyDuplicates(int[] nums, int k){
//        HashMap<Integer,Integer> hm = new HashMap<>();
//        for(int i=0 ; i<nums.length ; i++){
//            if(hm.containsKey(nums[i])){
//                int z = hm.get(nums[i]);
//                if(i-z<=k)
//                    return true;
//                else
//                    hm.put(nums[i],i);
//            }
//            else
//                hm.put(nums[i],i);
//        }
//        return false;
//    }


//    public static int allowed(String allowed, String[] words){
//        HashSet<Character> h1 = new HashSet<>();
//        int c=0;
//        for(int i=0 ; i<allowed.length() ; i++)
//            h1.add(allowed.charAt(i));
//
//        for(int i=0 ; i<words.length ; i++) {
//            boolean isA = true;
//            for (int j = 0; j < words[i].length(); j++)
//                if (!h1.contains(words[i].charAt(j))) {
//                    isA = false;
//                    break;
//                }
//            if (isA)
//                c++;
//        }
//
//        return c;
//    }
//    public static boolean good(String str){
//        HashMap<Character,Integer> hm = new HashMap<>();
//        for(int i=0 ; i<str.length() ; i++)
//            hm.put(str.charAt(i),hm.getOrDefault(str.charAt(i),0)+1);
//
//        int y = hm.get(str.charAt(0));
//
//        for(Integer x : hm.values())
//            if(x!=y)
//                return false;
//        return true;
//
//    }
//    public static String CapSma(String str){
//        String str2 = "";
//        Stack<Character> s = new Stack<>();
//        for(int i=0 ; i<str.length() ; i++){
//            if(s.isEmpty())
//                s.push(str.charAt(i));
//            else{
//                if(Math.abs(s.peek()-str.charAt(i))==32)
//                    s.pop();
//                else
//                    s.push(str.charAt(i));
//            }
//        }
//        Stack<Character> s3 = new Stack<>();
//        while (!s.isEmpty())
//            s3.push(s.pop());
//        s=s3;
//        while(!s.isEmpty())
//            str2+=s.pop();
//        return str2;
//    }
//
//    public static ArrayList<Integer> intersection(ArrayList<Integer> a1 , ArrayList<Integer> a2){
//        HashMap<Integer,Integer> m1 = new HashMap<>();
//        HashMap<Integer,Integer> m2 = new HashMap<>();
//        for(int i=0 ; i<a1.size() ; i++){
//            m1.put(a1.get(i),m1.getOrDefault(a1.get(i),0)+1);
//        }
//        for(int i=0 ; i<a2.size() ; i++){
//            m2.put(a2.get(i),m2.getOrDefault(a2.get(i),0)+1);
//        }
//        ArrayList<Integer> a = new ArrayList<>();
//        for(Integer x:m1.keySet()){
//            if(m2.containsKey(x)){
//                for(int i=0 ; i<Math.min(m1.get(x),m2.get(x)) ; i++)
//                    a.add(x);
//            }
//        }
//        return a;
//
//    }
//    public static void NGE(int[] arr){
//        Stack<Integer> s = new Stack<>();
//        for(int i=0 ; i<arr.length ; i++){
//            if(s.isEmpty())
//                s.push(arr[i]);
//            else{
//                if(arr[i]<=s.peek())
//                    s.push(arr[i]);
//                else{
//                    while(!s.isEmpty()&&s.peek()<arr[i]){
//                        System.out.println(s.pop()+"---->" + arr[i]);
//                    }
//                    s.push(arr[i]);
//                }
//            }
//        }
//        while(!s.isEmpty())
//            System.out.println(s.pop()+"---->" + -1);
//    }
//
//    public static Stack<Integer> mergeStacks(Stack<Integer> s1 , Stack<Integer> s2){
//        Stack<Integer> s = new Stack<>();
//        while(!s1.isEmpty() && !s2.isEmpty()){
//            if(s1.peek()<s2.peek())
//                s.push(s1.pop());
//            else
//                s.push(s2.pop());
//        }
//        while(!s1.isEmpty())
//            s.push(s1.pop());
//        while(!s2.isEmpty())
//            s.push(s2.pop());
//        Stack<Integer> s3 = new Stack<>();
//        while (!s.isEmpty())
//            s3.push(s.pop());
//        s=s3;
//        return s;
//
//    }
//
//    public static void revStack(Stack<Integer> s){
//        if(!s.isEmpty()) {
//            int temp = s.pop();
//            revStack(s);
//            putBottom(s,temp);
//        }
//        return;
//    }
//
//    private static void putBottom(Stack<Integer> s, int x) {
//        if(s.isEmpty())
//            s.push(x);
//        else{
//            int temp = s.pop();
//            putBottom(s,x);
//            s.push(temp);
//        }
//    }
//
//
//    private static int numOfRotations(ArrayList<Integer> a) {
//        int max = 0;
//        int count = 0, c = 0;
//
//        for (int i = 0; i < a.size(); i++) {
//            c=0;
//            for (int j = 0; j < a.size(); j++) {
//                if (c > max) {
//                    max = c;
//                    count = i;
//                }
//                if(a.get(j)%2==0)
//                    c=0;
//                else
//                    c++;
//            }
//            a.add(0,a.remove(a.size()-1));
//        }
//        return count;
//    }
//    private static Stack movePrimes(Stack s){
//        Stack<Integer> s2 = new Stack<>();
//        while(!s.isEmpty()){
//            int x = (int)s.pop();
//            if(s2.isEmpty() || !isPrime(x))
//                s2.push(x);
//            else{
//                while(!isPrime(s2.peek()))
//                    s.push(s2.pop());
//                s2.push(x);
//            }
//        }
//        return s2;
//    }
//
//    private static boolean isPrime(int x) {
//        ArrayList<Integer> a = new ArrayList<>();
//
//        for(int i=2 ; i<=Math.sqrt(x) ; i++){
//            if(x%i==0)
//                return false;
//        }
//        return true;
//    }
//
//    public static void swapDuplicate(MmyLinkedList m2){
//        HashMap<Integer,Integer> hm = new HashMap<>();
//        Node curr = m2.getHead();
//        Integer rep = null ;
//        while(curr!=null){
//            hm.put((Integer) curr.getData(),hm.getOrDefault(curr.getData(),0)+1);
//            if(hm.get(curr.getData())==2)
//                rep=(Integer) curr.getData();
//            curr=curr.getNext();
//        }
//        ///////
//        Node pre = m2.getHead();
//        curr=pre.getNext();
//        if(m2.getHead().getData()!=rep){
//            while(curr.getData()!=rep) {
//                pre = pre.getNext();
//                curr = curr.getNext();
//            }
//            pre.setNext(curr.getNext());
//            curr.setNext(m2.getHead());
//            m2.setHead(curr);
//        }
//
//        //////
//
//        pre=m2.getHead();
//        curr=pre.getNext();
//        while(curr.getData()!=rep) {
//            pre = pre.getNext();
//            curr = curr.getNext();
//        }
//        if(curr!=m2.getTail()){
//            pre.setNext(curr.getNext());
//            m2.getTail().setNext(curr);
//            m2.setTail(curr);
//            m2.getTail().setNext(null);
//        }
//
//    }
//
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
//        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
//            if(e.getValue()%2!=0)
//                return false;
//        }

        return true;
    }
//
//    public static String convert(int n,int base){
//        MyStack3<Integer> s = new MyStack3<>();
//        while(n>0){
//            s.push(n%base);
//            n/=base;
//        }
//        String str = "";
//        while(!s.isEmpty()){
//            str+=s.pop();
//        }
//        return str;
//    }
//
//    public static String rev(String str){
//        String str2 = "";
//        MyStack3<Character> s = new MyStack3<>();
//        for(int i=0 ; i<str.length() ; i++)
//            s.push(str.charAt(i));
//        for(int i=0 ; i<str.length() ; i++)
//            str2+=s.pop();
//        return str2;
//    }
//    public static <E>E removeBottom(Stack<E> st){
//         if(st.isEmpty())
//             throw new EmptyStackException();
//         if(st.size()==1)
//             return st.pop();
//         E temp = st.pop();
//         E removed = removeBottom(st);
//         st.push(temp);
//         return removed;
//     }
//
//     public static MyLinkedList<Integer> mergeSorted(MyLinkedList<Integer> l1 , MyLinkedList<Integer> l2) {
//         MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();
//         Node curr1 = l1.getHead();
//         Node curr2 = l2.getHead();
//         while (curr1 != null && curr2 != null) {
//             if ((Integer) curr1.getData() < (Integer) curr2.getData()) {
//                 l3.addLast((Integer) curr1.getData());
//                 curr1 = curr1.getNext();
//             } else{
//                 l3.addLast((Integer) curr2.getData());
//                 curr2 = curr2.getNext();
//             }
//         }
//         while(curr1!=null){
//             l3.addLast((Integer) curr1.getData());
//             curr1 = curr1.getNext();
//         }
//
//         while(curr2!=null){
//             l3.addLast((Integer) curr2.getData());
//             curr2 = curr2.getNext();
//         }
//
//         return l3;
//     }
//
//
//
//    public static boolean check(String s){
//        MyStack<Character> stack = new MyStack<Character>();
//        for(int i=0 ; i<s.length() ; i++){
//            char c = s.charAt(i);
//            if(c=='('||c=='['||c=='{'){
//                stack.push(c);
//            }
//
//            else{
//                if (!stack.isEmpty()) {
//                    if (c == ')' && stack.peek() != '(')
//                        return false;
//                    if (c == ']' && stack.peek() != '[')
//                        return false;
//                    if (c == '}' && stack.peek() != '{')
//                        return false;
//                    stack.pop();
//                }
//                else
//                    return false;
//            }
//
//        }
//        return (stack.isEmpty());
//    }
//
//    public static int toInt(MyLinkedList<Boolean> x){
//        int z=0,y=0,i=0;
//        Node curr = x.getHead();
//        while(curr!=null){
//            z*=10;
//            boolean e = (Boolean)curr.getData();
//            if(e)
//                z+=1;
//            curr = curr.getNext();
//        }
//        while(z>0){
//            if(z%10==1)
//                y+=Math.pow(2,i);
//            z/=10;
//            i++;
//        }
//        return y;
//    }
}
