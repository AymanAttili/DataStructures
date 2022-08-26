package com.DataStructures.Generic.Queues;

public class QueueMethods {

    ////A method that reverses the queue(recursion).

    public static void revQueue(MyQueue q){
        if(q.isEmpty())
            return;
        int temp = q.dequeue();
        revQueue(q);
        q.enqueue(temp);
    }
}
