package com.clansty.dstest;

public class MyArrayList {
    private int[] elements = new int[5];
    private int size;

    /**
     * 消耗常数时间 O(1)
     *
     * @param v 要添加的整数
     */
    public void push(int v) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = v;
    }

    /**
     * 取也是常数时间
     *
     * @return
     */
    public int get(int index) {
        return elements[index];
    }

    /**
     * 消耗线性时间 O(n)
     *
     * @param position 要删除的项目的位置
     */
    public void delete(int position) {
        if (position >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        for (int i = position; i < size; i++) {
            elements[i] = elements[i + 1];
        }
    }

    /**
     * O(n)
     */
    public void insert(int s, int position) {
        size++;
        for (int i = size - 1; i > position; i--) {
            elements[i] = elements[i - 1];
        }
        elements[position] = s;
    }

    /**
     * O(n)
     */
    public int findIndex(int num) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == num)
                return i;
        }
        return -1;
    }

    public void deleteDuplicated() {
        //我想了很多种方法，感觉这么做应该最快
        var arr = new int[size];
        var newSize = 0;
        for (int i = 0; i < size; i++) {
            boolean exist = false;
            for (int j = 0; j < newSize; j++) {
                if (arr[j] == elements[i]) {
                    exist = true;
                    break;
                }
            }
            if (!exist)
                arr[newSize++] = elements[i];
        }
        elements = arr;
        size = newSize;
    }

    public void deleteDuplicated2() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                //if 不行，因为后面的序号会提前
                while (elements[i] == elements[j] && i < size && j < size) {
                    delete(j);
                }
            }
        }
    }

    public void deleteDuplicated3() {
        //这次换成删i
        for (int i = 0; i < size; i++) {
            while (true) {
                var breakFlag = true;
                for (int j = i + 1; j < size; j++) {
                    //if 不行，因为后面的序号会提前
                    if (i == j)
                        continue;
                    if (elements[i] == elements[j]) {
                        delete(i);
                        breakFlag = false;
                        //序号变了，得再检查一次
                    }
                }
                if (breakFlag)
                    break;
            }
        }
    }

    public int size() {
        return size;
    }
}
