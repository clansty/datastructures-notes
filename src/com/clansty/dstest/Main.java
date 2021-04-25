package com.clansty.dstest;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var q = new MyQueue();
        q.print();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        q.print();
        for (int i = 0; i < 3; i++) {
            System.out.println(q.dequeue());
        }
        q.print();
        for (int i = 0; i < 3; i++) {
            q.enqueue(i);
        }
        q.print();
        for (int i = 0; i < 10; i++) {
            q.dequeue();
        }
        q.print();
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