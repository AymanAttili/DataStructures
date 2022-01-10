package com.DataStructures.Sets;

import java.util.ArrayList;
import java.util.HashSet;

public class MyHashTable {
    private int size = 10;
    private HashNode<Integer,Integer>[]arr  = new HashNode[size];

    public MyHashTable() {
    }

    public void add(Integer key , Integer value) {
        int hash = hashCode(key);
        if (arr[hash] == null)
            arr[hash] = new HashNode(key, value);
        else if (arr[hash].key.equals(key)) {
            HashNode temp = arr[hash].next;
            arr[hash] = new HashNode<>(key, value);
            arr[hash].next = temp;
        }
        else {
            HashNode curr = arr[hash];
            while (curr.next!=null){
                if(curr.next.key.equals(key))
                    curr.next=curr.next.next;
                curr = curr.next;
            }
            curr.next = new HashNode<>(key,value);
        }
    }

    public void removeKey(Integer key){
        int hash = hashCode(key);
        if (arr[hash] == null)
            return;
        else if(arr[hash].key.equals(key))
            arr[hash] = arr[hash].next;
        else{
            HashNode curr = arr[hash];
            while (curr.next!=null){
                if(curr.next.key.equals(key)) {
                    curr.next = curr.next.next;
                    return;
                }
                curr = curr.next;
            }
        }
    }

    public void removeValue(Integer value){
        for (int i = 0; i < size; i++) {
            HashNode curr = arr[i];
            while(curr!=null)
            {
                if(curr.value.equals(value))
                    removeKey((Integer) curr.key);
                curr = curr.next;

            }
        }
    }

    public boolean containsKey(Integer key){
        int hash = hashCode(key);
        HashNode curr = arr[hash];
        while(curr!=null)
        {
            if(curr.key.equals(key))
                return true;
            curr = curr.next;

        }
        return false;
    }

    public boolean containsValue(Integer value){
        for (int i = 0; i < size; i++) {
            HashNode curr = arr[i];
            while(curr!=null)
            {
                if(curr.value.equals(value))
                    return true;
                curr = curr.next;

            }
        }
        return false;
    }

    public Integer get(Integer key){
        int hash = hashCode(key);
        HashNode curr = arr[hash];
        while(curr!=null){
            if(curr.key.equals(key))
                return (Integer) curr.value;
            curr=curr.next;
        }
        return null;
    }

    public Integer getOrDefault(Integer key, Integer defaultV){
        int hash = hashCode(key);
        HashNode curr = arr[hash];
        while(curr!=null){
            if(curr.key.equals(key))
                return (Integer) curr.value;
            curr=curr.next;
        }
        return defaultV;
    }

    public HashSet keySet(){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            HashNode curr = arr[i];
            while(curr!=null)
            {
                set.add((Integer) curr.key);
                curr = curr.next;
            }
        }
        return set;
    }

    public ArrayList<Integer> values(){
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            HashNode curr = arr[i];
            while(curr!=null)
            {
                a.add((Integer) curr.value);
                curr = curr.next;
            }
        }
        return a;
    }

    public void clear(){
        arr = new HashNode[size];
    }

    private int hashCode(Integer key) {
        return key%size;
    }

    @Override
    public String toString() {
        String str = "[ ";
        for (int i = 0; i < size; i++) {
            HashNode curr = arr[i];
            while(curr!=null)
            {
                str+=curr.toString()+" ";
                curr = curr.next;
            }
        }
        return str+"]";
    }
}
