package com.DataStructures.Non_generic.Stacks;


import java.util.EmptyStackException;
import java.util.Stack;
public class stackMethods {


    ////A method that removes the middle element in the stack(recursion).

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


    ////A method takes a string then if it finds a capital letter next to a small letter (similar letter) deletes them.

    public static String CapSma(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!s.isEmpty() && Math.abs(s.peek() - str.charAt(i)) == 32)
                s.pop();
            else
                s.push(str.charAt(i));
        }

        String str2 = "";
        while (!s.isEmpty())
            str2=s.pop()+str2;
        return str2;
    }


    ////A method that prints the next greater element for all elements of the array(if there is no next greater for an element the print -1).

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


    ////A method that merge two sorted stacks with keeping the resultant stack sorted.

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


    ////A method that reverses the given stack(recursion).

    public static void revStack(Stack<Integer> s){
        if(!s.isEmpty()) {
            int temp = s.pop();
            revStack(s);
            putBottom(s,temp);
        }
        return;
    }
    private static void putBottom(Stack<Integer> s, int x) {////to put the element x int the bottom of stack(recursion).
        if(s.isEmpty())
            s.push(x);
        else{
            int temp = s.pop();
            putBottom(s,x);
            s.push(temp);
        }
    }


    ////A method that moves prime numbers to the bottom of stack.

    private static Stack movePrimes(Stack s){
        Stack<Integer> s2 = new Stack<>();
        while(!s.isEmpty()){
            int x = (int)s.pop();
            if(s2.isEmpty() || !isPrime(x))
                s2.push(x);
            else{
                while(!s2.isEmpty() && !isPrime(s2.peek()))
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


    ////A method that converts the number n to a number with base (base).

    public static String convert(int n,int base){
        Stack<Integer> s = new Stack<>();
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


    ////A method that reverses the given string.

    public static String rev(String str){
        String str2 = "";
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<str.length() ; i++)
            s.push(str.charAt(i));
        for(int i=0 ; i<str.length() ; i++)
            str2+=s.pop();
        return str2;
    }


    ////A method that removes and returns the bottom element in the stack.

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


    ////A method that checks if the string of brackets-- {},(),[] --has no errors.

    public static boolean check(String s){
        Stack<Character> stack = new Stack<Character>();
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
