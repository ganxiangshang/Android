package com.example.java_module.arithmetic;

public class Array {

    private int[] array;
    private int size;

    public Array(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * @param element 插入的元素
     * @param index   插入的位置
     */
    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        if (size >= array.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
        outPut();
    }

    private void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }


    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        int deleteElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        outPut();
        return deleteElement;
    }

    private void outPut(){
        for (int i = 0; i < size; i++) {
            System.out.println("================array===" + array[i]);
        }
    }

}
