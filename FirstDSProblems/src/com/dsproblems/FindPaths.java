package com.dsproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPaths {

    static class Tree {
        BinaryTreeNode head = null;

        public void addElement(Integer newValue) {
            if (head == null) {
                head = new BinaryTreeNode();
                head.value = newValue;
                head.left = null;
                head.right = null;
            } else {
                BinaryTreeNode travseNode = head;
                while (true) {
                    if (travseNode.value > newValue && travseNode.left != null) {
                        travseNode = travseNode.left;
                    } else if (travseNode.value <= newValue && travseNode.right != null) {
                        travseNode = travseNode.right;
                    } else {
                        break;
                    }
                }
                BinaryTreeNode newNode = new BinaryTreeNode();
                newNode.value = newValue;
                newNode.left = null;
                newNode.right = null;

                if (travseNode.value > newValue && travseNode.left == null) {
                    travseNode.left = newNode;
                }
                if (travseNode.value <= newValue && travseNode.right == null) {
                    travseNode.right = newNode;
                }
            }
        }

        public void printInOrderTree(BinaryTreeNode currNode) {
            if (currNode == null) {
                return;
            }
            printInOrderTree(currNode.left);
            System.out.println(currNode.value);
            printInOrderTree(currNode.right);
        }

        public Integer findTheListOfSum(BinaryTreeNode currNode, HashMap<Integer,List<BinaryTreeNode>> sumOfSubNodes){
            Integer sum =0;
            List<BinaryTreeNode> list ;
            if(currNode == null)
                return null;
            if(currNode.left == null && currNode.right == null)
                return currNode.value;
            if(currNode.left != null) {
                 sum = currNode.value + findTheListOfSum(currNode.left, sumOfSubNodes);
                 if(sumOfSubNodes.containsKey(sum)){
                     list = sumOfSubNodes.get(sum);
                 }else{
                     list = new ArrayList<BinaryTreeNode>();
                     list.add(currNode);
                 }
                sumOfSubNodes.put(sum,list);
            }
            if(currNode.right != null) {
                sum = currNode.value + findTheListOfSum(currNode.right, sumOfSubNodes);
                if(sumOfSubNodes.containsKey(sum)){
                    list = sumOfSubNodes.get(sum);
                }else{
                    list = new ArrayList<BinaryTreeNode>();
                    list.add(currNode);
                }
                sumOfSubNodes.put(sum,list);
            }
            return sum;
        }

    }

    static class BinaryTreeNode{
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public static void main(String[] args) {
        Tree newTree = new Tree();
        newTree.addElement(10);
        newTree.addElement(5);

        newTree.addElement(7);

        newTree.addElement(6);

        newTree.addElement(15);

        newTree.addElement(17);

        newTree.addElement(16);

        newTree.printInOrderTree(newTree.head);

        HashMap<Integer,List<BinaryTreeNode>> listOfSums = new HashMap<Integer,List<BinaryTreeNode>>();
        newTree.findTheListOfSum(newTree.head,listOfSums);

        for(Map.Entry entry : listOfSums.entrySet()){
            System.out.println("Printing the sum " + entry.getKey());
            List<BinaryTreeNode> newList = (List) entry.getValue();
           // System.out.println("printing the top most node");
            newList.forEach(btn -> System.out.print(" " + btn.value + " " ));
        }
    }

    }
