package com.dsproblems;

import java.util.Scanner;

public class SuperBalancedTree {

    public static class BinaryTreeNode{
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static void printTree(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        printTree(rootNode.left);
        System.out.println(rootNode.value);
        printTree(rootNode.right);
    }

    public static int getHeight(BinaryTreeNode rootNode)
    {
        if(rootNode == null)
            return 0;
        else
            return Math.max(getHeight(rootNode.left),getHeight(rootNode.right)) + 1;
    }

    public static boolean isBalanaced(BinaryTreeNode rootNode)
    {
        if(rootNode == null)
        {
            return true;
        }
        if(Math.abs(getHeight(rootNode.right) - getHeight(rootNode.left)) > 1)
        {
            return false;
        }
        else
        {
            return isBalanaced(rootNode.left) && isBalanaced(rootNode.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = null;
        boolean continueFlag = true;
        while(continueFlag) {
            System.out.println("Enter value for next element");
            Scanner in = new Scanner(System.in);
            int nextValue = in.nextInt();
            if(root==null)
            {
                root = new BinaryTreeNode(nextValue);
            }else
            {
                BinaryTreeNode crawl = root;
                while(true) {
                    if (crawl.left != null && crawl.value >= nextValue) {
                        crawl = crawl.left;
                    } else if (crawl.right != null && crawl.value < nextValue) {
                        crawl = crawl.right;
                    } else {
                        break;
                    }
                }
                if (crawl.value >= nextValue && crawl.left == null) {
                    crawl = crawl.insertLeft(nextValue);
                } else if (crawl.right == null && crawl.value < nextValue) {
                    crawl = crawl.insertRight(nextValue);
                }
            }
            System.out.println("Do you want to add more elements");
            continueFlag = in.nextBoolean();
        }

        System.out.println("Print the Binary Tree");
        printTree(root);
        System.out.println("Height of the tree is ");
        System.out.println(getHeight(root));

        System.out.println("is Balanced ");
        System.out.println(isBalanaced(root));

    }
}
