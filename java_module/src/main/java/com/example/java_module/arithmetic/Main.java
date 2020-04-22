package com.example.java_module.arithmetic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] rags) {

        //testArray();

        //testLinkedList();

        //testTreeNode();

        //testHeap();

        //testBubbleSort();

        //testInterview();

        //testGCD();

        //testFindNum();

        //testRedPackage();

        //testReverseLinked();

        //testSwapNode();

        //levelOrder();

        god();
    }

    private static void god() {
        //200/3, 300/4, 350/3, 400/5, 500/5
        Interview.MaxGold maxGold = new Interview.MaxGold();
        int[] p = {3, 4, 3, 5, 5};
        int[] g = {200, 300, 350, 400, 500};
        int bestGoldMining = maxGold.getBestGoldMining(10, p, g);
        System.out.println("=============bestGoldMining===" + bestGoldMining);
    }

    private static void levelOrder() {
        TreeNode node = new TreeNode();
        java.util.LinkedList<Integer> inputList = new java.util.LinkedList<>(Arrays.asList(
                new Integer[]{3, 9, 20, null, null, 15, 7}
        ));
        TreeNode treeNode = node.createBinaryTree(inputList);
        List<List<Integer>> lists = node.levelOrder(treeNode);
        System.out.println("=============levelOrder===" + lists);
    }

    private static void testSwapNode() {
        Interview cycleNode = new Interview();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node reverse = cycleNode.swapNode2(node1);
        System.out.println("=====testSwapNode===" + reverse.toString());
    }

    private static void testReverseLinked() {

        Interview cycleNode = new Interview();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node reverse = cycleNode.reverse(node1);
        System.out.println("=====reverse===" + reverse.toString());

    }

    private static void testRedPackage() {
        Interview interview = new Interview();
        List<Integer> amountList = interview.divideRedPackage(1000, 3);
        for (Integer amount : amountList) {
            System.out.println("=============" + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }

    private static void testFindNum() {

        Interview.FindNum findNum = new Interview.FindNum();
        int[] array = {4, 1, 2, 2, 5, 1, 4, 3};
        int[] result = findNum.findLostNum(array);
        System.out.println(result[0] + "====" + result[1]);
    }

    private static void testGCD() {

        Interview.CommonDivisor commonDivisor = new Interview.CommonDivisor();

        System.out.println(commonDivisor.gcd(25, 5));
        System.out.println(commonDivisor.gcd(100, 10));
        System.out.println(commonDivisor.gcd(57, 21));

    }

    private static void testInterview() {

        Node node1 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        Interview.CycleNode interview = new Interview.CycleNode();

        Node cycleNode = interview.isCycleNode(node1);
        int i = interview.cycleLength(node1);
        System.out.println("==========length===" + i);
        Node node = interview.meetNode(node1);

    }

    private static void testBubbleSort() {
        Sort sort = new Sort();
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        //sort.bubbleOptimizeSort(array);
        sort.quickSort(array, 0, array.length - 1);
        System.out.println("=======quick===" + Arrays.toString(array));
    }

    private static void testHeap() {
        Heap heap = new Heap();
        int[] array = {1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heap.upAdjust(array);
        System.out.println("======array=up===" + Arrays.toString(array));

        array = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        heap.buildHeap(array);
        System.out.println("======array=down=" + Arrays.toString(array));

    }

    private static void testTreeNode() {
        TreeNode node = new TreeNode();
        java.util.LinkedList<Integer> inputList = new java.util.LinkedList<>(Arrays.asList(
                new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}
        ));
        TreeNode treeNode = node.createBinaryTree(inputList);
        node.levelOrderTraversal(treeNode);
    }

    private static void testLinkedList() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(6, 0);
    }

    private static void testArray() {
        Array array = new Array(10);
        array.insert(1, 0);
    }

}
