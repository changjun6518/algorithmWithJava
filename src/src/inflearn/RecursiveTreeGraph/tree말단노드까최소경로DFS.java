package inflearn.RecursiveTreeGraph;

public class tree말단노드까최소경로DFS {

    static Node root;

    public static int DFS(int L, Node node) {
        if (node.rt == null && node.lt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, node.lt), DFS(L + 1, node.rt));
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        System.out.println(DFS(0, root));
    }
}
