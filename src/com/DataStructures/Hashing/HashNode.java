package com.DataStructures.Hashing;

public class HashNode<K,V> {
     K key;
    V value;
    HashNode next;

    public HashNode(K key ,V value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return "{" + key +" "+ value + '}';
    }
}
