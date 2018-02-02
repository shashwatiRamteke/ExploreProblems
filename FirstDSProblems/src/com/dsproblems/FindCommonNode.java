package com.dsproblems;

import javax.xml.soap.Node;

public class FindCommonNode {

    static class Tree{
        BinaryTreeNode head = null;

        public void addElement(Integer newValue){
            if(head == null){
                head = new BinaryTreeNode();
                head.value = newValue;
                head.left = null;
                head.right = null;
            }
            else
            {
                BinaryTreeNode travseNode = head;
                while(true){
                    if(travseNode.value > newValue && travseNode.left != null){
                        travseNode = travseNode.left;
                    }else if(travseNode.value <= newValue && travseNode.right != null){
                        travseNode = travseNode.right;
                    }else
                    {
                        break;
                    }
                }
                BinaryTreeNode newNode = new BinaryTreeNode();
                newNode.value = newValue;
                newNode.left = null;
                newNode.right = null;

                if(travseNode.value > newValue && travseNode.left == null){
                    travseNode.left = newNode;
                }
                if(travseNode.value <= newValue && travseNode.right == null){
                    travseNode.right = newNode;
                }
            }
        }

        public void printInOrderTree(BinaryTreeNode currNode)
        {
            if(currNode == null){
                return;
            }
            printInOrderTree(currNode.left);
            System.out.println(currNode.value);
            printInOrderTree(currNode.right);
        }

        public boolean checkIfNodeExist(BinaryTreeNode node, Integer currValueNode){
            if(node == null)
                return false;
            if(node.value == currValueNode)
                return true;

            return (checkIfNodeExist(node.left,currValueNode) || checkIfNodeExist(node.right,currValueNode));
        }

        public BinaryTreeNode returnCommonAncestor(BinaryTreeNode currNode, Integer p,Integer q){

           if(currNode == null)
               return null;

            if(currNode.value ==p || currNode.value ==q){
                return currNode;
            }

            boolean isPAtLeft = checkIfNodeExist(currNode.left,p);
            boolean isQAtleft = checkIfNodeExist(currNode.left, q);

            if(isPAtLeft != isQAtleft) {
                return currNode;
            }

            if(isPAtLeft == isPAtLeft && isPAtLeft)
            {
                if(currNode.left.value == p || currNode.left.value == q)
                    return currNode;

            }

            if(isPAtLeft == isPAtLeft && !isPAtLeft)
            {
                if(currNode.right.value == p || currNode.right.value == q)
                    return currNode;
            }

            return isPAtLeft ? returnCommonAncestor(currNode.left,p,q) : returnCommonAncestor(currNode.right,p,q) ;

        }

        public void printANodeToRoot(Integer currValueNode){
            boolean leftNodeCheck = checkIfNodeExist(head.left, currValueNode);
            boolean rightNodeCheck = checkIfNodeExist(head.right, currValueNode);
            if(leftNodeCheck)
            {
                System.out.println("Its at left");

            }else if(rightNodeCheck){
                System.out.println("Its at right");
            }
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

        newTree.printANodeToRoot(5);
        newTree.printANodeToRoot(15);
        BinaryTreeNode parentNode = newTree.returnCommonAncestor(newTree.head,17,16);
        System.out.println(parentNode.value);

    }

}
