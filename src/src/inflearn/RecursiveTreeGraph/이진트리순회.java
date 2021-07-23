package inflearn.RecursiveTreeGraph;

import com.sun.security.jgss.GSSUtil;

public class 이진트리순회 {
    static Node root;

    public static void preorder(Node node) {
        System.out.print(node.data + " ");
        if (node.lt != null) {
            preorder(node.lt);
        }
        if (node.rt != null) {
            preorder(node.rt);
        }
    }

    public static void inorder(Node node) {
        if (node.lt != null) {
            inorder(node.lt);
        }
        System.out.print(node.data + " ");
        if (node.rt != null) {
            inorder(node.rt);
        }
    }

    public static void postorder(Node node) {
        if (node.lt != null) {
            postorder(node.lt);
        }
        if (node.rt != null) {
            postorder(node.rt);
        }
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

}

class Node {
    int data;
    Node lt, rt;
    public Node(int value) {
        data = value;
        lt = rt = null;
    }
}