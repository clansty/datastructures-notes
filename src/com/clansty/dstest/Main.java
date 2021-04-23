package com.clansty.dstest;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
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
            long begin = System.currentTimeMillis();
            testArrayList(i, lists[i]);
            long end = System.currentTimeMillis();
            System.out.println(end - begin);
        }
    }

    static void testArrayList(int wayToDelete, MyArrayList list) {
        if (wayToDelete == 0)
            list.deleteDuplicated();
        else if (wayToDelete == 1)
            list.deleteDuplicated2();
        else
            list.deleteDuplicated3();
    }
}