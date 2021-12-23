package com.company;

import java.util.*;

public class MyHashTable<K,V> {
    private ArrayList<HashNode> arr = new ArrayList<>();
    private int size = arr.size();

    public MyHashTable() {
    }

    public boolean contains(K key){
        for(int i=0 ; i<arr.size() ; i++){
            if(arr.get(i).key.equals(key))
                return true;
        }
        return false;
    }


    public void add(K key, V value) {
        for(int i=0 ; i<arr.size() ; i++){
            if(arr.get(i).key.equals(key)) {
                arr.remove(i);
                size--;
                break;
            }
        }
        arr.add(new HashNode(key,value));
        size++;
    }



    public void removeKey(K key) {
        for(int i=0 ; i<arr.size() ; i++){
            if(arr.get(i).key.equals(key)) {
                arr.remove(i);
                size--;
                break;
            }
        }
    }

    public void removeValue(V value) {
        for(int i=0 ; i<arr.size() ; i++){
            if(arr.get(i).value.equals(value)) {
                arr.remove(i--);
                size--;
            }
        }
    }

    public HashSet<K> keySet() {
        HashSet<K> s = new HashSet<K>();
        for(int i=0 ; i<arr.size() ; i++)
            s.add((K)arr.get(i).key);
        return s;
    }

    public ArrayList<V> values() {
        ArrayList<V> val = new ArrayList<>();
        for(int i=0 ; i<arr.size() ; i++)
            val.add((V)arr.get(i).value);
        return val;
    }

    public ArrayList<HashNode> entrySet() {
        return arr;
    }

    @Override
    public String toString() {
        return arr.toString();
    }


}
