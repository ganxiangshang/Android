package com.example.java_module.arithmetic;

import java.util.HashMap;

public class LRUCache {

    private Node head;
    private Node end;
    //缓存上限
    private int limit;

    private HashMap<String, Node> hashMap;

    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        refreshNode(node);
        return node.value;

    }

    public void put(String key, String value){
        Node node = hashMap.get(key);
        if (node == null){
            if (hashMap.size() >= limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        }else {
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private String removeNode(Node node){
        if (node == head && node == end){
            head = null;
            end = null;
        }else if (node == end){
            end = end.pre;
            end.next = null;
        }else if (node == head){
            head = head.next;
            head.pre = null;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    private void refreshNode(Node node){
        if (node == end){
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private void addNode(Node node){
        if (end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null){
            head = node;
        }
    }

    class Node{
        String key;
        String value;
        public Node pre;
        public Node next;
        Node(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

}
