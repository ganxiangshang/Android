package com.example.java_module.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Interview {

    /**
     * 判断链表有环并求环的长度，环接点
     */
    public static class CycleNode {

        /**
         * 判断一个链表有环
         * 思路，两个指针，一个移动一个节点，一个移动两个节点
         */
        public Node isCycleNode(Node head) {
            Node p1 = head;
            Node p2 = head;
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
                if (p1 == p2) {
                    return p1;
                }
            }
            return null;
        }

        /**
         * 求环长度
         * 让慢的指针从相遇点继续循环前进，并统计前进的次数，直到第二次相遇。
         * cycleNode为以一次相遇点
         */
        public int cycleLength(Node head) {
            Node cycleNode = isCycleNode(head);
            int count = 0;
            if (cycleNode != null) {
                Node p1 = cycleNode;
                while (p1.next != cycleNode) {
                    count++;
                    p1 = p1.next;
                }
                count++;
            }
            return count;
        }

        /**
         * 求环节点
         * 当相遇时，一个指针放回到头结点位置，另一个指针在相遇点，每次向前走一步，当相遇时，就是环节点。
         * cycleNode为以一次相遇点
         */
        public Node meetNode(Node head) {
            Node cycleNode = isCycleNode(head);
            while (head != cycleNode) {
                head = head.next;
                cycleNode = cycleNode.next;
            }
            return cycleNode;
        }

    }

    /**
     * ============================================
     */

    /**
     * 两个链表相加
     */
    public Node twoNodeSum(Node node1, Node node2) {
        Node dummy = new Node(0);
        Node p1 = node1;
        Node p2 = node2;
        Node cur = dummy;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 != null ? p1.data : 0;
            int y = p2 != null ? p2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new Node(sum % 10);
            cur = cur.next;
            if (p1 != null){
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if (carry > 0){
            cur.next = new Node(carry);
        }
        return dummy.next;
    }

    /**
     * 将链表反转
     */
    public Node reverse(Node head) {
        Node pre = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * ============================================
     */

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
     * 递归
     */
    public Node swapNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node firstNode = head;
        Node secondNode = head.next;
        firstNode.next = swapNode(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
     * preNode的作用，主要在于 preNode.next 指向
     */
    public Node swapNode2(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node preNode = dummy;
        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            preNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            preNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    /**
     * 将两个有序链表合并
     */
    public Node mergeTwoList(Node node1, Node node2) {
        Node dummy = new Node(0);
        Node head = dummy;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                head.next = new Node(node1.data);
                node1 = node1.next;
            } else {
                head.next = new Node(node2.data);
                node2 = node2.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    /**
     * ============================================
     */

    /**
     * 实现一个栈，该栈带有出栈、入栈、取最小元素
     * 两个栈，一个是主栈，处理各种操作；另一个当push时，比较，如果小就入栈
     */
    public static class MinStack {

        private Stack<Integer> mainStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int element) {
            mainStack.push(element);
            if (minStack.isEmpty() || element < minStack.peek()) {
                minStack.push(element);
            }
        }

        public int pop() {
            if (mainStack.peek() == minStack.peek()) {
                minStack.pop();
            }
            return mainStack.pop();
        }

        public int getMin() throws Exception {
            if (mainStack.isEmpty()) {
                throw new Exception("stack is empty");
            }
            return minStack.peek();
        }

    }

    /**
     * ============================================
     */

    /**
     * 求最大公约数
     */
    public static class CommonDivisor {
        /**
         * (a & 1) == 0，说明 a 是偶数
         */
        public int gcd(int a, int b) {
            if (a == b) {
                return a;
            }
            if ((a & 1) == 0 && (b & 1) == 0) {
                return gcd(a >> 1, b >> 1) << 1;
            } else if ((a & 1) == 0 && (b & 1) != 0) {
                return gcd(a >> 1, b);
            } else if ((a & 1) != 0 && (b & 1) == 0) {
                return gcd(a, b >> 1);
            } else {
                int big = a > b ? a : b;
                int small = a < b ? a : b;
                return gcd(big - small, small);
            }
        }

    }


    /**
     * ============================================
     */

    /**
     * 判断一个整数是否是2的整数次幂
     * 2的整数次幂一旦减一，它的二进制数字就全变成1了。
     */
    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }

    /**
     * ============================================
     */

    /**
     * 无序数组排序后的最大相邻差
     */
    public static class MaxSortedDistance {

        public int getMaxSortedDistance(int[] array) {
            int max = array[0];
            int min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
                if (array[i] < min) {
                    min = array[i];
                }
            }

            int d = max - min;
            if (d == 0) {
                return 0;
            }
            //初始化桶
            int bucketNum = array.length;
            Bucket[] buckets = new Bucket[bucketNum];
            for (int i = 0; i < bucketNum; i++) {
                buckets[i] = new Bucket();
            }
            //遍历初始数组，确定每个桶的最大最小值
            for (int i = 0; i < array.length; i++) {
                int index = (array[i] - min) * (bucketNum - 1) / d;
                if (buckets[index].min == null || buckets[index].min > array[i]) {
                    buckets[index].min = array[i];
                }
                if (buckets[index].max == null || buckets[index].max < array[i]) {
                    buckets[index].max = array[i];
                }
            }

            //桶遍历，找到最大差值
            //leftMax临时变量leftMax，在每一轮迭代时存储当前左侧桶的最大值。而两个桶之间的产值，buckets[i].min - leftMax
            int leftMax = buckets[0].max;
            int maxDistance = 0;
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i].min == null) {
                    continue;
                }
                if (buckets[i].min - leftMax > maxDistance) {
                    maxDistance = buckets[i].min - leftMax;
                }
                leftMax = buckets[i].max;
            }

            return maxDistance;
        }

        public class Bucket {
            Integer min;
            Integer max;
        }
    }


    /**
     * ============================================
     */

    /**
     * 用栈来模拟一个队列
     */
    public static class StackQueue {
        Stack<Integer> stackA = new Stack<Integer>();
        Stack<Integer> stackB = new Stack<Integer>();
        /**
         * 入队
         *
         * @param element
         */
        public void enQueue(int element) {
            stackA.push(element);
        }
        /**
         * 出队
         *
         * @return
         */
        public Integer deQueue() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    return null;
                }
                transfer();
            }
            return stackB.pop();
        }

        private void transfer() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }

    /**
     * ============================================
     */

    /**
     * 一个整数所包含数组的全部组合中，找一个大于且仅大于原数的新整数
     * 12345，返回 12354
     * 12354，返回 12435
     */
    public static class NearestNumber {

        public int[] findNearestNumber(int[] numbers) {
            //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界。
            int index = findTransferPoint(numbers);
            if (index == 0) {
                return null;
            }
            //把逆序区域的前一位和逆序区域的中刚刚大于它的数字交换位置
            int[] numberCopy = Arrays.copyOf(numbers, numbers.length);
            exchangeHead(numberCopy, index);
            //把原来的逆序区域转为顺序
            reverse(numberCopy, index);
            return numberCopy;
        }

        public int findTransferPoint(int[] numbers) {
            for (int i = numbers.length - 1; i > 0; i--) {
                if (numbers[i] > numbers[i - 1]) {
                    return i;
                }
            }
            return 0;
        }

        public int[] exchangeHead(int[] numbers, int index) {
            int head = numbers[index - 1];
            for (int i = numbers.length - 1; i > 0; i--) {
                if (head < numbers[i]) {
                    numbers[index - 1] = numbers[i];
                    numbers[i] = head;
                    break;
                }
            }
            return numbers;
        }

        public int[] reverse(int[] num, int index) {
            for (int i = index, j = num.length - 1; i < j; i++, j--) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
            return num;
        }

    }


    /**
     * ============================================
     */

    /**
     * 删除K个数得到最小值
     * 7682834 删除 2个数字 78 得到 62834
     */
    public static class RemoveResultMin {

        public String removeKDigists(String num, int k) {

            int newLength = num.length() - k;
            char[] stack = new char[num.length()];
            int top = 0;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                while (top > 0 && stack[top - 1] > c && k > 0) {
                    top -= 1;
                    k -= 1;
                }
                stack[top++] = c;
            }
            int offset = 0;
            while (offset < newLength && stack[offset] == '0') {
                offset++;
            }
            return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
        }
    }

    /**
     * ============================================
     */

    /**
     * 两个大数相加
     */
    public static class TwoBigNumberSum {

        public String bigNumberSum(String numA, String numB) {
            int maxLength = numA.length() > numB.length() ? numA.length() : numB.length();
            int[] arrayA = new int[maxLength + 1];
            for (int i = 0; i < numA.length(); i++) {
                arrayA[i] = numA.charAt(numA.length() - 1 - i) - '0';
            }
            int[] arrayB = new int[maxLength + 1];
            for (int i = 0; i < numB.length(); i++) {
                arrayA[i] = numA.charAt(numB.length() - 1 - i) - '0';
            }
            //构建result数组，数组长度等于较大整数位数 + 1
            int[] result = new int[maxLength + 1];
            for (int i = 0; i < result.length; i++) {
                int temp = result[i];
                temp += arrayA[i];
                temp += arrayB[i];
                //判断是否就位
                if (temp >= 10) {
                    temp = temp - 10;
                    result[i + 1] = 1;
                }
                result[i] = temp;
            }

            StringBuffer sb = new StringBuffer();
            boolean findFirst = false;
            for (int i = result.length - 1; i >= 0; i--) {
                if (!findFirst) {
                    if (result[i] == 0) {
                        continue;
                    }
                    findFirst = true;
                }
                sb.append(result[i]);
            }
            return sb.toString();
        }
    }


    /**
     * ============================================
     */

    /**
     * 金矿为题
     * 10名工人 200/3, 300/4, 350/3, 400/5, 500/5
     * 如何得到最大值
     * 动态规划思想，对于每一个金矿，都有挖或者不挖两种选择
     * F(n,w) = max(F(n-1,w), F(n-1,w-p[n-1]) + g[n-1]) (n >= 1, w >= p[n-1])
     */
    public static class MaxGold {

        /**
         * 获得金矿最优收益
         *
         * @param w 工人数量
         * @param p 金矿开采需要人数
         * @param g 金矿储量
         * @return
         */
        public int getBestGoldMining(int w, int[] p, int[] g) {
            //创建当前结果
            int[] results = new int[w + 1];
            for (int i = 1; i < g.length; i++) {
                for (int j = w; j >= 1; j--) {
                    if (j >= p[i - 1]) {
                        results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
                    }
                }
            }
            return results[w];
        }
    }


    /**
     * ============================================
     */

    /**
     * 无须正整数数组中，98个整数出现了偶数次，2个奇数次，找出这两个数
     */
    public static class FindNum {
        /**
         * 异或运算
         */
        public int[] findLostNum(int[] array) {
            //用来存储2个整数
            int[] result = new int[2];
            int xorResult = 0;
            for (int i = 0; i < array.length; i++) {
                xorResult ^= array[i];
            }
            if (xorResult == 0) {
                return null;
            }
            int separator = 1;
            while (0 == (xorResult & separator)) {
                separator <<= 1;
            }
            //第二次进行异或运算
            for (int i = 0; i < array.length; i++) {
                if (0 == (array[i] & separator)) {
                    result[0] ^= array[i];
                } else {
                    result[1] ^= array[i];
                }
            }
            return result;
        }
    }


    /**
     * ============================================
     */

    /**
     * 抢红包
     *
     * @param totalAmount 总金额
     * @param totalPeople 总人数
     *                    <p>
     *                    二倍均值法
     *                    每次抢到的红包 = 随机区间[0.01, m/n *2 -0.01]
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeople) {
        ArrayList<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeople = totalPeople;
        Random random = new Random();
        for (int i = 0; i < totalPeople - 1; i++) {
            int amount = random.nextInt(restAmount / restPeople * 2 - 2) + 1;
            restAmount -= amount;
            restPeople--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }
}
