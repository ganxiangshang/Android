package com.example.java_module.arithmetic;


public class LinkedList {

    private Node last;
    private Node head;
    private int size;

    public void insert(int data, int index){

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        Node insertNode = new Node(data);
        if (size == 0){
            head = insertNode;
            last = insertNode;
        }else if (index == 0){
            insertNode.next = head;
            head = insertNode;
        }else if (index == size){
            last.next = insertNode;
            last = insertNode;
        }else {
            /**
             * 先找到前后节点之后在处理插入节点
             */
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next;
            prevNode.next = insertNode;
            insertNode.next = nextNode;
        }
        size++;

        output();
    }

    public Node get(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        Node removeNode = null;
        if (index == 0){
            removeNode = head;
            head = removeNode.next;
        }else if (index == size -1){
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            Node nextNode = prevNode.next.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    public void output(){

        Node temp = head;
        while (temp != null){
            System.out.println("===linkedList===" + temp.data);
            temp = temp.next;
        }
    }

    class Node {

        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }
}


