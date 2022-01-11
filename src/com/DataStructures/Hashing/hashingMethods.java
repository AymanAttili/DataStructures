package com.DataStructures.Hashing;

import com.DataStructures.LinkedLists.MyLinkedList;
import com.DataStructures.LinkedLists.Node;

import java.util.*;

public class hashingMethods {

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

    ////////////
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

    ////////////
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

    ////////////
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

    ////////////
    public static int numOfJewels(String[] stones, String[] jewels) {
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

    ////////////
    public static boolean pangram(String str){
        HashSet<Character> set = new HashSet<>();
        for(int i=0 ; i<str.length() ; i++){
            set.add(str.charAt(i));
        }
        return (set.size()==26);
    }

    ////////////
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

    ////////////
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

    ////////////
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

    ////////////
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

    ////////////
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

    ////////////
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

    ////////////
    public static void swapDuplicate(MyLinkedList m2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Node curr = m2.getHead();
        Integer rep = null;
        while (curr != null) {
            hm.put((Integer) curr.getData(), hm.getOrDefault(curr.getData(), 0) + 1);
            if (hm.get(curr.getData()) == 2)
                rep = (Integer) curr.getData();
            curr = curr.getNext();
        }
        ///////
        Node pre = m2.getHead();
        curr = pre.getNext();
        if (m2.getHead().getData() != rep) {
            while (curr.getData() != rep) {
                pre = pre.getNext();
                curr = curr.getNext();
            }
            pre.setNext(curr.getNext());
            curr.setNext(m2.getHead());
            m2.setHead(curr);
        }

        //////

        pre = m2.getHead();
        curr = pre.getNext();
        while (curr.getData() != rep) {
            pre = pre.getNext();
            curr = curr.getNext();
        }
        if (curr != m2.getTail()) {
            pre.setNext(curr.getNext());
            m2.getTail().setNext(curr);
            m2.setTail(curr);
            m2.getTail().setNext(null);
        }
    }

    ////////////
    public static boolean fun(ArrayList<Integer> arr) {
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

    ////////////
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
}
