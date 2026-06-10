package org.g1rix.config.nonlineardatastructure;

public class BinaryTree {

    Node root;
    class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinaryTree(int d){
        root = new Node(d);
    }
    public void insertLeft(Node l, int val){
        Node newNode = new Node(val);
        l.left = newNode;
    }
    public void insertRight(Node r, int val){
        Node newNode = new Node(val);
        r.right = newNode;
    }

    public static void preOrder(Node root){
        if (root != null){
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
        }
    }

    public static void inOrder(Node root){
        if (root != null){
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
        }
    }

    public static void postOrder(Node root){
        if (root != null){
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
        }
    }

}
