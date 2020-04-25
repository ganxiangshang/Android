package com.example.java_module.arithmetic;

public class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        Node head = this;
        StringBuilder builder = new StringBuilder();
        while (head != null){
            builder.append("====="+ head.data);
            head = head.next;
        }
        return builder.toString();
    }
}
