package com.dsproblems.tree;

public class NewTree {
    public class Node {
        public int value;

        public Node left;

        public Node right;

    }

    public Node root;

    public Node AddANode(int value) {
        if (root == null) {
            Node firstnode = new Node();
            firstnode.value = value;
            firstnode.left = null;
            firstnode.right = null;
            root = firstnode;
        } else {
            Node temp = root;
            Node newNode = new Node();
            newNode.value = value;
            newNode.left = null;
            newNode.right = null;
            while (temp.left != null && temp.value > value) {
                temp = temp.left;
            }
            while (temp.right != null && temp.value < value) {
                temp = temp.right;
            }
            if (temp.right == null && temp.value > value) {
                temp.right = newNode;
            }
            if (temp.left != null && temp.value > value) {
                temp.left = newNode;
            }
        }
        return root;
    }

    public void inOrderReversal(Node node){

        if(node == null){
            return;
        }
        inOrderReversal(node.left);
        System.out.println(node.value);
        inOrderReversal(node.right);
    }

    public static void main(){
        NewTree tree = new NewTree();
        tree.AddANode(10);
        tree.AddANode(11);
        tree.AddANode(9);
        tree.inOrderReversal(tree.root);
    }
}

