package com.clansty.dstest;

public class MyQueue {
    private int[] elements = new int[11];
    private int head = 0;
    private int tail = 0;

    public int size() {
        return tail - head;
    }

    public void enqueue(int num) {
        if(size()==elements.length-1){
            System.out.println("full!");
            return;
        }
        if (tail == elements.length)
            tail = 0;
        elements[tail++] = num;
    }

    public int dequeue() {
        if (size()==0){
            System.out.println("empty!");
            return -1;
        }
        if (head == elements.length)
            head = 0;
        return elements[head++];
    }

    public void print() {
        if (head <= tail) {
            for (int i = head; i < tail; i++)
                System.out.print(elements[i] + " ");
        } else {
            for (int i = head; i < elements.length; i++)
                System.out.print(elements[i] + " ");
            for (int i = 0; i < tail; i++)
                System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
