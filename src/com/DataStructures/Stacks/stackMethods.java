package com.DataStructures.Stacks;


import java.util.*;
public class stackMethods {

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

    //////////////
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

    //////////////
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
    //////////////
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

    //////////////
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

    //////////////
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
        for(int i=2 ; i<=Math.sqrt(x) ; i++){
            if(x%i==0)
                return false;
        }
        return true;
    }

    //////////////
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

    //////////////
    public static String rev(String str){
        String str2 = "";
        MyArrayListStack<Character> s = new MyArrayListStack<>();
        for(int i=0 ; i<str.length() ; i++)
            s.push(str.charAt(i));
        for(int i=0 ; i<str.length() ; i++)
            str2+=s.pop();
        return str2;
    }

    //////////////
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

    //////////////
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
}
