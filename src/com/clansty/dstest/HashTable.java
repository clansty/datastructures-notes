package com.clansty.dstest;

public class HashTable {
    KeyValuePair[] pairs = new KeyValuePair[13];

    public void set(int key, int value) {
        int index = key % pairs.length;
        if (pairs[index] != null) {
            var parent = pairs[index];
            while (parent.next != null) {
                parent = parent.next;
            }
            parent.next = new KeyValuePair(key, value);
        } else {
            pairs[index] = new KeyValuePair(key, value);
        }
    }

    public int get(int key) {
        int index = key % pairs.length;
        var pair=pairs[index];
        while (pair!=null){
            if(pair.key==key)
                return pair.value;
            pair=pair.next;
        }
        return -1;//not found
    }

    public void delete(int key){
        int index = key % pairs.length;
        if(pairs[index]==null)
            return;
        if(pairs[index].key==key)
        {
            pairs[index]=pairs[index].next;
            return;
        }
        var parent=pairs[index];
        while(true){
            if(parent.next == null)
                return;
            if(parent.next.key==key){
                parent.next=parent.next.next;
                return;
            }
            parent=parent.next;
        }
    }
}
