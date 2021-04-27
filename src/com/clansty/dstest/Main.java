package com.clansty.dstest;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var t=new HashTable();
        System.out.println(t.get(1));
        t.set(1,2);
        t.set(23333,66666);
        t.set(13,3);
        t.set(26,4);
        System.out.println(t.get(1));
        System.out.println(t.get(23333));
        System.out.println(t.get(13));
        System.out.println(t.get(26));
        t.delete(26);
        System.out.println(t.get(13));
        System.out.println(t.get(26));
        t.delete(13);
        System.out.println(t.get(13));
        System.out.println(t.get(26));
    }

    static void arrayListBenchmark() {
        var lists = new MyArrayList[3];
        var rnd = new Random();
        for (int i = 0; i < 3; i++) {
            lists[i] = new MyArrayList();
        }
        for (int j = 0; j < 100000; j++) {
            var rndNum = rnd.nextInt(100);
            for (int i = 0; i < 3; i++) {
                lists[i].push(rndNum);
            }
        }
        for (int i = 0; i < 3; i++) {
            var list = lists[i];
            long begin = System.currentTimeMillis();
            if (i == 0)
                list.deleteDuplicated();
            else if (i == 1)
                list.deleteDuplicated2();
            else
                list.deleteDuplicated3();
            long end = System.currentTimeMillis();
            System.out.println(end - begin);
        }
    }
}