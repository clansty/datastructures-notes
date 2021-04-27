package com.clansty.dstest;

public class KeyValuePair {
    KeyValuePair next=null;

    int key;
    int value;

    public KeyValuePair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
