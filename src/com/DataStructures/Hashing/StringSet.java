package com.DataStructures.Hashing;

import com.DataStructures.Node;

public class StringSet {
    private Node<String>[] arr = new Node[52];

    public StringSet() {
    }

    public void add(String str){
        int hash = hashCode(str);
        if(hash!=-1){
            if(arr[hash]==null)
                arr[hash] = new Node<String>(str);
            else{
                Node curr = arr[hash];
                while(curr.getNext()!=null){
                    if(curr.getData().equals(str))
                        return;
                    curr = curr.getNext();
                }
                if(curr.getData().equals(str))
                    return;
                curr.setNext(new Node<String>(str));

            }

        }
    }


    public int hashCode(String str){
       char c = str.charAt(0);

       if(c>='A' && c<='Z'){
            return 2*(c-'A')+1;
       }

       else if(c>='a' && c<='z'){
           return 2*(c-'a');
       }
       else
           return -1;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]!=null){
                Node curr = arr[i];
                while(curr!=null){
                    str+=curr.getData()+" ";
                    curr = curr.getNext();
                }
                str+="\n";
            }
        }
        return str;
    }
}
