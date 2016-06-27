package alg.tree.binary;

public class Node {

    int key;
    private String value;

    Node left;
    Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, String value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
