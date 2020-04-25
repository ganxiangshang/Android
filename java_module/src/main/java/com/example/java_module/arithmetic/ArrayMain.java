package com.example.java_module.arithmetic;

import com.example.java_module.arithmetic.ArrayInterview;

import java.util.Arrays;

public class ArrayMain {

    static ArrayInterview interview;
    static int[] arr = {1, 2, 4, 5, 6, 9};
    static int[] moveZeros = {1, 2, 0, 5, 0, 9};
    static int[] removeDuplicates = {1, 2, 3, 3, 4, 5, 6, 6, 9};
    static int[] removeElement = {1, 3, 4, 3, 2, 3, 9};


    public static void main(String[] args) {
        interview = new ArrayInterview();
        //binarySearch();

        //moveZeros();

//        removeDuplicates();

        removeElement();

//        lengthOfLongestSubstring();

        //fib();

        //bag();
    }

    private static void bag() {
        int[] w = new int[]{1, 3, 4};
        int[] v = new int[]{2,1,3};
        int bag = interview.bag(5, w, v);
        System.out.println("=====bag==" + bag);
    }

    private static void fib() {
        int i = interview.fib3(5);
        int i2 = interview.fib(5);
        System.out.println("=====fib====" + i);
        System.out.println("=====fib=i2==" + i2);
    }

    private static void lengthOfLongestSubstring() {
        int length = interview.lengthOfLongestSubstring("abcabcbb");
        System.out.println("=====lengthOfLongestSubstring====" + length);
    }

    private static void removeElement() {
        int i = interview.removeElement(removeElement, 3);
        System.out.println("=====removeElement====" + i);

        int[] ints = interview.twoSum2(arr, 15);

    }


    private static void removeDuplicates() {
        int ints = interview.removeDuplicates(removeDuplicates);
        System.out.println("========removeDuplicates====" + ints);
    }

    private static void moveZeros() {
        int[] ints = interview.moveZeros(moveZeros);
        System.out.println("========moveZeros====" + Arrays.toString(ints));
    }

    public static void binarySearch() {

        interview.binarySearch(arr, 5);
        System.out.println("============" + interview.binarySearch(arr, 5));
    }

}
