package com.clansty.dstest;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var t=new BinaryTree();
        var r=new Random();
        for (int i = 0; i < 1000; i++) {
            t.insert(r.nextInt(20));
        }
        t.printPreorder();
        t.printInorder();
        t.printPostorder();
        System.out.println(t.contains(20));
        System.out.println(t.contains(10));
        t.insert(-1);
        t.insert(55);
        t.printInorder();
        t.delete(5);
        t.delete(10);
        t.delete(15);
        t.delete(20);
        t.printInorder();
        t.insert(10);
        t.printInorder();
        System.out.println(t.findMin());
        System.out.println(t.findMax());

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