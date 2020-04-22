package com.example.java_module.arithmetic;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode() {
    }

    TreeNode(int data) {
        this.data = data;
    }

    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 递归前序遍历
     *
     * @param node
     */
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("=======tree===node==" + node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 非递归前序遍历 栈
     *
     * @param root
     */
    public void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println("=tree==node===" + treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     *
     * @param root
     */
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println("=========node==" + node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraveral(node.leftChild);
        System.out.println("=======tree===node==" + node.data);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树的深度
     */
    public int computeTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(computeTreeDepth(node.leftChild), computeTreeDepth(node.rightChild)) + 1;
    }

    /**
     * 左右子树反转
     * 4             4
     * 2   7       7     2
     */
    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        invertTree(node.leftChild);
        invertTree(node.rightChild);

        /**
         * swap(root.left, root.right)
         */
        TreeNode temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;

        return node;
    }

    /**
     * 二叉树的深度 递归
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.leftChild);
            int right_height = maxDepth(root.rightChild);
            return Math.max(left_height, right_height) + 1;
        }
    }

    /**
     * 最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.leftChild == null) && (root.leftChild == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.leftChild != null) {
            min_depth = Math.min(minDepth(root.leftChild), min_depth);
        }
        if (root.leftChild != null) {
            min_depth = Math.min(minDepth(root.leftChild), min_depth);
        }

        return min_depth + 1;
    }

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.data);

        // process child nodes for the next level
        if (node.leftChild != null)
            helper(node.leftChild, level + 1);
        if (node.rightChild != null)
            helper(node.rightChild, level + 1);
    }



    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            levels.add(new ArrayList<Integer>());
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.data);
                if (node.leftChild != null) queue.add(node.leftChild);
                if (node.rightChild != null) queue.add(node.rightChild);
            }
            // go to next level
            level++;
        }
        return levels;
    }



}
