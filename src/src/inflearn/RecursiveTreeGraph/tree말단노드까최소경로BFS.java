package inflearn.RecursiveTreeGraph;

import java.util.LinkedList;

public class tree말단노드까최소경로BFS {
    static Node root;

    public static int BFS(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                if (temp.rt == null && temp.lt == null) {
                    return L;
                }
                queue.offer(temp.lt);
                queue.offer(temp.rt);
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
//        root.lt.lt = new Node(4);
//        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        root.rt.rt.rt = new Node(8);
        System.out.println(BFS(root));
    }
}
