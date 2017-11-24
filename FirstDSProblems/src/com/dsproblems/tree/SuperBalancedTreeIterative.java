package com.dsproblems.tree;

import java.util.Scanner;
import java.util.Stack;

public class SuperBalancedTreeIterative {

    public enum StatusN{
        Visting,Visted,NotVisited;
    }
    public static class BinaryTreeNode{
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public String status;
        public int depthFromRoot;

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
        System.out.println(rootNode.status);
        printTree(rootNode.right);
    }

    public static void markAllAsNotVisited(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        markAllAsNotVisited(rootNode.left);
        rootNode.status = StatusN.NotVisited.toString();
        markAllAsNotVisited(rootNode.right);
    }


    public static boolean modifiedIsbalance(BinaryTreeNode rootNode) {

        markAllAsNotVisited(rootNode);

        BinaryTreeNode crawl = rootNode;
        Stack<BinaryTreeNode> dfsStack = new Stack<BinaryTreeNode>();
        crawl.status = StatusN.Visting.toString();
        crawl.depthFromRoot = 0;
        dfsStack.push(crawl);

        int count =0,min = 0, max =0;

        while(!dfsStack.isEmpty())
        {
            BinaryTreeNode peekNode = dfsStack.peek();

           if(peekNode.left == null && peekNode.right == null)
            {
                BinaryTreeNode nodeToPrint = dfsStack.pop();
                if(min == 0 || min > nodeToPrint.depthFromRoot)
                {
                    min = nodeToPrint.depthFromRoot;
                }

                if(max ==0 || max < nodeToPrint.depthFromRoot)
                {
                    max = nodeToPrint.depthFromRoot;
                }
                nodeToPrint.status = StatusN.Visted.toString();
                System.out.println("Printing node" +  nodeToPrint.value);
            } else if((peekNode.left ==null || peekNode.left.status.equals(StatusN.Visted.toString())) && ( peekNode.right == null || peekNode.right.status.equals(StatusN.Visted.toString())))
            {
                BinaryTreeNode nodeToPrint = dfsStack.pop();
                nodeToPrint.status = StatusN.Visted.toString();
                System.out.println("Printing node" +  nodeToPrint.value);
            }
            else if(peekNode.left != null && peekNode.left.status.equals(StatusN.NotVisited.toString())){
                peekNode.left.depthFromRoot =  peekNode.depthFromRoot + 1;
                peekNode.left.status = StatusN.Visting.toString();
                dfsStack.push(peekNode.left);
            }else if(peekNode.right!=null && peekNode.right.status.equals(StatusN.NotVisited.toString())){
               peekNode.right.depthFromRoot =  peekNode.depthFromRoot + 1;
               peekNode.right.status = StatusN.Visting.toString();
               dfsStack.push(peekNode.right);
            }
        }

        if(Math.abs(max - min) > 1 )
            return false;
        else
            return true;

    }


    public static void printDepthFirstSearch(BinaryTreeNode rootNode) {

        markAllAsNotVisited(rootNode);

        BinaryTreeNode crawl = rootNode;
        Stack<BinaryTreeNode> dfsStack = new Stack<BinaryTreeNode>();
        crawl.status = StatusN.Visting.toString();

        dfsStack.push(crawl);


        while(!dfsStack.isEmpty())
        {
            BinaryTreeNode peekNode = dfsStack.peek();

            if(peekNode.left == null && peekNode.right == null)
            {
                BinaryTreeNode nodeToPrint = dfsStack.pop();
                nodeToPrint.status = StatusN.Visted.toString();
                System.out.println("Printing node" +  nodeToPrint.value);
            } else if((peekNode.left.status.equals(StatusN.Visted.toString()) || peekNode.left ==null) && (peekNode.right.status.equals(StatusN.Visted.toString()) || peekNode.right == null))
            {
                BinaryTreeNode nodeToPrint = dfsStack.pop();
                nodeToPrint.status = StatusN.Visted.toString();
                System.out.println("Printing node" +  nodeToPrint.value);
            }
            else if(peekNode.left.status.equals(StatusN.NotVisited.toString())){
                peekNode.left.status = StatusN.Visting.toString();
                dfsStack.push(peekNode.left);
            }else if(peekNode.right.status.equals(StatusN.NotVisited.toString())){
                peekNode.right.status = StatusN.Visting.toString();
                dfsStack.push(peekNode.right);
            }
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

//        System.out.println("Print the Binary Tree");
//        printTree(root);
        System.out.print("Depth First search");
        System.out.print(modifiedIsbalance(root));
//        System.out.println("Height of the tree is ");
//        System.out.println(getHeight(root));
//
//        System.out.println("is Balanced ");
//        System.out.println(isBalanaced(root));

    }
}

