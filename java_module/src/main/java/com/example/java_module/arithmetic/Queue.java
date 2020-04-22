package com.example.java_module.arithmetic;

public class Queue {

    /**
     * 在数据不扩容的前提下，可以利用已出队元素留下的空间，让队尾指针重新指回数组的首位。
     * 使用循环队列不但充分利用数组的空间，还避免了数组元素整体移动的麻烦。
     */

    private int [] array;
    private int front;
    private int rear; //队尾

    public Queue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element
     * @throws Exception
     */
    public void enQueue(int element) throws Exception {
        if ((rear + 1)%array.length == front){
            throw new Exception("队列已满");
        }

        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * @return
     */
    public int deQueue() throws Exception {
        if (rear == front){
            throw new Exception("队列已空");
        }

        int deQueueElement = array[front];
        front = (front + 1) % array.length;
        return deQueueElement;
    }

}
