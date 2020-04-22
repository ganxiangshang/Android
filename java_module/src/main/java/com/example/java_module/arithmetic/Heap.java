package com.example.java_module.arithmetic;

public class Heap {

    /** ====================二叉堆===================================================*/

    /**
     * 上浮
     * 插入某个节点
     */
    public void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无须真正交互，单向赋值既可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉
     * 删除某个节点
     */
    public void downAdjust(int[] array, int parentIndex, int length) {
        //保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 构建堆
     */
    public void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次做下沉调整
        for (int i = (array.length - 2) / 2; i >= 0; i++){
            downAdjust(array, i , array.length);
        }
    }
}
