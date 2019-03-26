package com.meek.算法.数据结构.树;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class 树的四种遍历 {


    /**
     * 前序遍历 - 递归
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        print(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 前序遍历 - 非递归实现
     *
     * @param root
     */
    public void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        //右结点先入栈，左结点后入栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            print(node.value);
            //右节点先入栈，左节点后入栈(先入后出)
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    /**
     * 中序遍历 - 递归
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        print(root.value);
        inOrder(root.right);
    }

    /**
     * 中序遍历 - 非递归
     *
     * @param root
     */
    public void inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //若节点补位null,一直压栈左边节点
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            //若左节点为空
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                print(node.value);
                //遍历右节点的所有左节点
                root = root.right;
            }
        }

    }

    /**
     * 后序遍历 - 递归
     *
     * @param root
     */
    public void afterOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        inOrder(root.right);
        print(root.value);
    }

    /**
     * 后序遍历 - 非递归
     *
     * @param root
     */
    public void afterOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            print(node.value);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }


    /**
     * 层序遍历（广度优先遍历）
     */
    public void layerOrder(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            print(node.value);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
    /**
     * 打印
     *
     * @param value
     */
    public void print(Object value) {
        System.out.println(value.toString());
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
