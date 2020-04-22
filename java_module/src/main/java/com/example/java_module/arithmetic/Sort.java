package com.example.java_module.arithmetic;

public class Sort {

    /**
     * 冒泡算法
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡算法优化
     *
     * @param array
     */
    public void bubbleOptimizeSort(int[] array) {
        int sortBorder = array.length - 1;
        int lastExchangedIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮默认为true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素交换，所以无需
                    isSorted = false;
                    lastExchangedIndex = j;
                }
            }
            sortBorder = lastExchangedIndex;
            if (isSorted) {
                break;
            }
        }
    }


    /**
     * 双边循环快速排序
     */
    public void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个位置(也可以随机选择位置)的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指针所指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     * 单边循环快速排序
     */
    public void quickSort2(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition2(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort2(arr, startIndex, pivotIndex - 1);
        quickSort2(arr, pivotIndex + 1, endIndex);
    }

    private int partition2(int[] arr, int startIndex, int endIndex){
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex; i < endIndex; i++){
            if (arr[i] < pivot){
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;

    }

}
