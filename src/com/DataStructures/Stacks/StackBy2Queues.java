package com.DataStructures.Stacks;

import com.DataStructures.Queues.MyQueue;

public class StackBy2Queues {
    MyQueue q1 = new MyQueue();
    MyQueue q2 = new MyQueue();


    public StackBy2Queues() {
    }

    public void push(Integer value){
        if(q1.isEmpty())
            q1.enqueue(value);
        else{
            while(!q1.isEmpty())
                q2.enqueue(q1.dequeue());
            q1.enqueue(value);
            while(!q2.isEmpty())
                q1.enqueue(q2.dequeue());
        }
    }

    public Integer peek(){
        return q1.peek();
    }

    public Integer pop(){
        return q1.dequeue();
    }

}
