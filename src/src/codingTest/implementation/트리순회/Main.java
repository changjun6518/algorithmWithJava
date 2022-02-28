package codingTest.implementation.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node> nodes = new ArrayList<>();
    static ArrayList<Integer> inorderResult = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes.get(index).fillNode(left, right);
        }
        inorder(nodes.get(1));
        similarInorder(nodes.get(1));

    }

    private static void inorder(Node node) {
        if (node.left != null) {
            inorder(node.left);
        }

        inorderResult.add(node.index);

        if (node.right != null) {
            inorder(node.right);
        }
    }

    private static void similarInorder(Node node) {
        if (node.left != null) {
            count++;
            similarInorder(node.left);
            count++;
        }

        if (node.index == inorderResult.get(inorderResult.size() - 1)) {
            System.out.println(count);
        }

        if (node.right != null) {
            count++;
            similarInorder(node.right);
            count++;
        }
    }

    private static class Node {
        int index;
        Node left = null;
        Node right = null;

        public Node(int index) {
            this.index = index;
        }

        public void fillNode(int left, int right) {
            if (left != -1) {
                this.left = nodes.get(left);
            }

            if (right != -1) {
                this.right = nodes.get(right);
            }
        }
    }
}
