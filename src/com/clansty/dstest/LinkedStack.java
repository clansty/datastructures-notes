package com.clansty.dstest;

public class LinkedStack {
    private LinkedStackItem topItem = null;

    public void push(int i) {
        LinkedStackItem newItem = new LinkedStackItem(i);
        newItem.next = topItem;
        topItem = newItem;
    }

    public int top() {
        return topItem.value;
    }

    public int pop() {
        LinkedStackItem item = topItem;
        topItem = item.next;
        return item.value;
    }
}
